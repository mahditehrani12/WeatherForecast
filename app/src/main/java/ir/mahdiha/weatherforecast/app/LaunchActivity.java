 package ir.mahdiha.weatherforecast.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
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

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if ( HelperFunctions.isNetworkConnected(getApplicationContext()))
                {
                    ForecastActivity.start(getApplicationContext());
                    finish();
                } else {
                    NoNetworkActivity.start(getApplicationContext() , LaunchActivity.class.getSimpleName());
                    finish();
                }
            }
        } , 1500 );

        boolean isFirstTime = HelperFunctions.isFirstTimeRun(getApplicationContext());

        if (isFirstTime) {
            Log.e(TAG_DEBUG, "This The First Time Application Is Running");
            Toast.makeText(getApplicationContext(), "Welcome To The Weather Forecast Application", Toast.LENGTH_LONG).show();
        } else {
            Log.e(TAG_DEBUG , "This is Not The First Time Application Is Running");
        }



    }
}