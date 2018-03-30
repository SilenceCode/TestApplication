package com.example.it.testapplication.home.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.it.testapplication.R;
import com.example.it.testapplication.home.data.GridInfo;

import java.util.ArrayList;
import java.util.List;

public class BaseGridViewAdapter extends BaseAdapter {

    private List<GridInfo> gridInfoArrayList = new ArrayList<>();
    private Context context;

    public BaseGridViewAdapter(List<GridInfo> gridInfoArrayList, Context context) {
        this.gridInfoArrayList = gridInfoArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return gridInfoArrayList.size();
    }

    @Override
    public GridInfo getItem(int position) {
        return gridInfoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.tv_gd_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GridInfo gridInfo = gridInfoArrayList.get(position);
        viewHolder.textView.setText(gridInfo.getContent());
        return convertView;
    }

    private class ViewHolder {
        private TextView textView;
    }
}
