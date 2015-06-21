package com.mikepenz.materialdrawer.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.ListViewAdapter;
import com.quickdv.activity.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkListActivity extends BaseActivity {

    List<Map<String,Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);
        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void initView() {
        buildData();
        ListView list = findView(R.id.parklist);
        ListViewAdapter adapter  = new ListViewAdapter(this,data,R.layout.activity_parklist_item,new String[]{},new int[]{});
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ParkActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle("附近停车场");
    }

    private void buildData() {
        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id");
            data.add(map);
        }
    }
}
