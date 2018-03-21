package ir.mahdiha.weatherforecast.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import ir.mahdiha.weatherforecast.Forecast.PollutionApi;
import ir.mahdiha.weatherforecast.Forecast.entity.Pollution.PollutionResponse;
import ir.mahdiha.weatherforecast.R;
import ir.mahdiha.weatherforecast.customviews.PersianTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PollutionActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pollution);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activityPollution_ToolBar_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }).start();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
    }

    private void loadData()
    {
        final PersianTextView pollutionData = (PersianTextView) findViewById(R.id.activityPollution_persianTextView_pollutionData);
        final PersianTextView pollutionDate = (PersianTextView) findViewById(R.id.activityPollution_persianTextView_date);
        final PersianTextView SO2 = (PersianTextView) findViewById(R.id.activityPollution_persianTextView_so2);
        final PersianTextView O3 = (PersianTextView) findViewById(R.id.activityPollution_persianTextView_O3);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.activityPollution_progressBar_progress);

        Retrofit pollutionRetrofit = App.getApplication().getmRetrofitPollution();
        PollutionApi pollutionApi = pollutionRetrofit.create(PollutionApi.class);
        Call<PollutionResponse> pollutionResponseCall = pollutionApi.getPollution();

        pollutionResponseCall.enqueue(new Callback<PollutionResponse>()
        {
            @Override
            public void onResponse(@NonNull Call<PollutionResponse> call , @NonNull Response<PollutionResponse> response)
            {

                Animation animationFadeIn = AnimationUtils.loadAnimation( getApplicationContext() , R.anim.fade_in );
                Animation animationFadeOut = AnimationUtils.loadAnimation( getApplicationContext() , R.anim.fade_out );

                PollutionResponse pollutionResponse = response.body();
                assert pollutionResponse != null;

                progressBar.setVisibility(View.INVISIBLE);
                progressBar.startAnimation(animationFadeOut);

                pollutionData.setVisibility(View.VISIBLE);
                pollutionData.startAnimation(animationFadeIn);
                pollutionData.setText( String.valueOf (pollutionResponse.getData().getAqi()) );

                pollutionDate.setText(pollutionResponse.getData().getTime().getS());
                SO2.setText( String.valueOf(pollutionResponse.getData().getIaqi().getSo2().getV() ));
                O3.setText( String.valueOf(pollutionResponse.getData().getIaqi().getO3().getV() ));

            }

            @Override
            public void onFailure(@NonNull Call<PollutionResponse> call , @NonNull Throwable t)
            {
                Toast.makeText(getApplicationContext() , "خطا در دریافت اطلاعات آلودگی هوا" , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
