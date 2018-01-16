package ru.example.kets.funnyapp.Dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kets on 16.01.2018.
 */
@Module
public class ContextModule {
    Context context;
    public ContextModule(Context context){
        this.context = context;
    }
    @Provides
    Context context(){
        return context;
    }
}
