package com.mikepenz.materialdrawer.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mikepenz.materialdrawer.app.R;
import com.quickdv.activity.BaseActivity;

public class PayActivity extends BaseActivity implements View.OnClickListener{

    RadioButton yinlian_rb,ali_rb,weichar_rb;
    LinearLayout yinlian_ll,ali_ll,weichar_ll;
    Button pay_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }


    @Override
    public void initView() {
        yinlian_ll = findView(R.id.pay_yinlian);
        yinlian_rb = findView(R.id.pay_chose_yinlian);
        ali_ll = findView(R.id.pay_ali);
        ali_rb = findView(R.id.pay_chose_ali);
        weichar_ll = findView(R.id.pay_weichar);
        weichar_rb = findView(R.id.pay_chose_weichar);
        pay_bt = findView(R.id.pay);

        yinlian_ll.setOnClickListener(this);
        yinlian_rb.setOnClickListener(this);
        weichar_ll.setOnClickListener(this);
        weichar_rb.setOnClickListener(this);
        ali_ll.setOnClickListener(this);
        ali_rb.setOnClickListener(this);
        pay_bt.setOnClickListener(this);
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle(R.string.title_activity_pay);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pay_yinlian:
            case R.id.pay_chose_yinlian:
                clearAllChose();
                yinlian_rb.setChecked(true);
                break;
            case R.id.pay_ali:
            case R.id.pay_chose_ali:
                clearAllChose();
                ali_rb.setChecked(true);
                break;
            case R.id.pay_weichar:
            case R.id.pay_chose_weichar:
                clearAllChose();
                weichar_rb.setChecked(true);
                break;
            case R.id.pay:
                pay();
        }
    }

    private void clearAllChose(){
        yinlian_rb.setChecked(false);
        weichar_rb.setChecked(false);
        ali_rb.setChecked(false);
    }

    private void pay(){
        if(yinlian_rb.isChecked()){

        }else if (ali_rb.isChecked()){

        }else if (weichar_rb.isChecked()){

        }else {
            Toast.makeText(this,"请选择支付方式",Toast.LENGTH_LONG).show();
        }
    }
}
