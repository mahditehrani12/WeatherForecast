package ir.mahdiha.weatherforecast.Forecast;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.mahdiha.weatherforecast.R;

class ForecastListAdapter extends BaseAdapter
{

    private static final String TAG_DEBUG = ForecastListAdapter.class.getSimpleName();

    private List<ForecastListItem> mForecastListItemList;

    ForecastListAdapter(List<ForecastListItem> forecastListItemList)
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

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        Log.i(TAG_DEBUG , "Application Is In getView Method");

        if ( convertView == null )
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listview_forecast,parent,false);

            holder = new ViewHolder();
            convertView.setTag(holder);

            holder.dateTV = convertView.findViewById(R.id.rowListView_textView_date);
            holder.weatherConditionTV = convertView.findViewById(R.id.rowListView_textView_weatherCondition);
            holder.weatherConditionIM = convertView.findViewById(R.id.rowListView_simpleDraweeView_weatherConditionIcon);

            holder.morningTemperatureAxisPointLayout = convertView.findViewById(R.id.rowListView_layout_morningTemperature);
            holder.morningTemperatureLabelTextView = holder.morningTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_title);
            holder.morningTemperatureValueTextView = holder.morningTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_value);

            holder.dayTemperatureAxisPointLayout = convertView.findViewById(R.id.rowListView_layout_dayTemperature);
            holder.dayTemperatureLabelTextView = holder.dayTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_title);
            holder.dayTemperatureValueTextView = holder.dayTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_value);

            holder.eveningTemperatureAxisPointLayout = convertView.findViewById(R.id.rowListView_layout_eveningTemperature);
            holder.eveningTemperatureLabelTextView = holder.eveningTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_title);
            holder.eveningTemperatureValueTextView = holder.eveningTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_value);

            holder.nightTemperatureAxisPointLayout = convertView.findViewById(R.id.rowListView_layout_nightTemperature);
            holder.nightTemperatureLabelTextView = holder.nightTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_title);
            holder.nightTemperatureValueTextView = holder.nightTemperatureAxisPointLayout.findViewById(R.id.layoutTempAxisPoint_textView_value);

            holder.dailyTempratureRangeInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_dailyTempratureRange);
            holder.dailyTempratureRangeTitleTV = holder.dailyTempratureRangeInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.dailyTempratureRangeValueTV = holder.dailyTempratureRangeInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

            holder.cloudinessPercentInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_cloudinessPercent);
            holder.cloudinessPercentTitleTV = holder.cloudinessPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.cloudinessPercentValueTV = holder.cloudinessPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

            holder.atmosphericPressureInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_atmosphericPressure);
            holder.atmosphericPressureTitleTV = holder.atmosphericPressureInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.atmosphericPressureValueTV = holder.atmosphericPressureInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

            holder.humidityPercentInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_humidityPercent);
            holder.humidityPercentTitleTV = holder.humidityPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.humidityPercentValueTV = holder.humidityPercentInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

            holder.windSpeedInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_windSpeed);
            holder.windSpeedTitleTV = holder.windSpeedInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.windSpeedValueTV = holder.windSpeedInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

            holder.windDirectionInfoBoxLayout = convertView.findViewById(R.id.rowListView_layout_windDirection);
            holder.windDirectionTitleTV = holder.windDirectionInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_title);
            holder.windDirectionValueTV = holder.windDirectionInfoBoxLayout.findViewById(R.id.layoutInfoBox_textView_value);

//            holder.pollutionTV = convertView.findViewById(R.id.rowListView_persianTextView_pollution);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ForecastListItem Item = mForecastListItemList.get(position);

        holder.dateTV.setText(Item.getData());
        holder.weatherConditionTV.setText(Item.getWeatherCondition());
        holder.weatherConditionIM.setImageResource(Item.getWeatherConditionIcon());

        holder.morningTemperatureLabelTextView.setText(R.string.MorningTempratureLable);
        holder.morningTemperatureValueTextView.setText(String.valueOf(Item.getMorningTemprature()));

        holder.dayTemperatureLabelTextView.setText(R.string.DayTempratureLable);
        holder.dayTemperatureValueTextView.setText(String.valueOf(Item.getDayTemprature()));

        holder.eveningTemperatureLabelTextView.setText(R.string.EveningTempratureLable);
        holder.eveningTemperatureValueTextView.setText(String.valueOf(Item.getEveningTemprature()));

        holder.nightTemperatureLabelTextView.setText(R.string.NightTempratureLable);
        holder.nightTemperatureValueTextView.setText(String.valueOf(Item.getNightTemprature()));

        holder.dailyTempratureRangeTitleTV.setText(R.string.dailyTempratureRange);
        holder.dailyTempratureRangeValueTV.setText(String.valueOf(Item.getMinDailyTemprature())+ " - " + String.valueOf(Item.getMaxDailyTemprature()));

        holder.cloudinessPercentTitleTV.setText(R.string.cloudinessPercent);
        holder.cloudinessPercentValueTV.setText(String.valueOf(Item.getCloudinessPercent()));

        holder.atmosphericPressureTitleTV.setText(R.string.atmosphericPressure);
        holder.atmosphericPressureValueTV.setText(String.valueOf(Item.getAtmosphericPressure()));

        holder.humidityPercentTitleTV.setText(R.string.humidityPercent);
        holder.humidityPercentValueTV.setText(String.valueOf(Item.getHumidityPercent()));

        holder.windSpeedTitleTV.setText(R.string.windSpeed);
        holder.windSpeedValueTV.setText(String.valueOf(Item.getWindSpeed()));

        holder.windDirectionTitleTV.setText(R.string.windDirection);
        holder.windDirectionValueTV.setText(String.valueOf(Item.getWindDirection()));

        return convertView;
    }

    private static class ViewHolder
    {
        TextView dateTV;
        TextView weatherConditionTV;
        ImageView weatherConditionIM;

        View morningTemperatureAxisPointLayout;
        TextView morningTemperatureLabelTextView;
        TextView morningTemperatureValueTextView;

        View dayTemperatureAxisPointLayout;
        TextView dayTemperatureLabelTextView;
        TextView dayTemperatureValueTextView;

        View eveningTemperatureAxisPointLayout;
        TextView eveningTemperatureLabelTextView;
        TextView eveningTemperatureValueTextView;

        View nightTemperatureAxisPointLayout;
        TextView nightTemperatureLabelTextView;
        TextView nightTemperatureValueTextView;

        View dailyTempratureRangeInfoBoxLayout;
        TextView dailyTempratureRangeTitleTV;
        TextView dailyTempratureRangeValueTV;

        View cloudinessPercentInfoBoxLayout;
        TextView cloudinessPercentTitleTV;
        TextView cloudinessPercentValueTV;

        View atmosphericPressureInfoBoxLayout;
        TextView atmosphericPressureTitleTV;
        TextView atmosphericPressureValueTV;

        View humidityPercentInfoBoxLayout;
        TextView humidityPercentTitleTV;
        TextView humidityPercentValueTV;

        View windSpeedInfoBoxLayout;
        TextView windSpeedTitleTV;
        TextView windSpeedValueTV;

        View windDirectionInfoBoxLayout;
        TextView windDirectionTitleTV;
        TextView windDirectionValueTV;
    }

}