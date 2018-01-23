package ru.example.kets.funnyapp.Dagger;

import javax.inject.Inject;

import dagger.Component;
import ru.example.kets.funnyapp.Presenter;

/**
 * Created by kets on 16.01.2018.
 */
@Component(modules = PresenterModule.class)
public interface MessageComponent {
    Presenter getPresenter();
}
