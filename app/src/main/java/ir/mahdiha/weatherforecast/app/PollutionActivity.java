package ir.mahdiha.weatherforecast.app;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }).start();

    }

    private void loadData()
    {
        final PersianTextView pollutionData = (PersianTextView) findViewById(R.id.activityPollution_persianTextView_pollutionData);

        Retrofit pollutionRetrofit = App.getApplication().getmRetrofitPollution();
        PollutionApi pollutionApi = pollutionRetrofit.create(PollutionApi.class);
        Call<PollutionResponse> pollutionResponseCall = pollutionApi.getPollution();

        pollutionResponseCall.enqueue(new Callback<PollutionResponse>()
        {
            @Override
            public void onResponse(@NonNull Call<PollutionResponse> call , @NonNull Response<PollutionResponse> response)
            {

                PollutionResponse pollutionResponse = response.body();
                assert pollutionResponse != null;
                pollutionData.setText( String.valueOf (pollutionResponse.getData().getAqi()) );

            }

            @Override
            public void onFailure(@NonNull Call<PollutionResponse> call , @NonNull Throwable t)
            {
                Toast.makeText(getApplicationContext() , "خطا در دریافت اطلاعات آلودگی هوا" , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
