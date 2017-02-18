package com.example.liyuehui.myapplication.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by LiYueHui on 2017/2/18.
 */

public class MyRecycler extends RecyclerView {

    public static final String TAG = MyRecycler.class.getSimpleName();

    public MyRecycler(Context context) {
        super(context);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//        Log.e(TAG,"action:"+getAction(action));
//        Log.e(TAG,"width:"+getWidth()+" height:"+getHeight()+" x:"+event.getRawX()+" y:"+event.getRawY());
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_MOVE:
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                break;
//        }
//        return super.onInterceptTouchEvent(event);
//    }

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
}
