package com.project.coordinatortablayout.ui.coordinatorlayout.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.project.coordinatortablayout.R;


public class SampleFooter extends RelativeLayout {

    public SampleFooter(Context context) {
        super(context);
        init(context);
    }

    public SampleFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SampleFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        inflate(context, R.layout.footer_layout_wechat, this);
    }
}