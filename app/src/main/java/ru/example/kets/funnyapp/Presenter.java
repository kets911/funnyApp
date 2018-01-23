package ru.example.kets.funnyapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import database.DBHelper;
import database.DBHelperInt;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by kets on 11.01.2018.
 */

public class Presenter implements PresenterInterface {
    private MessageProviderInt messageProvider;
    private ShowMessageActivityInt view;
    private Disposable disposable;
    DBHelperInt dbHelper;
    public Presenter(ShowMessageActivity view, DBHelper dbHelper, MessageProvider messageProvider){
        this.view = view;
        this.dbHelper = dbHelper;
        this.messageProvider = messageProvider;
    }

    public void showMessages(){
        disposable = (Disposable) messageProvider.getMessageProvider()
                .subscribeWith(new DisposableSubscriber<List<Message>>() {
                    @Override
                    public void onNext(List<Message> messages) {
                        view.updateUI(messages);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("funnyAppLog", "Some Error= "+ t);
                        Toast.makeText(((Context)view), "Some Error= "+ t, Toast.LENGTH_LONG).show();
                        view.updateUI(dbHelper.getUpdatedList());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void deletMessage(String title) {
        dbHelper.deletItem(title);
        view.updateUI(dbHelper.getUpdatedList());
    }

    public void dispose(){
        disposable.dispose();
    }
}
