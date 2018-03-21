
package ir.mahdiha.weatherforecast.Forecast.entity.Pollution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("tz")
    @Expose
    private String tz;
    @SerializedName("v")
    @Expose
    private int v;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

}
