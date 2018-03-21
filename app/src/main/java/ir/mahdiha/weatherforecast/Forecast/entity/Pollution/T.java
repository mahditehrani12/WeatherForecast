
package ir.mahdiha.weatherforecast.Forecast.entity.Pollution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class T {

    @SerializedName("v")
    @Expose
    private double v;

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

}
