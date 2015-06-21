package com.mikepenz.materialdrawer.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mikepenz.materialdrawer.app.R;


public class OrderActivity extends com.quickdv.activity.BaseActivity implements View.OnClickListener{


    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
    }


    @Override
    public void initView() {
        Button submit = findView(R.id.order_submit);
        spinner =findView(R.id.order_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rent_type, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        submit.setOnClickListener(this);
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle(R.string.submit_order);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_submit:
                Intent intent = new Intent(OrderActivity.this,PayActivity.class);
                startActivity(intent);
                break;
        }

    }
}
