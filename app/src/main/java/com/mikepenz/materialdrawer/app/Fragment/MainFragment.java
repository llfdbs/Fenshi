package com.mikepenz.materialdrawer.app.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.mikepenz.materialdrawer.app.R;
import com.mikepenz.materialdrawer.app.activity.ParkListActivity;
import com.quickdv.activity.fragment.MapFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends MapFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LatLng[] la = new LatLng[]{new LatLng(34.7466, 113.625367),new LatLng(34.7366, 113.625367),new LatLng(34.7266, 113.635367),new LatLng(34.7266, 113.615367)};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    /**
     * 绘制系统默认的1种marker背景图片
     */
    public void drawMarkers(MarkerOptions options) {
        drawMarkers(options,200);
    }
    /**
     * 绘制系统默认的1种marker背景图片
     */
    public void drawMarkers(MarkerOptions options,int rail) {
        aMap.addMarker(options);
        // 绘制一个圆形
//        aMap.addCircle(new CircleOptions().center(options.getPosition())
//                .radius(rail).strokeColor(getResources().getColor(R.color.green)).fillColor(getResources().getColor(R.color.light_screen))
//                .strokeWidth(3));
        aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                options.getPosition(), 16, 0, 30)), 1000, null);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected void initView() {
        mapView = findView(R.id.map);
        Button button = findView(R.id.want_tenancy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ParkListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutViewID() {
        return R.layout.fragment_main;
    }

    public void setCLickListener() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
