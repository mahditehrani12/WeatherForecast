package ir.mahdiha.weatherforecast.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class PersianButton extends android.support.v7.widget.AppCompatButton
{
    public PersianButton(Context context)
    {
        super(context);
        init();
    }

    public PersianButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public PersianButton(Context context, AttributeSet attrs, int defStyleAttr)
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
