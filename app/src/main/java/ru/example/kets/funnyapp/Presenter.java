package ru.example.kets.funnyapp;

import java.util.List;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by kets on 11.01.2018.
 */

public class Presenter implements PresenterInterface {
    private MessageProviderInt messageProvider;
    private ShowMessageActivityInt view;
    Presenter(ShowMessageActivity view){
        this.view = view;
        messageProvider = new MessageMessageProvider();
    }

    public void showMessages(){
        messageProvider.getMessageProvider()
                .subscribeWith(new DisposableSubscriber<List<Message>>() {
                    @Override
                    public void onNext(List<Message> messages) {
                        view.updateUI(messages);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}