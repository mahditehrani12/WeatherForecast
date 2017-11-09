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

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getWeatherCondition()
    {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition)
    {
        this.weatherCondition = weatherCondition;
    }

    public int getWeatherConditionIcon() { return weatherConditionIcon; }

    public void setWeatherConditionIcon(int weatherConditionIcon)
    {
        this.weatherConditionIcon = weatherConditionIcon;
    }

    public String getMorningTemprature()
    {
        return morningTemprature;
    }

    public void setMorningTemprature(String morningTemprature)
    {
        this.morningTemprature = morningTemprature;
    }

    public String getDayTemprature()
    {
        return dayTemprature;
    }

    public void setDayTemprature(String dayTemprature)
    {
        this.dayTemprature = dayTemprature;
    }

    public String getEveningTemprature()
    {
        return eveningTemprature;
    }

    public void setEveningTemprature(String eveningTemprature)
    {
        this.eveningTemprature = eveningTemprature;
    }

    public String getNightTemprature()
    {
        return nightTemprature;
    }

    public void setNightTemprature(String nightTemprature)
    {
        this.nightTemprature = nightTemprature;
    }

    public String getMinDailyTemprature()
    {
        return minDailyTemprature;
    }

    public void setMinDailyTemprature(String minDailyTemprature)
    {
        this.minDailyTemprature = minDailyTemprature;
    }

    public String getMaxDailyTemprature()
    {
        return maxDailyTemprature;
    }

    public void setMaxDailyTemprature(String maxDailyTemprature)
    {
        this.maxDailyTemprature = maxDailyTemprature;
    }

    public String getCloudinessPercent()
    {
        return cloudinessPercent;
    }

    public void setCloudinessPercent(String cloudinessPercent)
    {
        this.cloudinessPercent = cloudinessPercent;
    }

    public String getAtmosphericPressure()
    {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(String atmosphericPressure)
    {
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getHumidityPercent()
    {
        return humidityPercent;
    }

    public void setHumidityPercent(String humidityPercent)
    {
        this.humidityPercent = humidityPercent;
    }

    public String getWindSpeed()
    {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection()
    {
        return windDirection;
    }

    public void setWindDirection(String windDirection)
    {
        this.windDirection = windDirection;
    }
}
