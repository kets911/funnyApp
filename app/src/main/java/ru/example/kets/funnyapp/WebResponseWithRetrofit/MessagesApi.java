package ru.example.kets.funnyapp.WebResponseWithRetrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.example.kets.funnyapp.webWork.Messages;

/**
 * Created by kets on 08.01.2018.
 */

public interface MessagesApi {
    @GET("/forum/last_posts")
    Observable<List<Messages>> getLastMessages();

}
