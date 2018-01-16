package ru.example.kets.funnyapp;

import android.content.Context;

import org.reactivestreams.Publisher;

import java.util.List;

import dagger.Module;
import database.DBHelper;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kets on 08.01.2018.
 */

public class MessageProvider implements MessageProviderInt<List<Message>> {
    DBHelper dbHelper;
    public MessageProvider(DBHelper dbHelper){
        this.dbHelper = dbHelper;
    }
    private MessageApi messageApi = new MessageRetrofit("http://annimon.com").getRetrofit().create(MessageApi.class);
    public Flowable<List<Message>> getMessageProvider(){
         return messageApi.getLastMessages().cache()
                .subscribeOn(Schedulers.io())
                 .flatMap(new Function<List<Message>, Publisher<Message>>() {
                     @Override
                     public Publisher<Message> apply(@NonNull List<Message> messages) throws Exception {
                         return Flowable.fromIterable(messages);
                     }
                 })
                 .map(new Function<Message, Message>() {
                     @Override
                     public Message apply(@NonNull Message message) throws Exception {
                         dbHelper.insertIntoDB(message);
                         return message;
                     }
                 })
                 .toList()
                 .toFlowable()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
