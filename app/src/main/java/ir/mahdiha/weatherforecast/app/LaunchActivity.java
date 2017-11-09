 package ir.mahdiha.weatherforecast.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.mahdiha.weatherforecast.Forecast.ForecastActivity;
import ir.mahdiha.weatherforecast.R;
import ir.mahdiha.weatherforecast.helper.HelperFunctions;

 public class LaunchActivity extends AppCompatActivity
{

    public static void start(Context starter)
    {
        Intent intent = new Intent(starter, LaunchActivity.class);
        starter.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        if ( HelperFunctions.isNetworkConnected(this))
        {
            ForecastActivity.start(this);
            finish();
        } else {
            NoNetworkActivity.start(this , LaunchActivity.class.getSimpleName());
            finish();
        }

    }
}