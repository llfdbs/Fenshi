package com.mikepenz.materialdrawer.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.adapter.MRecyclerAdapter;
import com.quickdv.activity.adapter.viewholder.DataViewHolder;
import com.quickdv.activity.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户订单列表
 */
public class OrderFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "type";

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recycler;
    private List<Map<String, Object>> data;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(int param1) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected void initView() {
        int type = getArguments().getInt(ARG_PARAM1);
        refreshLayout = findView(R.id.order_refreshlayout);
        recycler = findView(R.id.order_list);

        buildData();
        orderType(R.layout.grid_maintenance_car,null);

    }

    private void orderType(int layout , final View.OnClickListener clickListener) {
        MRecyclerAdapter adapter = new MRecyclerAdapter(getActivity(), data, layout, new String[]{}, new int[]{}) {
            @Override
            public void addClickListener(DataViewHolder holder, int position) {
                //添加具体点击实现
                if(clickListener != null)
                    holder.getRootView().setOnClickListener(clickListener);
            }
        };
        recycler.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayout.VERTICAL);
        recycler.setLayoutManager(manager);
    }

    class CollectionClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }

    class Maintenance implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "15639932746"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected int getLayoutViewID() {
        return R.layout.activity_order_fragment;
    }

    private void buildData() {
        data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", "id");
            data.add(map);
        }
    }

}
