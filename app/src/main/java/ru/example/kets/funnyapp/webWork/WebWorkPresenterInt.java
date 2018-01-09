package ru.example.kets.funnyapp.webWork;

import java.io.IOException;
import java.util.List;

/**
 * Created by kets on 03.01.2018.
 */

public interface WebWorkPresenterInt {
     void showMessages();
     void showMessages(List<Messages> itemList);
     Messages getMessagesWithOkHttp() throws IOException;
}
