package ru.example.kets.funnyapp.DBWork;

import android.view.View;

import java.util.List;

/**
 * Created by kets on 05.01.2018.
 */

public interface WorkWithDBActivityInt {
    void deletItem(View v);
    void updateUI(List<String> itemList);
}
