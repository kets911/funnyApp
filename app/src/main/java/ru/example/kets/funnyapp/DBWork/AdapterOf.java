package ru.example.kets.funnyapp.DBWork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ru.example.kets.funnyapp.R;

/**
 * Created by kets on 07.01.2018.
 */

public class AdapterOf extends BaseAdapter {
  private Context ctx;
  private LayoutInflater lInflater;
  private List<String> itemList;

    public AdapterOf(Context ctx, List<String> itemList) {
        this.ctx = ctx;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = lInflater.inflate(R.layout.activity_workwithdb_item, parent, false);
            holder = new ViewHolder();
            holder.titleView = (TextView) convertView.findViewById(R.id.titleView);
//            holder.del_Item = (Button) convertView.findViewById(R.id.del_Item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleView.setText(itemList.get(position));
        return convertView;
    }
}

 class ViewHolder{
    public TextView titleView;
    public Button del_Item;
}
