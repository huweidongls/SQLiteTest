package com.example.a99zan.sqlitetest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99zan on 2018/1/16.
 */

public class BookAdapter extends BaseAdapter {

    private Context context;
    private List<BookEntity> data = new ArrayList<>();

    public BookAdapter(Context context, List<BookEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.layout_listview_item, null);
            holder.t1 = convertView.findViewById(R.id.t1);
            holder.t2 = convertView.findViewById(R.id.t2);
            holder.t3 = convertView.findViewById(R.id.t3);
            holder.t4 = convertView.findViewById(R.id.t4);
            holder.t5 = convertView.findViewById(R.id.t5);
            holder.t6 = convertView.findViewById(R.id.t6);
            holder.t7 = convertView.findViewById(R.id.t7);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.t1.setText(data.get(position).getMember_id());
        holder.t2.setText(data.get(position).getBook_name());
        holder.t3.setText(data.get(position).getBook_yanjiang());
        holder.t4.setText(data.get(position).getBook_date());
        holder.t5.setText(data.get(position).getBook_time());
        holder.t6.setText(data.get(position).getBook_zhangjie_name());
        holder.t7.setText(data.get(position).getBook_path());

        return convertView;
    }

    private class ViewHolder{
        TextView t1, t2, t3, t4, t5, t6, t7;
    }

}
