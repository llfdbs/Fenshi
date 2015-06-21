package com.mikepenz.materialdrawer.app.activity.until;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.mikepenz.materialdrawer.app.Fragment.OrderFragment;
import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.MPagerAdapter;
import com.quickdv.activity.fragment.BaseFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 订单列表
 */

public class PageIndicatorActivity extends com.quickdv.activity.BaseActivity implements BaseFragment.OnFragmentInteractionListener{



    private MPagerAdapter adapter;
    private ViewPager vp_order;
    private TabPageIndicator ct_titles;

//    int title;
    private List<OrderFragment> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;
    }

    @Override
    public void initView() {

        ct_titles = (TabPageIndicator) findViewById(R.id.order_titles);
        vp_order = (ViewPager) findViewById(R.id.order_vp);
//        Bundle bundle = getIntent().getExtras();
//        int type = bundle.getInt(Status.TYPE);
//        title = bundle.getInt(Status.TITLE);
//        ViewPageImp imp =ViewPageFactory.getFactory().product(getSupportFragmentManager(),type,bundle);
//        imp.binder(vp_order,ct_titles);
        buildData(title,0);
        binder(vp_order,ct_titles);

    }

    String [] title = new String[]{"当前使用订单","已还车订单","未激活订单"};


    protected void buildData(String[] title,int type){
        data = new ArrayList<>();
        for(int i=0 ;i< title.length;i++){
            OrderFragment frag = OrderFragment.newInstance(type);
            data.add(frag);
        }
    }

    public void binder(ViewPager vp, TabPageIndicator tab) {
        buildData(title, Status.PageType.HLEP.getType());
        MPagerAdapter adapter = new MPagerAdapter(getSupportFragmentManager(),data,title);
        vp.setAdapter(adapter);
        tab.setViewPager(vp);
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle("订单列");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
