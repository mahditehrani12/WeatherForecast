package ir.mahdiha.weatherforecast.helper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HelperFunctions
{
    private HelperFunctions()
    {

    }

    public static boolean isNetworkConnected(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static String convertEpochToHumanReadableDate(long epoch) {
        String format = "yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(epoch * 1000));
    }

    public static String convertDateToPersian(String date) {
        StringBuilder persianizedStr = new StringBuilder();

        for (int i = 0; i < date.length(); i++) {
            int unicode = date.charAt(i);
            int persianizedUnicode;
            if (unicode >= 48 && unicode <= 57) {
                persianizedUnicode = unicode + 1728;
            } else if (unicode >= 1632 && unicode <= 1641) {
                persianizedUnicode = unicode + 144;
            } else {
                persianizedUnicode = unicode;
            }
            persianizedStr.append((char) persianizedUnicode);
        }
        return persianizedStr.toString();
    }

    public static  boolean isFirstTimeRun(Context mContext)
    {
        final String MY_PREFS_NAME = mContext.getApplicationContext().getPackageName() + "myPrefs";
        SharedPreferences prefs = mContext.getSharedPreferences(MY_PREFS_NAME , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mContext.getSharedPreferences(MY_PREFS_NAME , Context.MODE_PRIVATE).edit();
        final String key = mContext.getPackageName() + "isFirstTime";
        boolean isFirstTime = prefs.getBoolean(key , true);
        if (isFirstTime)
        {
            editor.putBoolean(key , false);
            editor.apply();
            return true;
        } else
            return false;
    }

    public static void TelegramIntent(Activity activity , String telegramId)
    {
        Uri uri = Uri.parse("https://t.me/" + telegramId);
        Intent likeIng = new Intent(Intent.ACTION_VIEW , uri);
        likeIng.setPackage("org.telegram.messenger");
        try
        {
            activity.startActivity(likeIng);
        } catch (ActivityNotFoundException e)
        {
            activity.startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("https://t.me/" + telegramId )));
        }
    }

}


















