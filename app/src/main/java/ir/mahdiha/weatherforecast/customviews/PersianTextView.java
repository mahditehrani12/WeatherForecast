package ir.mahdiha.weatherforecast.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class PersianTextView extends android.support.v7.widget.AppCompatTextView
{
    public PersianTextView(Context context)
    {
        super(context);
        init();
    }

    public PersianTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public PersianTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/IRANSansMobile.ttf");
        setTypeface(typeface);
    }

}
