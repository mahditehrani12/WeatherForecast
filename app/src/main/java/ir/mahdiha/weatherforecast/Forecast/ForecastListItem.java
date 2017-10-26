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

    private int minDailyTemprature;
    private int maxDailyTemprature;

    private int cloudinessPercent;
    private int atmosphericPressure;
    private int humidityPercent;
    private float windSpeed;
    private int windDirection;

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

    public int getMinDailyTemprature()
    {
        return minDailyTemprature;
    }

    public void setMinDailyTemprature(int minDailyTemprature)
    {
        this.minDailyTemprature = minDailyTemprature;
    }

    public int getMaxDailyTemprature()
    {
        return maxDailyTemprature;
    }

    public void setMaxDailyTemprature(int maxDailyTemprature)
    {
        this.maxDailyTemprature = maxDailyTemprature;
    }

    public int getCloudinessPercent()
    {
        return cloudinessPercent;
    }

    public void setCloudinessPercent(int cloudinessPercent)
    {
        this.cloudinessPercent = cloudinessPercent;
    }

    public int getAtmosphericPressure()
    {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(int atmosphericPressure)
    {
        this.atmosphericPressure = atmosphericPressure;
    }

    public int getHumidityPercent()
    {
        return humidityPercent;
    }

    public void setHumidityPercent(int humidityPercent)
    {
        this.humidityPercent = humidityPercent;
    }

    public float getWindSpeed()
    {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection()
    {
        return windDirection;
    }

    public void setWindDirection(int windDirection)
    {
        this.windDirection = windDirection;
    }
}
