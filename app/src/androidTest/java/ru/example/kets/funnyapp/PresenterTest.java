package ru.example.kets.funnyapp;


import org.junit.After;
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

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by kets on 25.01.2018.
 */
@RunWith(JUnit4.class)
public class PresenterTest {
    MessageProviderInt messageProvider;
    ShowMessageActivityInt view;
    DBHelperInt dbHelper;
    Presenter presenter;
    List<Message> fakeMessages;
    TestSubscriber<List<Message>> testSubscriber;
    @Before
    public void setUp(){
        messageProvider = Mockito.mock(MessageProviderInt.class);
         view = Mockito.mock(ShowMessageActivityInt.class);
        dbHelper = Mockito.mock(DBHelperInt.class);
        presenter = new Presenter(view, dbHelper, messageProvider);
        fakeMessages = new ArrayList<>();
        when(messageProvider.getMessageProvider()).thenReturn(Flowable.just(fakeMessages));
        testSubscriber = new TestSubscriber<>();
    }
    @Test
    public void createdTest(){
        assertNotNull(presenter);
    }
    @Test
    public void deletMessageTest(){
        presenter.deletMessage("");
        Mockito.verify(dbHelper).deletItem("");
        Mockito.verify(view).updateUI(fakeMessages);
        Mockito.verify(dbHelper).getUpdatedList();
    }

    @Test
    public void showMessageTest(){
        presenter.showMessages();
        Mockito.verify(messageProvider).getMessageProvider();
        Mockito.verify(view, times(1)).updateUI(fakeMessages);
        messageProvider.getMessageProvider().subscribe(testSubscriber);
        testSubscriber.assertValues(fakeMessages);
        testSubscriber.assertComplete();
    }

    @Test
    public void showMessageErrorTest(){

        Exception e = new Exception();
        messageProvider= Mockito.mock(MessageProviderInt.class);
        when(messageProvider.getMessageProvider()).thenReturn(Flowable.error(e));

        presenter = new Presenter(view, dbHelper, messageProvider);
        presenter.showMessages();

        Mockito.verify(messageProvider).getMessageProvider();
        Mockito.verifyNoMoreInteractions(messageProvider);
        Mockito.verify(view).showError(e);
        Mockito.verify(view).updateUI(fakeMessages);
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verify(dbHelper).getUpdatedList();
        Mockito.verifyNoMoreInteractions(dbHelper);
    }

    @After
    public void tearDown(){
        presenter = null;
        fakeMessages.clear();
        testSubscriber.dispose();
    }
}
