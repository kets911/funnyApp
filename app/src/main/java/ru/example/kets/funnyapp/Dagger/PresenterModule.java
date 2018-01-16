package ru.example.kets.funnyapp.Dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import database.DBHelper;
import ru.example.kets.funnyapp.MessageProvider;
import ru.example.kets.funnyapp.Presenter;
import ru.example.kets.funnyapp.ShowMessageActivity;

/**
 * Created by kets on 16.01.2018.
 */
@Module(includes = ContextModule.class)
public class PresenterModule {
    @Provides
    Presenter getPresenter(ShowMessageActivity view, DBHelper dbHelper, MessageProvider messageProvider){
        return new Presenter(view, dbHelper, messageProvider);
    }
    @Provides
    DBHelper getDBHelper(Context context){
        return new DBHelper(context.getApplicationContext());
    }
    @Provides
    MessageProvider getMessageProvider(DBHelper dbHelper){
        return new MessageProvider(dbHelper);
    }
    @Provides
    ShowMessageActivity getShowMessageActivity(Context context){
        return (ShowMessageActivity) context;
    }
}
