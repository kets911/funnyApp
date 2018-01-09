package ru.example.kets.funnyapp.WebResponseWithRetrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kets on 08.01.2018.
 */

public class RetrofitRequest implements RetrofitRequestInt {
    public MessagesApi getRequest(){
        return new Retrofit.Builder()
                .baseUrl("http://annimon.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(MessagesApi.class);
    }
}
