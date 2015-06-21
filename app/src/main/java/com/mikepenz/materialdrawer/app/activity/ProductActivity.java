package com.mikepenz.materialdrawer.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.ListGridAdapter;
import com.mikepenz.materialdrawer.app.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lilongfei on 15/5/10.
 */
public class ProductActivity extends com.quickdv.activity.BaseActivity implements View.OnClickListener, BaseSliderView.OnSliderClickListener, AdapterView.OnItemClickListener {


    List<Map<String, Object>> data, commit_data;
//    CustomListView other_service_lv;
    ListView commit_lv;
    ListViewAdapter service_adapter;
    ListGridAdapter commit_adapter;

    Button get_bt,order_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    @Override
    public void initView() {
        buildData();
        initImageSlider();
        get_bt = findView(R.id.product_get);
        order_bt = findView(R.id.product_order);
        get_bt.setOnClickListener(this);
        order_bt.setOnClickListener(this);
    }

    @Override
    public void initActionbar() {
        getSupportActionBar().setTitle("租车详情");
    }

    private void buildData() {
        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", "id");
            data.add(map);
        }
    }

    private void initImageSlider() {
        SliderLayout mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("正面", R.mipmap.bigbang);
        file_maps.put("侧面", R.mipmap.bigbang);
        file_maps.put("内部", R.mipmap.bigbang);
        file_maps.put("后面", R.mipmap.bigbang);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
    }

    @Override
    public void onClick(View v) {
        String action = null;
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.product_get:
                Intent intent = new Intent(ProductActivity.this,OrderActivity.class);
                startActivity(intent);
                break;
            case R.id.product_order:
                Intent intent1 = new Intent(ProductActivity.this,OrderActivity.class);
                startActivity(intent1);
                break;
        }

//        startActivity(action, bundle);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
