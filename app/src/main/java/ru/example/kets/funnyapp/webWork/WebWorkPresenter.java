package ru.example.kets.funnyapp.webWork;

import java.io.IOException;

/**
 * Created by kets on 03.01.2018.
 */

public class WebWorkPresenter implements WebWorkPresenterInt {

    private ShowWorkWithWebActivityInt view;
    private RequestToWeb requestToWeb;
    public WebWorkPresenter(ShowWorkWithWebActivityInt view){
        this.view = view;
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
            view.setMessages(requestToWeb.getMessages().toString());
        } catch (IOException e) {
            view.setMessages("App had crashed "+ e);
            e.printStackTrace();
        }
    }
}
