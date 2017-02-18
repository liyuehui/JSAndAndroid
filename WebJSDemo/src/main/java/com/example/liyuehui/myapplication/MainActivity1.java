package com.example.liyuehui.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.liyuehui.myapplication.adapter.RecyclerAdapter;
import com.example.liyuehui.myapplication.view.MyRecycler;

public class MainActivity1 extends AppCompatActivity {

    private static final String TAG = MainActivity1.class.getSimpleName();

    MyRecycler recyclerView;
    ImageView dragView;
    RecyclerAdapter adapter;
    int id;
    boolean isAdded;
    boolean drag;
    private float startY, startX;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity);

        recyclerView = (MyRecycler) findViewById(R.id.recyleView);

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(300, 300);
        dragView = new ImageView(this);
        dragView.setLayoutParams(layoutParams);
        dragView.setImageResource(R.mipmap.hua);
        id = (int) System.currentTimeMillis();
        dragView.setId(id);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        Log.e(TAG, "action:" + getAction(action));
        boolean ret = false;
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                startY = event.getRawY();
                startX = event.getRawX();
                ret = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float dY = event.getRawY() - startY;
                float dX = event.getRawX() - startX;
                if (!drag) {
                    if (Math.abs(dX) < 5 && Math.abs(dY) > 10) {
                        drag = true;
                        ret = true;
                    }
                }
                Log.e(TAG, " e");
                if (drag && !isAdded) {

                    dragView.setVisibility(View.VISIBLE);

                    ViewGroup.MarginLayoutParams layoutParams1 = new ViewGroup.MarginLayoutParams(300, 300);
                    layoutParams1.topMargin = (int) (1680 + dY);
                    layoutParams1.leftMargin = 0;
                    Log.e(TAG, "topMargin:" + layoutParams1.topMargin);
                    addContentView(dragView, layoutParams1);
                    drag = true;
                    isAdded = true;
                    ret = true;

                    return true;
                }

                if (isAdded && drag) {
                    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) dragView.getLayoutParams();
                    lp.leftMargin = 0;
                    lp.topMargin = (int) (1625 + dY);
                    Log.e(TAG, "topMargin:" + lp.topMargin);
                    dragView.setVisibility(View.VISIBLE);
                    dragView.setLayoutParams(lp);

                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                dragView.setVisibility(View.INVISIBLE);
                drag = false;
                break;
        }
        if (ret && drag) {
            return true;
        }

        return super.dispatchTouchEvent(event);
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
}
