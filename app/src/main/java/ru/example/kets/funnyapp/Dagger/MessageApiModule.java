package ru.example.kets.funnyapp.Dagger;

import dagger.Module;
import dagger.Provides;
import ru.example.kets.funnyapp.MessageApi;
import ru.example.kets.funnyapp.MessageRetrofit;

/**
 * Created by kets on 05.02.2018.
 */
@Module
public class MessageApiModule {
    @Provides
    MessageApi getMessageApi(){
        return new MessageRetrofit("http://annimon.com").getRetrofit().create(MessageApi.class);
    }
}
