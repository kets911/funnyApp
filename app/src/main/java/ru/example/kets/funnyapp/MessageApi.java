package ru.example.kets.funnyapp;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by kets on 08.01.2018.
 */

public interface MessageApi {
    @GET("/json/forum/last_posts")
    Flowable<List<Message>> getLastMessages();

}
