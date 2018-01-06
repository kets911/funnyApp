package ru.example.kets.funnyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import ru.example.kets.funnyapp.DBWork.WorkWithDBActivity;
import ru.example.kets.funnyapp.webWork.ShowWorkWithWebActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;

    TextView textView;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView:
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");

        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation animation = null;
        switch (item.getItemId()){
            case MENU_ALPHA_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_TRANSLATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
        }
        textView.startAnimation(animation);
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnJoke:
                intent = new Intent(this, JokeActivity.class);

                break;
            case R.id.btnDBWork:
                intent = new Intent(this, WorkWithDBActivity.class);

                break;
            case R.id.btnWebWork:
                intent = new Intent(this, ShowWorkWithWebActivity.class);

                break;
        }
        startActivity(intent);
    }

}
