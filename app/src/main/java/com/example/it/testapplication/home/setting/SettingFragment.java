package com.example.it.testapplication.home.setting;


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
public class SettingFragment extends Fragment {


    @BindView(R.id.gd_info)
    GridView gdInfo;
    Unbinder unbinder;
    private View view;

    private List<GridInfo> gridInfoList = new ArrayList<>();

    public SettingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting, container, false);
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
        GridInfo gridInfo = new GridInfo("设置1", "");
        GridInfo gridInfo1 = new GridInfo("设置2", "");
        GridInfo gridInfo2 = new GridInfo("设置3", "");
        GridInfo gridInfo3 = new GridInfo("设置4", "");
        GridInfo gridInfo4 = new GridInfo("设置5", "");
        GridInfo gridInfo5 = new GridInfo("设置6", "");
        GridInfo gridInfo6 = new GridInfo("设置7", "");
        GridInfo gridInfo7 = new GridInfo("设置8", "");
        GridInfo gridInfo8 = new GridInfo("设置9", "");
        GridInfo gridInfo9 = new GridInfo("设置10", "");
        GridInfo gridInfo10 = new GridInfo("设置11", "");
        GridInfo gridInfo11 = new GridInfo("设置12", "");
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
        gridInfoList.add(gridInfo10);
        gridInfoList.add(gridInfo11);
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(gridInfoList, getContext());
        gdInfo.setAdapter(baseGridViewAdapter);
        baseGridViewAdapter.notifyDataSetChanged();
    }
}
