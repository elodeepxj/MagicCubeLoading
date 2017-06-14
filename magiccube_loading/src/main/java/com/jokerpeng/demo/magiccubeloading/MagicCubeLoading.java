package com.jokerpeng.demo.magiccubeloading;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by PengXiaoJie on 2017/6/14.10 17..
 */

public class MagicCubeLoading extends Dialog {
    private Context mContext;
    private enum Direction{
        HORIZONTAL,VERTICAL;
    }
    private LinearLayout linearLayout1,linearLayout2,linearLayout3;
    private ImageView iv_11,iv_12,iv_13,iv_21,iv_22,iv_23,iv_31,iv_32,iv_33;
    private Direction direction;
    private ObjectAnimator animator;

    public MagicCubeLoading(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MagicCubeLoading(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected MagicCubeLoading(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_magiccube,null);
        initView(view);
        direction = Direction.HORIZONTAL;

        setCanceledOnTouchOutside(false);
        setContentView(view);
        setPadding(direction);
        startAnimation(direction);

    }

    private void setPadding(Direction direction){
        if(direction.equals(Direction.HORIZONTAL)){
            linearLayout2.setPadding(0,mContext.getResources().getDimensionPixelOffset(R.dimen.space),0,mContext.getResources().getDimensionPixelOffset(R.dimen.space));
            LinearLayout.LayoutParams layout = (LinearLayout.LayoutParams) iv_12.getLayoutParams();
            layout.setMargins(mContext.getResources().getDimensionPixelOffset(R.dimen.space), 0, mContext.getResources().getDimensionPixelOffset(R.dimen.space), 0);  //设置间距
            iv_12.setLayoutParams(layout);
            iv_22.setLayoutParams(layout);
            iv_32.setLayoutParams(layout);
//            iv_13.setLayoutParams(layout);
//            iv_23.setLayoutParams(layout);
//            iv_33.setLayoutParams(layout);
        }else if(direction.equals(Direction.VERTICAL)){

        }
    }

    private void startAnimation(Direction direction) {
        if(direction.equals(Direction.HORIZONTAL)){
            animator = ObjectAnimator.ofFloat(linearLayout1,"rotationY",0,180);
            animator.setDuration(2000);
            animator.start();
        }else if(direction.equals(Direction.VERTICAL)) {
            animator = ObjectAnimator.ofFloat(linearLayout1,"rotationX",0,180);
            animator.setDuration(2000);
            animator.start();
        }
    }

    private void initView(View view) {
        linearLayout1 = (LinearLayout) view.findViewById(R.id.linearlayout1);
        linearLayout2 = (LinearLayout) view.findViewById(R.id.linearlayout2);
        linearLayout3 = (LinearLayout) view.findViewById(R.id.linearlayout3);
        iv_11 = (ImageView) view.findViewById(R.id.iv_linear1_1);
        iv_12 = (ImageView) view.findViewById(R.id.iv_linear1_2);
        iv_13 = (ImageView) view.findViewById(R.id.iv_linear1_3);
        iv_21 = (ImageView) view.findViewById(R.id.iv_linear2_1);
        iv_22 = (ImageView) view.findViewById(R.id.iv_linear2_2);
        iv_23 = (ImageView) view.findViewById(R.id.iv_linear2_3);
        iv_31 = (ImageView) view.findViewById(R.id.iv_linear3_1);
        iv_32 = (ImageView) view.findViewById(R.id.iv_linear3_2);
        iv_33 = (ImageView) view.findViewById(R.id.iv_linear3_3);
    }


    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        startAnimation(direction);
        return true;
    }
}
