package ir.mahdiha.weatherforecast.app;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application
{

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String BASE_URL_POLLUTION = "https://api.waqi.info/";

    private Retrofit mRetrofit;
    private Retrofit mRetrofitPollution;

    private static App sApp;

    @Override
    public void onCreate()
    {
        super.onCreate();
        sApp = this;
    }

    public static App getApplication()
    {
        return sApp;
    }

    public Retrofit getRetrofit()
    {
        if ( mRetrofit == null )
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public Retrofit getmRetrofitPollution()
    {
        if ( mRetrofitPollution == null )
        {
            mRetrofitPollution = new Retrofit.Builder()
                    .baseUrl(BASE_URL_POLLUTION)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofitPollution;
    }

}
