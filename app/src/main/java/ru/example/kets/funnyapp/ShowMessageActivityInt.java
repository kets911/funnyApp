package ru.example.kets.funnyapp;

import android.view.View;

import java.util.List;

/**
 * Created by kets on 05.01.2018.
 */

public interface ShowMessageActivityInt {
    void deletMessage(View v);
    void updateUI(List<Message> itemList);
    void showError(Throwable t);
}
