package com.example.liyuehui.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by LiYueHui on 2017/2/18.
 */

public class DragView extends FrameLayout {
    public String TAG = DragView.class.getSimpleName();
    boolean isAdded;
    private Context context;
    private float startY;
    private int width, height;

    public DragView(Context context) {
        super(context);
        init(context);
    }


    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setBackgroundColor(0xff0000);
//        Log.e(TAG, "init");
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        //应用区域
        Rect outRect1 = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect1);
        int statusBar = dm.heightPixels - outRect1.height();  //状态栏高度=屏幕高度-应用区域高度
        Log.e("WangJ", "状态栏-方法4:" + statusBar);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        return super.onInterceptTouchEvent(ev);
    }

    String getAction(int action) {
        if (action == MotionEvent.ACTION_DOWN) {
            return "ACTION_DOWN";
        } else if (action == MotionEvent.ACTION_MOVE) {
            return "ACTION_MOVE";
        } else if (action == MotionEvent.ACTION_UP) {
            return "ACTION_UP";
        } else if (action == MotionEvent.ACTION_CANCEL) {
            return "ACTION_CANCEL";
        }
        return "dd";
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//        Log.e(TAG, "action:" + getAction(action));
//        width = getWidth();
//        height = getHeight();
//        int[] location = new int[2];
//        getLocationOnScreen(location);
//        int screenX = location[0];
//        int screenY = location[1] -55;
//
////        Log.e(TAG, " width:" + width + " height:" + height + " getX():" +screenX+" getY():" + screenX);
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                startY = event.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float dY = event.getRawY() - startY;
//                float rax = event.getRawX();
////                Log.e(TAG, " dY:" + dY + " y:" + event.getRawY());
//                float getX = event.getX();
//                float getY = event.getY();
//                float getRawx = event.getRawX();
//                float getRawY = event.getRawY();
////                setX(getX);
//                Log.e(TAG, " getX:" + getX + " getY:" + getY + " getRawx:" + getRawx + " getRawY:" + getRawY);
//                if (dY < -10 && !isAdded) {
//                    ViewGroup viewParent = (ViewGroup) this.getParent();
////                    Log.e(TAG, " viewParent:" + viewParentrent);
//                    viewParent.removeView(this);
//                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(width, height);
////                    layoutParams.topMargin = 1000 ;
//                    ((Activity) context).getWindowManager().addView(this,layoutParams);
//                    ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
//                    lp.leftMargin = screenX;
//                    lp.topMargin = (int) (lp.topMargin +dY);
//                    setLayoutParams(lp);
//                    setOnTouchListener(new touchListener());
////                    ((Activity)context).addContentView(this,layoutParams);
////                    setX(rax+width);
////                    setY(event.getY());
//
//                    isAdded = true;
//                }
//
//                if(isAdded){
//                    ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
//                    lp.leftMargin = screenX;
//                    lp.topMargin = (int) (screenY +dY);
//                    setLayoutParams(lp);
//                }
//
////                setY(getRawY +dY - height);
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                break;
//        }
//
//
//        return true;
//    }

    class touchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            Log.e(TAG, "action:" + getAction(action));
            width = getWidth();
            height = getHeight();
            int[] location = new int[2];
            getLocationOnScreen(location);
            int screenX = location[0];
            int screenY = location[1] - 55;

//        Log.e(TAG, " width:" + width + " height:" + height + " getX():" +screenX+" getY():" + screenX);
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    startY = event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float dY = event.getRawY() - startY;
                    float rax = event.getRawX();
//                Log.e(TAG, " dY:" + dY + " y:" + event.getRawY());
                    float getX = event.getX();
                    float getY = event.getY();
                    float getRawx = event.getRawX();
                    float getRawY = event.getRawY();
//                setX(getX);
                    Log.e(TAG, " getX:" + getX + " getY:" + getY + " getRawx:" + getRawx + " getRawY:" + getRawY);
//                    if (dY < -10 && !isAdded) {
//                        ViewGroup viewParent = (ViewGroup) this.getParent();
////                    Log.e(TAG, " viewParent:" + viewParentrent);
//                        viewParent.removeView(this);
//                        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(width, height);
////                    layoutParams.topMargin = 1000 ;
//                        ((Activity) context).addContentView(this, layoutParams);
//                        ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
//                        lp.leftMargin = screenX;
//                        lp.topMargin = (int) (screenY +dY);
//                        setLayoutParams(lp);
////                    ((Activity)context).addContentView(this,layoutParams);
////                    setX(rax+width);
////                    setY(event.getY());
//
//                        isAdded = true;
//                    }
//
//                    if(isAdded){
                    ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
                    lp.leftMargin = screenX;
                    lp.topMargin = (int) (screenY + dY);
                    setLayoutParams(lp);
//                    }

//                setY(getRawY +dY - height);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    break;
            }
            return true;
        }
    }
}
