package ru.example.kets.funnyapp;

import android.view.View;

import java.util.List;

/**
 * Created by kets on 05.01.2018.
 */

public interface ShowMessageActivityInt {
    void deletItem(View v);
    void updateUI(List<Message> itemList);
}
