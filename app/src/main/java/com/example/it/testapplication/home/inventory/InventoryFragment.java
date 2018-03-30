package com.example.it.testapplication.home.inventory;


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
public class InventoryFragment extends Fragment {


    @BindView(R.id.gd_info)
    GridView gdInfo;
    Unbinder unbinder;
    private View view;
    private List<GridInfo> gridInfoList=new ArrayList<>();

    public InventoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inventory, container, false);
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
        GridInfo gridInfo = new GridInfo("盘点1", "盘点1");
        GridInfo gridInfo1 = new GridInfo("盘点2", "盘点2");
        GridInfo gridInfo2 = new GridInfo("盘点3", "盘点3");
        GridInfo gridInfo3 = new GridInfo("盘点4", "盘点4");
        GridInfo gridInfo4 = new GridInfo("盘点5", "盘点5");
        GridInfo gridInfo5 = new GridInfo("盘点6", "盘点6");
        GridInfo gridInfo6 = new GridInfo("盘点7", "盘点7");
        GridInfo gridInfo7 = new GridInfo("盘点8", "盘点8");
        GridInfo gridInfo8 = new GridInfo("盘点9", "盘点9");
        GridInfo gridInfo9 = new GridInfo("盘点10", "盘点10");
        gridInfoList.add(gridInfo);
        gridInfoList.add(gridInfo1);
        gridInfoList.add(gridInfo2);
        gridInfoList.add(gridInfo3);
        gridInfoList.add(gridInfo4);
        gridInfoList.add(gridInfo5);
        gridInfoList.add(gridInfo6);
        gridInfoList.add(gridInfo7);
        gridInfoList.add(gridInfo8);
        gridInfoList.add(gridInfo9);
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(gridInfoList, getContext());
        gdInfo.setAdapter(baseGridViewAdapter);
        baseGridViewAdapter.notifyDataSetChanged();
    }

}
