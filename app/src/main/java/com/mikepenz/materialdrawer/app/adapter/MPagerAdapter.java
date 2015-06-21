package com.mikepenz.materialdrawer.app.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.quickdv.activity.fragment.BaseFragment;

import java.util.List;

/**
 * Created by lilongfei on 15/4/26.
 */
public class MPagerAdapter extends FragmentStatePagerAdapter {

    List<? extends BaseFragment> data;
    FragmentManager fm;
    String[] title;
    public MPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MPagerAdapter(FragmentManager fm, List<? extends BaseFragment> data, String[] title){
        super(fm);
        this.fm = fm;
        this.data = data;
        this.title = title;
    }

    @Override
    public BaseFragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!= null? data.size():0;
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position % title.length].toUpperCase();
    }
}
