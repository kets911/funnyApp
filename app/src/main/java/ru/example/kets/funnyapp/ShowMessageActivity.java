package ru.example.kets.funnyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.example.kets.funnyapp.Dagger.ContextModule;
import ru.example.kets.funnyapp.Dagger.DaggerMessageComponent;
import ru.example.kets.funnyapp.Dagger.MessageComponent;


/**
 * Created by kets on 12.09.2017.
 */

public class ShowMessageActivity extends AppCompatActivity implements ShowMessageActivityInt {
    PresenterInterface presenter;
    private RecycleAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    Animation animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        recyclerView = (RecyclerView) findViewById(R.id.recycleList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        recyclerView.startAnimation(animation);
        MessageComponent dagger = DaggerMessageComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        presenter = dagger.getPresenter();
        presenter.showMessages();
    }

    public void updateUI(List<Message> messages) {
        if(adapter == null){
        recyclerView.setAdapter(new RecycleAdapter(messages));
        }else {
            adapter.setMessages(messages);
            adapter.notifyDataSetChanged();
        }
    }

    public void deletMessage(View v) {
        View parent = (View) v.getParent();
        TextView itemTitleView = (TextView) parent.findViewById(R.id.titleView);
        String title = String.valueOf(itemTitleView.getText());
        presenter.deletMessage(title);
    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(this, "Some Error= "+ t, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dispose();
    }
}
