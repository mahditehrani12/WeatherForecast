package ir.mahdiha.weatherforecast.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ir.mahdiha.weatherforecast.R;

public class NoNetworkActivity extends AppCompatActivity implements View.OnClickListener
{

    public static void start(Context context)
    {
        Intent starter = new Intent( context , NoNetworkActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_network);

        Button noNetworkWarningBtn = (Button) findViewById(R.id.activityNoNetwork_button_warning);
        noNetworkWarningBtn.setOnClickListener(this);

    }

    private void openNetworkSetting()
    {

        try
        {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View view)
    {
        openNetworkSetting();
    }

}
