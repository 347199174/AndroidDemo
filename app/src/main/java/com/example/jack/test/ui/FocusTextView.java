package com.example.jack.test.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jack on 15/8/15.
 */
public class FocusTextView extends TextView {

    public FocusTextView(Context context,AttributeSet attributeSet,int defStyle)
    {
        super(context,attributeSet,defStyle);
    }

    public FocusTextView(Context context,AttributeSet attributeSet)
    {
        super(context,attributeSet);
    }

    public FocusTextView(Context context)
    {
        super(context);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
