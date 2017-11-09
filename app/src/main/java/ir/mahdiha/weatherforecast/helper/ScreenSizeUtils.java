package ir.mahdiha.weatherforecast.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenSizeUtils
{
    private Context mContext;
    private WindowManager mWindowManager;
    private Display mDisplay;
    private Configuration mConfig;
    private DisplayMetrics mDisplayMetrics , mRealDisplayMetrics;

    private static final int mHelperAttr = -255;

    private int width_px , height_px;
    private int width_dp , height_dp;

    private String widthxheight_px;
    private String widthxheight_dp;

    public ScreenSizeUtils(Context mContext)
    {
        this.mContext = mContext;
        init();
    }

    private void init()
    {
        mWindowManager = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE));
        mDisplay = mWindowManager.getDefaultDisplay();
        mConfig = mContext.getResources().getConfiguration();
        mDisplayMetrics = new DisplayMetrics();
        mDisplay.getMetrics(mDisplayMetrics);

        mRealDisplayMetrics = new DisplayMetrics();
        mDisplay.getRealMetrics(mRealDisplayMetrics);
    }

    public String GET_widthxheight_px()
    {
        Point mPoint = new Point();
        mDisplay.getSize(mPoint);
        width_px = mPoint.x;
        height_px = mPoint.y;

        widthxheight_px = width_px + " x " + height_px;
        return widthxheight_px;
    }

    public String GET_widthxheight_dp()
    {
        int real_height_px;

        real_height_px = mRealDisplayMetrics.heightPixels;

        height_dp = (int) (((double) ((real_height_px == mHelperAttr) ? height_px
                : real_height_px) / mDisplayMetrics.density) + 0.5);

        width_dp = mConfig.screenWidthDp;

        widthxheight_dp = width_dp + " x " + height_dp;
        return widthxheight_dp;
    }

    public static String getDensityName(Context context)
    {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }

}