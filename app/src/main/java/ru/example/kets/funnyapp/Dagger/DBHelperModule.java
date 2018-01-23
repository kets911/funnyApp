package ru.example.kets.funnyapp.Dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import database.DBHelper;

/**
 * Created by kets on 18.01.2018.
 */
@Singleton
@Module (includes = ContextModule.class)
public class DBHelperModule {
    @Provides
    DBHelper getDBHelper(Context context){
        return new DBHelper(context.getApplicationContext());
    }
}
