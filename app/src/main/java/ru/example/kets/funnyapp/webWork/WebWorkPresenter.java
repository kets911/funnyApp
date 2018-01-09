package ru.example.kets.funnyapp.webWork;

import java.io.IOException;
import java.util.List;

import ru.example.kets.funnyapp.WebResponseWithRetrofit.Iteraptor;
import ru.example.kets.funnyapp.WebResponseWithRetrofit.IteraptorInt;

/**
 * Created by kets on 03.01.2018.
 */

public class WebWorkPresenter implements WebWorkPresenterInt {

    private ShowWorkWithWebActivityInt view;
    private RequestToWeb requestToWeb;
    IteraptorInt iteraptor;
    public WebWorkPresenter(ShowWorkWithWebActivityInt view){
        this.view = view;
        iteraptor = new Iteraptor(view);
        try {
            requestToWeb = new RequestToWeb();
        } catch (IOException e) {
            view.setMessages("App had crashed "+ e);
            e.printStackTrace();
        }
    }

    @Override
    public void showMessages() {
        try {
            view.setMessages(getMessagesWithOkHttp().toString());
        } catch (IOException e) {
            view.setMessages("App had crashed "+ e);
            e.printStackTrace();
        }
    }

    @Override
    public void showMessages(List<Messages> itemList) {
        view.setMessages(itemList.toString());
    }

    @Override
    public Messages getMessagesWithOkHttp() throws IOException {

        return requestToWeb.getMessages();
    }



}
