package ru.example.kets.funnyapp.DBWork;

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

import java.util.List;

import ru.example.kets.funnyapp.R;

/**
 * Created by kets on 12.09.2017.
 */

public class WorkWithDBActivity extends AppCompatActivity implements WorkWithDBActivityInt{
    private DBPresenterInt presenter;
    private RecycleAdapter adapter;
    private RecyclerView recyclerList;
    private RecyclerView.LayoutManager layoutManager;
    Animation animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workwithdb);

        recyclerList = (RecyclerView) findViewById(R.id.recycleList);
        recyclerList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerList.setLayoutManager(layoutManager);

        animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        recyclerList.startAnimation(animation);
        presenter = new DBPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_workwithdb_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add_item:
                createAlertDialog().show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private AlertDialog createAlertDialog() {
        final EditText editText = new EditText(this);
        return  new AlertDialog.Builder(this)
                .setTitle("Create new row")
                .setMessage("Insert row")
                .setView(editText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = String.valueOf(editText.getText());
                        presenter.insertIntoDB(item);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
    }

    public void updateUI(List<String> itemList) {
        if(adapter==null){
            adapter = new RecycleAdapter(itemList);
            recyclerList.setAdapter(adapter);
        }else {
            adapter.setIemList(itemList);
            adapter.notifyDataSetChanged();
            recyclerList.startAnimation(animation);
        }

    }

    public void deletItem(View v) {
        View parent = (View) v.getParent();
        TextView itemTextView = (TextView) parent.findViewById(R.id.titleView);
        String item = String.valueOf(itemTextView.getText());
        presenter.deletItem(item);
    }
}
