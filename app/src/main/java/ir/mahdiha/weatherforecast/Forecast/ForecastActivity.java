package ir.mahdiha.weatherforecast.Forecast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import ir.mahdiha.weatherforecast.Forecast.entity.ApiResponse;
import ir.mahdiha.weatherforecast.Forecast.entity.List;
import ir.mahdiha.weatherforecast.R;
import ir.mahdiha.weatherforecast.app.AboutActivity;
import ir.mahdiha.weatherforecast.app.App;
import ir.mahdiha.weatherforecast.helper.ConvertDateHelper;
import ir.mahdiha.weatherforecast.helper.HelperFunctions;
import ir.mahdiha.weatherforecast.helper.ScreenSizeUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ForecastActivity extends AppCompatActivity
{

    private static final String TAG_DEBUG = ForecastActivity.class.getSimpleName();

    private ListView mForecastListListView;
    private ForecastListAdapter mForecastListAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private String getMorn;
    private String getDay;
    private String getEve;
    private String getNight;

    private ArrayList<ForecastListItem> mForecastListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activityForecast_ToolBar_toolbar);
        setSupportActionBar(toolbar);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activityContentMain_swipeRefreshLayout_swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorSwipeRefresh));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if ( HelperFunctions.isNetworkConnected(ForecastActivity.this))
                        {
                            swipeRefreshLayout.setRefreshing(false);
                            mForecastListAdapter.notifyDataSetChanged();
                            Toast.makeText(ForecastActivity.this , "لیست آب و هوا بروز شد" , Toast.LENGTH_SHORT).show();
                        } else {
                            swipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(ForecastActivity.this , "لطفا ابتدا به اینترنت متصل شوید" , Toast.LENGTH_LONG).show();
                        }
                    }
                } , 3000 );
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }).start();

        findViews();
        initRecyclerView();

    }

    public static void start(Context context)
    {
        Intent starter = new Intent( context , ForecastActivity.class);
        context.startActivity(starter);
    }

    private void findViews()
    {
        mForecastListListView = (ListView) findViewById(R.id.activityForecast_listView_forecastList);
    }

    public void aboutActivityIntent()
    {
        Intent aboutActivityIntent = new Intent( ForecastActivity.this , AboutActivity.class);
        startActivity(aboutActivityIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_about){aboutActivityIntent();}
        if (id == R.id.action_contactMe){}

        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView()
    {

        mForecastListAdapter = new ForecastListAdapter(mForecastListItems);
        mForecastListListView.setAdapter(mForecastListAdapter);

    }

    private void loadData()
    {
        Log.i(TAG_DEBUG, " Program Is In loadData Method ");

        Retrofit retrofit = App.getApplication().getRetrofit();
        ForecastApi api = retrofit.create(ForecastApi.class);
        Call<ApiResponse> call = api.getForecastList( 112931 , 14 );
        call.enqueue(new Callback<ApiResponse>()
        {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response)
            {
                if (response.code() == 200)
                {
                    ApiResponse apiResponse = response.body();
                    assert apiResponse != null;
                    java.util.List<List> list = apiResponse.getList();

                    for (List listItem : list )
                    {
                        Log.i(TAG_DEBUG , "Application Is In For loop");
                        ForecastListItem Item1 = new ForecastListItem();

                        Item1.setData(HelperFunctions.convertDateToPersian(ConvertDateHelper.getCurrentShamsidate(HelperFunctions.convertEpochToHumanReadableDate(listItem.getDt()))));
                        Item1.setWeatherCondition(listItem.getWeather().get(0).getDescription());

                        Log.e(TAG_DEBUG , ConvertDateHelper.getCurrentShamsidate());

                        if ( Objects.equals ( listItem.getWeather().get(0).getDescription() , "آسمان صاف" ))
                        { Item1.setWeatherConditionIcon(R.drawable.sunicon); }
                        else if (Objects.equals ( listItem.getWeather().get(0).getDescription() , "بارش خفیف باران" ))
                        { Item1.setWeatherConditionIcon(R.drawable.cloudicon); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "بارش باران" ))
                        { Item1.setWeatherConditionIcon(R.drawable.rainicon); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "پوشیده از ابر" ))
                        { Item1.setWeatherConditionIcon(R.drawable.cloudy);}
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "بارش خیلی شدید باران"))
                        { Item1.setWeatherConditionIcon(R.drawable.raininghigh);}
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "کمی ابری"))
                        { Item1.setWeatherConditionIcon(R.drawable.lowcloudicon); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "ابرهای پارچه پارچه شده"))
                        { Item1.setWeatherConditionIcon(R.drawable.onedriveicon); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "ابرهای پراکنده"))
                        { Item1.setWeatherConditionIcon(R.drawable.onedriveicon); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "بارش خفیف برف"))
                        { Item1.setWeatherConditionIcon(R.drawable.snow); }
                        else if (Objects.equals(listItem.getWeather().get(0).getDescription() , "برف"))
                        { Item1.setWeatherConditionIcon(R.drawable.snowing); }


                        getMorn = String.valueOf(listItem.getTemp().getMorn());
                        getDay = String.valueOf(listItem.getTemp().getDay());
                        getEve = String.valueOf(listItem.getTemp().getEve());
                        getNight = String.valueOf(listItem.getTemp().getNight());

                        Item1.setMorningTemprature(" " + HelperFunctions.convertDateToPersian(getMorn) + " " + getResources().getString(R.string.degree));
                        Item1.setDayTemprature(" " + HelperFunctions.convertDateToPersian(getDay) + " " + getResources().getString(R.string.degree));
                        Item1.setEveningTemprature(" " + HelperFunctions.convertDateToPersian(getEve) + " " + getResources().getString(R.string.degree));
                        Item1.setNightTemprature(" " + HelperFunctions.convertDateToPersian(getNight) + " " + getResources().getString(R.string.degree));

                        Item1.setMinDailyTemprature(HelperFunctions.convertDateToPersian(String.valueOf ((int) listItem.getTemp().getMin())));
                        Item1.setMaxDailyTemprature(HelperFunctions.convertDateToPersian(String.valueOf ((int) listItem.getTemp().getMax())));

                        Item1.setCloudinessPercent(HelperFunctions.convertDateToPersian(String.valueOf(listItem.getClouds()) + " % " ));
                        Item1.setHumidityPercent(HelperFunctions.convertDateToPersian(String.valueOf(listItem.getHumidity()) + " % " ));
                        Item1.setWindDirection(HelperFunctions.convertDateToPersian( String.valueOf(listItem.getDeg()) + " درجه " ));

                        Item1.setAtmosphericPressure(HelperFunctions.convertDateToPersian ( String.valueOf ((int) listItem.getPressure()) + " hPa " ));
                        Item1.setWindSpeed(HelperFunctions.convertDateToPersian( String.valueOf ((int) listItem.getSpeed()) + " m/s " ));

//                      Screen Utils
                        ScreenSizeUtils mScreenUtils = new ScreenSizeUtils(ForecastActivity.this);
                        String DensityDPI = mScreenUtils.GET_widthxheight_dp();
                        Log.e(TAG_DEBUG , "Screen Size in DP : " + DensityDPI );
                        String DensityPX = mScreenUtils.GET_widthxheight_px();
                        Log.e(TAG_DEBUG , "Screen Size in PX : " + DensityPX);

                        String ScreenDensity = ScreenSizeUtils.getDensityName(ForecastActivity.this);
                        Log.e(TAG_DEBUG , "Screen Density : " + ScreenDensity );

                        mForecastListItems.add(Item1);
                        Log.i(TAG_DEBUG , " Response Get Successfully ");
                    }
                    mForecastListAdapter.notifyDataSetChanged();
            }}

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable throwable)
            {
                Log.i(TAG_DEBUG , "Getting Response Failed ! ");

                if (throwable instanceof IOException)
                {
                    Log.i(TAG_DEBUG , "Connection Problem !");
                }

            }
        });
}}