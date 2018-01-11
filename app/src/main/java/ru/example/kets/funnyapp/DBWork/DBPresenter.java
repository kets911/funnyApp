//package ru.example.kets.funnyapp.DBWork;
//
//
//import android.content.Context;
//import database.DBHelper;
//import database.DBHelperInt;
//import ru.example.kets.funnyapp.ShowMessageActivity;
//import ru.example.kets.funnyapp.ShowMessageActivityInt;
//
///**
// * Created by kets on 04.01.2018.
// */
//
//public class DBPresenter implements DBPresenterInt {
//
//    private DBHelperInt dbHelper;
//    private ShowMessageActivityInt view;
//
//    public DBPresenter(Context view) {
//        this.view =(ShowMessageActivity) view;
//        dbHelper = new DBHelper(view);
//        updateUI();
//    }
//
//
//    @Override
//    public void insertIntoDB(String item) {
//        dbHelper.insertIntoDB(item);
//        updateUI();
//    }
//
//    @Override
//    public void deletItem(String item) {
//        dbHelper.deletItem(item);
//        updateUI();
//    }
//
//    @Override
//    public void updateUI() {
//        view.updateUI(dbHelper.getUpdatedList());
//    }
//}
