package com.example.it.testapplication.home.goods;


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
public class GoodsFragment extends Fragment {


    @BindView(R.id.gd_info)
    GridView gdInfo;
    Unbinder unbinder;
    private View view;
    private List<GridInfo> gridInfoList = new ArrayList<>();

    public GoodsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods, container, false);
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
        GridInfo gridInfo = new GridInfo("商品1", "");
        GridInfo gridInfo1 = new GridInfo("商品2", "");
        GridInfo gridInfo2 = new GridInfo("商品3", "");
        GridInfo gridInfo3 = new GridInfo("商品4", "");
        GridInfo gridInfo4 = new GridInfo("商品5", "");
        GridInfo gridInfo5 = new GridInfo("商品6", "");
        GridInfo gridInfo6 = new GridInfo("商品7", "");
        GridInfo gridInfo7 = new GridInfo("商品8", "");
        GridInfo gridInfo8 = new GridInfo("商品9", "");
        gridInfoList.add(gridInfo);
        gridInfoList.add(gridInfo1);
        gridInfoList.add(gridInfo2);
        gridInfoList.add(gridInfo3);
        gridInfoList.add(gridInfo4);
        gridInfoList.add(gridInfo5);
        gridInfoList.add(gridInfo6);
        gridInfoList.add(gridInfo7);
        gridInfoList.add(gridInfo8);
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(gridInfoList, getContext());
        gdInfo.setAdapter(baseGridViewAdapter);
        baseGridViewAdapter.notifyDataSetChanged();
    }
}
