package ru.example.kets.funnyapp;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kets on 08.01.2018.
 */

public class MessageMessageProvider implements MessageProviderInt {
    public Flowable<List<Message>> getMessageProvider(){
        MessageApi messageApi = new MessageRetrofit().getRetrofit().create(MessageApi.class);
         return messageApi.getLastMessages().cache()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
