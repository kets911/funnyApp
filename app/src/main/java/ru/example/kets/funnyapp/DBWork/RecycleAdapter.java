package ru.example.kets.funnyapp.DBWork;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.example.kets.funnyapp.R;

/**
 * Created by kets on 07.01.2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    List<String> iemList;

    public RecycleAdapter(List<String> itemList){
        this.iemList = itemList;
    }

    public void setIemList(List<String> iemList) {
        this.iemList = iemList;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_workwithdb_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        holder.textView.setText(iemList.get(position));
    }

    @Override
    public int getItemCount() {
        return iemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.titleView);
        }
    }
}
