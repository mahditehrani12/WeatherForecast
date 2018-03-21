package ir.mahdiha.weatherforecast.Forecast;

import ir.mahdiha.weatherforecast.Forecast.entity.Pollution.PollutionResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PollutionApi
{
    @GET("feed/geo:35.7;51.3/?token=0f94af90e5646151c52d0d5d3f53696c3f217e00")
    Call<PollutionResponse> getPollution();
}

