package com.mikepenz.materialdrawer.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.quickdv.activity.adapter.DevSimpleAdapter;

import java.util.List;
import java.util.Map;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by lilongfei on 15/5/7.
 */
public class ListGridAdapter extends DevSimpleAdapter {

    public static final String LG_ADAPTER = "lg_adapter";

    public ListGridAdapter(Context c, List<Map<String, Object>> lg_data, int layout, String[] from, int[] to) {
        super(c, lg_data, layout, from, to);
    }

    @Override
    protected int[] getViewID() {
        return new int[0];
    }

    @Override
    protected void renderData(int position, View convertView) {
        super.renderData(position, convertView);
        if (data.get(position).get(LG_ADAPTER) != null) {
//            List<Map<String, Object>> gdata = (List<Map<String, Object>>) data.get(position).get(LG_ADAPTER);
//            GridView gridView = (GridView) convertView.findViewById(R.id.list_grid_view);
//            GridViewAdapter adapter = new GridViewAdapter(c, gdata, R.layout.list_grid_view_item, new String[]{"icon"}, new int[]{R.id.list_grid_view_image});
//            if (gdata.size() > 0) {
////                gridView.setNumColumns(gdata.size());
////                initKeyTextView(gridView,gdata.size());
//            }
//            gridView.setAdapter(adapter);
        }
    }


    /**
     *
     * @方法名称:initKeyTextView
     * @描述: TODO
     * @创建人：yzk
     * @创建时间：2014年10月15日 上午11:58:22
     * @备注：获取高度每个textview的高度,然后进行比较,把最高的设置为TextView的高度
     * @param ll
     * @返回类型：void
     * @注意点:1,要把获取的item中TextView的高度存放到全局变量中,这样才会其作用.
     *        2.一定要在addOnGlobalLayoutListener监听器中给TextView设置高度,
     *         禁止把高度取出,然后在getView中这只高度,这样是无效的
     * @设计思路:1.先把TextView的高度,获取出来
     *         2.把高度存到全局变量中,然后进行和原来的比较,把大的存到全局变量中
     *         3.然后再把全局变量中的高度设置给TextView
     */
    public void initKeyTextView(final View ll, final int num) {
        ViewTreeObserver vto2 = ll.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ll.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int height = ll.getWidth()/num;
                ll.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,height));
            }
        });
    }

    public void setHeight(View ll, int height) {
//        ll.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams,MATCH_PARENT,height,Gravity.CENTER));
//        ll.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,height, Gravity.CENTER));
    }
}
