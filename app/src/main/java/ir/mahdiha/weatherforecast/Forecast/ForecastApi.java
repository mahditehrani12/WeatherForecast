package ir.mahdiha.weatherforecast.Forecast;

import ir.mahdiha.weatherforecast.Forecast.entity.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApi
{
    @GET("forecast/daily?units=metric&lang=fa&APPID=913bebceaa8367d09d1da9a134c525ba")
    Call<ApiResponse> getForecastList(@Query("id") int cityCode , @Query("cnt") int count );
}
