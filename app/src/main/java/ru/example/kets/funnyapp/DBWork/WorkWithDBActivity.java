package ru.example.kets.funnyapp.DBWork;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import database.DBContract;
import database.DBHelper;
import ru.example.kets.funnyapp.DBWork.DBPresenter;
import ru.example.kets.funnyapp.DBWork.DBPresenterInt;
import ru.example.kets.funnyapp.R;

/**
 * Created by kets on 12.09.2017.
 */

public class WorkWithDBActivity extends AppCompatActivity implements WorkWithDBActivityInt{
    private DBPresenterInt presenter;
    private AdapterOf adapter;
    private ListView listView;
    Animation animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workwithdb);

        listView = (ListView) findViewById(R.id.list);

        animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        listView.startAnimation(animation);
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
            adapter = new AdapterOf(this, itemList);
            listView.setAdapter(adapter);
        }else {

            adapter.notifyDataSetChanged();
            animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
            listView.startAnimation(animation);
        }

    }

    public void deletItem(View v) {
        View parent = (View) v.getParent();
        TextView itemTextView = (TextView) parent.findViewById(R.id.titleView);
        String item = String.valueOf(itemTextView.getText());
        presenter.deletItem(item);
    }
}
