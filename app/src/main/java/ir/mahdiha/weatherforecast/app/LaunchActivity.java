 package ir.mahdiha.weatherforecast.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import ir.mahdiha.weatherforecast.Forecast.ForecastActivity;
import ir.mahdiha.weatherforecast.R;
import ir.mahdiha.weatherforecast.helper.HelperFunctions;

 public class LaunchActivity extends AppCompatActivity
{

    private static final String TAG_DEBUG = LaunchActivity.class.getSimpleName();

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

//      Is First Time Run
        boolean isFirstTime = HelperFunctions.isFirstTimeRun(getApplicationContext());
        if (isFirstTime) {
            Log.e(TAG_DEBUG, "This The First Time Application Is Running");
            Toast.makeText(getApplicationContext(), "Welcome To The Weather Forecast Application", Toast.LENGTH_LONG).show();
        } else {
            Log.e(TAG_DEBUG , "This is Not The First Time Application Is Running");
        }


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