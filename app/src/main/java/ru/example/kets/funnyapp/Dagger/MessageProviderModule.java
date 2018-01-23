package ru.example.kets.funnyapp.Dagger;

import dagger.Module;
import dagger.Provides;
import database.DBHelper;
import ru.example.kets.funnyapp.MessageProvider;

/**
 * Created by kets on 18.01.2018.
 */
@Module (includes = DBHelperModule.class)
public class MessageProviderModule {
    @Provides
    MessageProvider getMessageProvider(DBHelper dbHelper){
        return new MessageProvider(dbHelper);
    }
}
