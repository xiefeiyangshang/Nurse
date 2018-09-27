package com.xcz.baselib.weight.banner.hint;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * desc: shape图形
 * Created by xcz
 * on 2018/5/18.
 */
public abstract class ShapeHintView extends LinearLayout implements BaseHintView {

    private ImageView[] mDots;
    private int length = 0;
    private int lastPosition = 0;

    private Drawable dotNormal;
    private Drawable dotFocus;

    public ShapeHintView(Context context){
        super(context);
    }

    public ShapeHintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public abstract Drawable makeFocusDrawable();

    public abstract Drawable makeNormalDrawable();

    @Override
    public void initView(int length, int gravity) {
        removeAllViews();
        lastPosition = 0;
        setOrientation(HORIZONTAL);
        switch (gravity) {
            case 0:
                setGravity(Gravity.START| Gravity.CENTER_VERTICAL);
                break;
            case 1:
                setGravity(Gravity.CENTER);
                break;
            case 2:
                setGravity(Gravity.END| Gravity.CENTER_VERTICAL);
                break;
            default:
                break;
        }

        this.length = length;
        mDots = new ImageView[length];

        dotFocus = makeFocusDrawable();
        dotNormal = makeNormalDrawable();

        for (int i = 0; i < length; i++) {
            mDots[i]=new ImageView(getContext());
            LayoutParams dotlp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            dotlp.setMargins(10, 0, 10, 0);
            mDots[i].setLayoutParams(dotlp);
            mDots[i].setBackgroundDrawable(dotNormal);
            addView(mDots[i]);
        }
        setCurrent(0);
    }

    @Override
    public void setCurrent(int current) {
        if (current < 0 || current > length - 1) {
            return;
        }
        mDots[lastPosition].setBackgroundDrawable(dotNormal);
        mDots[current].setBackgroundDrawable(dotFocus);
        lastPosition = current;
    }
}
