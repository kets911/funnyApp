package ru.example.kets.funnyapp;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kets on 07.01.2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<Message> messages;

    public RecycleAdapter(List<Message> messages){
        this.messages = messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show_message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        holder.titleView.setText(messages.get(position).getTitle());
        holder.messageText.setText(messages.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleView;
        private TextView messageText;
        public ViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.titleView);
            messageText = (TextView) view.findViewById(R.id.messageText);
        }
    }
}
