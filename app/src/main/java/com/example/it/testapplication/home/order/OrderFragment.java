package com.example.it.testapplication.home.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.it.testapplication.R;
import com.example.it.testapplication.home.base.BaseGridViewAdapter;
import com.example.it.testapplication.home.data.GridInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    @BindView(R.id.gd_info)
    GridView gdInfo;
    Unbinder unbinder;
    private View view;
    private List<GridInfo> gridInfoList = new ArrayList<>();

    public OrderFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        gridInfoList.clear();
        GridInfo gridInfo = new GridInfo("订单1", "订单1");
        GridInfo gridInfo1 = new GridInfo("订单2", "订单2");
        GridInfo gridInfo2 = new GridInfo("订单3", "订单3");
        GridInfo gridInfo3 = new GridInfo("订单4", "订单4");
        GridInfo gridInfo4 = new GridInfo("订单5", "订单5");
        GridInfo gridInfo5 = new GridInfo("订单6", "订单6");
        GridInfo gridInfo6 = new GridInfo("订单7", "订单7");
        gridInfoList.add(gridInfo);
        gridInfoList.add(gridInfo1);
        gridInfoList.add(gridInfo2);
        gridInfoList.add(gridInfo3);
        gridInfoList.add(gridInfo4);
        gridInfoList.add(gridInfo5);
        gridInfoList.add(gridInfo6);
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(gridInfoList, getContext());
        gdInfo.setAdapter(baseGridViewAdapter);
        baseGridViewAdapter.notifyDataSetChanged();
    }

}
