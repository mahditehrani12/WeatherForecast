
package ir.mahdiha.weatherforecast.Forecast.entity.Pollution;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("aqi")
    @Expose
    private int aqi;
    @SerializedName("idx")
    @Expose
    private int idx;
    @SerializedName("attributions")
    @Expose
    private List<Attribution> attributions = null;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("dominentpol")
    @Expose
    private String dominentpol;
    @SerializedName("iaqi")
    @Expose
    private Iaqi iaqi;
    @SerializedName("time")
    @Expose
    private Time time;

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public List<Attribution> getAttributions() {
        return attributions;
    }

    public void setAttributions(List<Attribution> attributions) {
        this.attributions = attributions;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDominentpol() {
        return dominentpol;
    }

    public void setDominentpol(String dominentpol) {
        this.dominentpol = dominentpol;
    }

    public Iaqi getIaqi() {
        return iaqi;
    }

    public void setIaqi(Iaqi iaqi) {
        this.iaqi = iaqi;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
