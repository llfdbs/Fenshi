package com.mikepenz.materialdrawer.app.adapter;

import android.content.Context;

import com.quickdv.activity.adapter.DevSimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by lilongfei on 15/4/19.
 */
public class ListViewAdapter extends DevSimpleAdapter {

    public ListViewAdapter(Context c, List<Map<String, Object>> data, int layout, String[] from,int[] to) {
        super(c, data,layout,from,to);
    }

    @Override
    protected int[] getViewID() {
        return new int[0];
    }
}
