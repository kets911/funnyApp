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
@Module(includes = {ContextModule.class, DBHelperModule.class, MessageProviderModule.class})
public class PresenterModule {
    @Provides
    Presenter getPresenter(ShowMessageActivity view, DBHelper dbHelper, MessageProvider messageProvider){
        return new Presenter(view, dbHelper, messageProvider);
    }
    @Provides
    ShowMessageActivity getShowMessageActivity(Context context){
        return (ShowMessageActivity) context;
    }
}