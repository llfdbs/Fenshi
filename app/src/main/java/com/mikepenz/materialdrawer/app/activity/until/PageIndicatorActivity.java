package com.mikepenz.materialdrawer.app.activity.until;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.app.Fragment.OrderFragment;
import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.MPagerAdapter;
import com.quickdv.activity.fragment.BaseFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/***
 *
 * 订单列表
 */

public class PageIndicatorActivity extends com.quickdv.activity.BaseActivity implements BaseFragment.OnFragmentInteractionListener, MaterialTabListener {



    private MPagerAdapter adapter;
    private ViewPager vp_order;
    private TabPageIndicator ct_titles;

//    int title;
    private List<OrderFragment> data;
    private MaterialTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;
    }

    @Override
    public void initView() {

//        ct_titles = (TabPageIndicator) findViewById(R.id.order_titles);
        vp_order = (ViewPager) findViewById(R.id.order_vp);
        tabHost = (MaterialTabHost) this.findViewById(R.id.materialTabHost);
//        Bundle bundle = getIntent().getExtras();
//        int type = bundle.getInt(Status.TYPE);
//        title = bundle.getInt(Status.TITLE);
//        ViewPageImp imp =ViewPageFactory.getFactory().product(getSupportFragmentManager(),type,bundle);
//        imp.binder(vp_order,ct_titles);
        buildData(title, 0);
        binder(vp_order, null);


//        pager = (ViewPager) this.findViewById(R.id.viewpager);

        // init view pager


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
//        tab.setViewPager(vp);
        vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });

        // insert all tabs from pagerAdapter data
        for (int i = 0; i < adapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab().setText(title[i])
//                            .setIcon(getIcon(i))
                            .setTabListener(PageIndicatorActivity.this)
            );
        }
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle("订单列表");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        // when the tab is clicked the pager swipe content to the tab position
        vp_order.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
