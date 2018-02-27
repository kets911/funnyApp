package ru.example.kets.funnyapp.Dagger;

import dagger.Module;
import dagger.Provides;
import database.DBHelper;
import database.DBHelperInt;
import ru.example.kets.funnyapp.MessageApi;
import ru.example.kets.funnyapp.MessageProvider;

/**
 * Created by kets on 18.01.2018.
 */
@Module (includes = {DBHelperModule.class, MessageApiModule.class})
public class MessageProviderModule {
    @Provides
    MessageProvider getMessageProvider(DBHelper dbHelper, MessageApi messageApi){
        return new MessageProvider(dbHelper, messageApi);
    }
}
