
package ir.mahdiha.weatherforecast.Forecast.entity.Pollution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class P {

    @SerializedName("v")
    @Expose
    private int v;

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

}
