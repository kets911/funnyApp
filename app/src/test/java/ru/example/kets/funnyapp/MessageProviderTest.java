package ru.example.kets.funnyapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import database.DBHelperInt;
import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.when;

/**
 * Created by kets on 03.02.2018.
 */
@RunWith(JUnit4.class)
public class MessageProviderTest {
    MessageProvider messageProvider;
    MessageApi messageApi;
    DBHelperInt dbHelper;
    List<Message> fakeMessages;
    Message message;
    @Before
    public void setUp(){
        dbHelper = Mockito.mock(DBHelperInt.class);
        messageApi = Mockito.mock(MessageApi.class);
        messageProvider = new MessageProvider(dbHelper, messageApi);
        fakeMessages = new ArrayList<>();
        message = new Message();
        fakeMessages.add(message);
        when(messageApi.getLastMessages()).thenReturn(Flowable.just(fakeMessages));
    }
    @Test
    public void setMessageProviderTest(){
        TestSubscriber<List<Message>> testSubscriber = TestSubscriber.create();
        messageProvider.getMessageProvider().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();

        Mockito.verify(messageApi).getLastMessages();
        Mockito.verify(dbHelper).insertIntoDB(message);
        testSubscriber.assertValue(fakeMessages);
    }
}
