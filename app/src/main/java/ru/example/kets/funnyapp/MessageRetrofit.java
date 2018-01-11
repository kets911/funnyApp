package ru.example.kets.funnyapp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kets on 09.01.2018.
 */

public  class MessageRetrofit {
    private Retrofit retrofit;
    public MessageRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://annimon.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
