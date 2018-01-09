package ru.example.kets.funnyapp.WebResponseWithRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ru.example.kets.funnyapp.webWork.Messages;
import ru.example.kets.funnyapp.webWork.ShowWorkWithWebActivity;
import ru.example.kets.funnyapp.webWork.ShowWorkWithWebActivityInt;
import ru.example.kets.funnyapp.webWork.WebWorkPresenterInt;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by kets on 08.01.2018.
 */

public class Iteraptor implements IteraptorInt {
    ShowWorkWithWebActivityInt view;
    private MessagesApi request;

    public Iteraptor(ShowWorkWithWebActivity view) {
        this.view = view;
        request = new RetrofitRequest().getRequest();
    }

    @Override
    public Subscription getSubscription() {
        Observable<List<Messages>> messagesObservable = request.getLastMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Messages>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull List<Messages> messages) throws Exception {
                        return rx.Observable.from(messages);
                    }
                })
                .cache();
        return messagesObservable.subscribe(new Subscriber<List<Messages>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Messages> messages) {
                view.setMessages(messages);
            }
        });
    }
}
