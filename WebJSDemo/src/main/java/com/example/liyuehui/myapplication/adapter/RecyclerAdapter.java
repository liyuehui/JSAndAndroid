package com.example.liyuehui.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.liyuehui.myapplication.R;
import com.example.liyuehui.myapplication.view.DragView;

/**
 * Created by LiYueHui on 2017/2/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    public static final String TAG = RecyclerAdapter.class.getSimpleName();
    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public static String getAction(int action) {
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

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.listview_item, null);
        DragView dragView = new DragView(context);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public DragView dragView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
//            dragView = (DragView) itemView.findViewById(R.id.dragView);
//            dragView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    int action = event.getAction();
//                    Log.e(TAG,"action:"+getAction(action));
//                    Log.e(TAG," x:"+event.getRawX()+" y:"+event.getRawY());
//
//                    switch (action){
//                        case MotionEvent.ACTION_DOWN:
//                            break;
//                        case MotionEvent.ACTION_MOVE:
//                            break;
//                        case MotionEvent.ACTION_UP:
//                        case MotionEvent.ACTION_CANCEL:
//                            break;
//                    }
//                    return false;
//                }
//            });
        }
    }


}
