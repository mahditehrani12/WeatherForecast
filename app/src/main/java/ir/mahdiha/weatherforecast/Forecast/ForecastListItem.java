package ir.mahdiha.weatherforecast.Forecast;

public class ForecastListItem
{
    private String data;
    private String weatherCondition;
    private int weatherConditionIcon;

    private String morningTemprature;
    private String dayTemprature;
    private String eveningTemprature;
    private String nightTemprature;

    private String minDailyTemprature;
    private String maxDailyTemprature;

    private String cloudinessPercent;
    private String atmosphericPressure;
    private String humidityPercent;
    private String windSpeed;
    private String windDirection;

    private String pollution;

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    String getWeatherCondition()
    {
        return weatherCondition;
    }

    void setWeatherCondition(String weatherCondition)
    {
        this.weatherCondition = weatherCondition;
    }

    int getWeatherConditionIcon() { return weatherConditionIcon; }

    void setWeatherConditionIcon(int weatherConditionIcon)
    {
        this.weatherConditionIcon = weatherConditionIcon;
    }

    String getMorningTemprature()
    {
        return morningTemprature;
    }

    void setMorningTemprature(String morningTemprature)
    {
        this.morningTemprature = morningTemprature;
    }

    String getDayTemprature()
    {
        return dayTemprature;
    }

    void setDayTemprature(String dayTemprature)
    {
        this.dayTemprature = dayTemprature;
    }

    String getEveningTemprature()
    {
        return eveningTemprature;
    }

    void setEveningTemprature(String eveningTemprature)
    {
        this.eveningTemprature = eveningTemprature;
    }

    String getNightTemprature()
    {
        return nightTemprature;
    }

    void setNightTemprature(String nightTemprature)
    {
        this.nightTemprature = nightTemprature;
    }

    String getMinDailyTemprature()
    {
        return minDailyTemprature;
    }

    void setMinDailyTemprature(String minDailyTemprature)
    {
        this.minDailyTemprature = minDailyTemprature;
    }

    String getMaxDailyTemprature()
    {
        return maxDailyTemprature;
    }

    void setMaxDailyTemprature(String maxDailyTemprature)
    {
        this.maxDailyTemprature = maxDailyTemprature;
    }

    String getCloudinessPercent()
    {
        return cloudinessPercent;
    }

    void setCloudinessPercent(String cloudinessPercent)
    {
        this.cloudinessPercent = cloudinessPercent;
    }

    String getAtmosphericPressure()
    {
        return atmosphericPressure;
    }

    void setAtmosphericPressure(String atmosphericPressure)
    {
        this.atmosphericPressure = atmosphericPressure;
    }

    String getHumidityPercent()
    {
        return humidityPercent;
    }

    void setHumidityPercent(String humidityPercent)
    {
        this.humidityPercent = humidityPercent;
    }

    String getWindSpeed()
    {
        return windSpeed;
    }

    void setWindSpeed(String windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    String getWindDirection()
    {
        return windDirection;
    }

    void setWindDirection(String windDirection)
    {
        this.windDirection = windDirection;
    }
}
