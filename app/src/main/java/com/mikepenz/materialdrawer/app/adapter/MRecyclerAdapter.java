package com.mikepenz.materialdrawer.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.quickdv.activity.adapter.BaseViewHolderAdapter;
import com.quickdv.activity.adapter.viewholder.DataViewHolder;

import java.util.List;
import java.util.Map;

/**
 * Created by lilongfei on 15/4/27.
 */
public abstract class MRecyclerAdapter extends BaseViewHolderAdapter<DataViewHolder> {

    List<Map<String, Object>> data;
    int layout;
    int[] to;
    String[] from;
    Map<Integer,View.OnClickListener> click;

    public MRecyclerAdapter(Context context, List<Map<String, Object>> data, int layout, String[] from, int[] to) {
        super(context);
        this.data = data;
        this.layout = layout;
        this.from = from;
        this.to = to;
    }

    public int getLayout(){
        return layout;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataViewHolder holder = null;
        FrameLayout frameLayout =new FrameLayout(c);
        parent = (ViewGroup) LayoutInflater.from(c).inflate(layout, frameLayout,false);
        holder = new DataViewHolder(parent,to);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        for (int i = 0; i < to.length; i++) {
            View view = holder.getView(to[i]);
            final Object data = getData(position, from[i]);
            String text = data == null ? "" : data.toString();
            if (view instanceof ImageView) {
                if (data instanceof Integer)
                    setImageSrc((ImageView) view, (Integer) data);
                else
                    setImageSrc((ImageView) view, text);
            } else if (view instanceof TextView) {
                if (data instanceof Integer) {
                    setViewText((TextView) view, (Integer) data);
                } else
                    setViewText((TextView) view, text);
            }
            if (view instanceof Checkable) {
                //如果数据类型是boolean，那么就是CheckBox
                if (data instanceof Boolean) {
                    ((Checkable) view).setChecked((Boolean) data);
                    //如果不是CheckBox，那么判断是不是继承TextView的CheckedTextView，是的话赋值，不是就抛出异常
                } else if (view instanceof TextView) {
                    setViewText((TextView) view, text);
                } else {
                    throw new IllegalStateException(view.getClass()
                            .getName()
                            + " should be bound to a Boolean, not a "
                            + (data == null ? "<unknown type>"
                            : data.getClass()));
                }
            }
        }

        addClickListener(holder,position);
    }

    protected Object getData(int position,String key){
        if(position > data.size()) return null;
        return this.data.get(position).get(key);
    }

    public abstract void addClickListener(DataViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

}
