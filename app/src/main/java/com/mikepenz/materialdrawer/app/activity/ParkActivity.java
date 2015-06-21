package com.mikepenz.materialdrawer.app.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.ListViewAdapter;
import com.quickdv.activity.MapActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkActivity extends MapActivity {
    List<Map<String,Object>> data;



    @Override
    public int getLayout() {
        return R.layout.activity_park;
    }



    @Override
    public void initView() {

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapView = findView(R.id.map);
        initData();
        ListView list = findView(R.id.usable_car);
        ListViewAdapter adapter  = new ListViewAdapter(this,data,R.layout.activity_parklist_item,new String[]{},new int[]{});
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ParkActivity.this,ProductActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle("京沙路停车场");
    }
    @Override
    public void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id");
            data.add(map);
        }
    }
}
