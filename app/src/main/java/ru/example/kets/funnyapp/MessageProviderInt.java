package ru.example.kets.funnyapp;

import java.util.List;

import io.reactivex.Flowable;
import ru.example.kets.funnyapp.Message;

/**
 * Created by kets on 08.01.2018.
 */

public interface MessageProviderInt<T> {
    Flowable<T> getMessageProvider();
}
