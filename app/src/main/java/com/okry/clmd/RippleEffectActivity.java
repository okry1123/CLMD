package com.okry.clmd;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by mr on 15/12/7.
 */
public class RippleEffectActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    View mRippleView;
    CheckBox mEnableCheck;
    CheckBox mRippleMaskCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple_effect);
        mRippleView = findViewById(R.id.view_with_ripple);
        mEnableCheck = (CheckBox) findViewById(R.id.checkbox_enable);
        mRippleMaskCheck = (CheckBox) findViewById(R.id.checkbox_ripple_mask);

        mEnableCheck.setOnCheckedChangeListener(this);
        mRippleMaskCheck.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == mEnableCheck) {
            mRippleView.setEnabled(isChecked);
        } else if (buttonView == mRippleMaskCheck) {
            changeRippleMask(isChecked);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void changeRippleMask(boolean isCheck) {
        Drawable bg = mRippleView.getBackground();
        if (bg instanceof RippleDrawable) {
            RippleDrawable ripple = (RippleDrawable) bg;
            ripple.setDrawableByLayerId(android.R.id.mask,
                    isCheck ? getResources().getDrawable(R.drawable.back) : getResources().getDrawable(android.R.color.white));
        }
    }
}
