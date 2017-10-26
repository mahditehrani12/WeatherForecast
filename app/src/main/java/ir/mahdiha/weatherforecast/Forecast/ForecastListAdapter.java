package ir.mahdiha.weatherforecast.Forecast;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ir.mahdiha.weatherforecast.R;

public class ForecastListAdapter extends BaseAdapter
{

    private static final String TAG_DEBUG = ForecastListAdapter.class.getSimpleName();

    private List<ForecastListItem> mForecastListItemList;

    public ForecastListAdapter(List<ForecastListItem> forecastListItemList)
    {
        this.mForecastListItemList = forecastListItemList;
    }

    @Override
    public int getCount()
    {
        return mForecastListItemList.size();
    }

    @Override
    public Object getItem(int i)
    {
        mForecastListItemList.get(i);
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.i(TAG_DEBUG , "Application Is In getView Method");

        if ( convertView == null )
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listview_forecast,parent,false);
        }

        ForecastListItem Item = mForecastListItemList.get(position);

        TextView dateTV = convertView.findViewById(R.id.rowListView_textView_date);
        TextView weatherConditionTV = convertView.findViewById(R.id.rowListView_textView_weatherCondition);
        ImageView weatherConditionIM = convertView.findViewById(R.id.rowListView_simpleDraweeView_weatherConditionIcon);
        TextView morningTempratureTV = convertView.findViewById(R.id.rowListView_textView_morningTemprature);
        TextView dayTempratureTV = convertView.findViewById(R.id.rowListView_textView_dayTemprature);
        TextView eveningTempratureTV = convertView.findViewById(R.id.rowListView_textView_eveningTemprature);
        TextView nightTempratureTV = convertView.findViewById(R.id.rowListView_textView_nightTemprature);

        View dailyTempratureRangeInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_dailyTempratureRange);
        TextView dailyTempratureRangeTitleTV = dailyTempratureRangeInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView dailyTempratureRangeValueTV = dailyTempratureRangeInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

        View cloudinessPercentInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_cloudinessPercent);
        TextView cloudinessPercentTitleTV = cloudinessPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView cloudinessPercentValueTV = cloudinessPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

        View atmosphericPressureInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_atmosphericPressure);
        TextView atmosphericPressureTitleTV = atmosphericPressureInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView atmosphericPressureValueTV = atmosphericPressureInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

        View humidityPercentInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_humidityPercent);
        TextView humidityPercentTitleTV = humidityPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView humidityPercentValueTV = humidityPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

        View windSpeedInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_windSpeed);
        TextView windSpeedTitleTV = windSpeedInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView windSpeedValueTV = windSpeedInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

        View windDirectionInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_windDirection);
        TextView windDirectionTitleTV = windDirectionInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
        TextView windDirectionValueTV = windDirectionInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);


        dateTV.setText(Item.getData());
        weatherConditionTV.setText(Item.getWeatherCondition());
        weatherConditionIM.setImageResource(Item.getWeatherConditionIcon());


        morningTempratureTV.setText(String.valueOf(Item.getMorningTemprature()));
        dayTempratureTV.setText(String.valueOf(Item.getDayTemprature()));
        eveningTempratureTV.setText(String.valueOf(Item.getEveningTemprature()));
        nightTempratureTV.setText(String.valueOf(Item.getNightTemprature()));


        dailyTempratureRangeTitleTV.setText(R.string.dailyTempratureRange);
        dailyTempratureRangeValueTV.setText(String.valueOf(Item.getMinDailyTemprature())+ " - " + String.valueOf(Item.getMaxDailyTemprature()));

        cloudinessPercentTitleTV.setText(R.string.cloudinessPercent);
        cloudinessPercentValueTV.setText(String.valueOf(Item.getCloudinessPercent()));

        atmosphericPressureTitleTV.setText(R.string.atmosphericPressure);
        atmosphericPressureValueTV.setText(String.valueOf(Item.getAtmosphericPressure()));

        humidityPercentTitleTV.setText(R.string.humidityPercent);
        humidityPercentValueTV.setText(String.valueOf(Item.getHumidityPercent()));

        windSpeedTitleTV.setText(R.string.windSpeed);
        windSpeedValueTV.setText(String.valueOf(Item.getWindSpeed()));

        windDirectionTitleTV.setText(R.string.windDirection);
        windDirectionValueTV.setText(String.valueOf(Item.getWindDirection()));

        return convertView;

    }
}