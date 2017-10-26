package ir.mahdiha.weatherforecast.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HelperFunctions
{
    private HelperFunctions() {}

    public static boolean isNetworkConnected( Context context )
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static String convertEpochToHumanReadableDate(long epoch)
    {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(epoch * 1000));
    }

    public static String convertDateToPersian(String date)
    {
        String persianizedStr = "";

        for ( int i = 0 ; i < date.length(); i++)
        {
            int unicode = date.charAt(i);
            int persianizedUnicode;
            if (unicode >= 48 && unicode <= 57)
            {
                persianizedUnicode = unicode + 1728;
            } else if (unicode >= 1632 && unicode <= 1641) {
                persianizedUnicode = unicode + 144;
            } else {
                persianizedUnicode = unicode;
            }
            persianizedStr += (char) persianizedUnicode;
        }
    return persianizedStr;
    }


    public static int StringToInt ( String string )
    {
        return Integer.parseInt(string.trim());
    }

}


















