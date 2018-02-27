package ru.example.kets.funnyapp;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by kets on 08.02.2018.
 */
@RunWith(AndroidJUnit4.class)
public class ShowMessageActivityTest {
    @Rule
    public final ActivityTestRule<ShowMessageActivity> rule = new ActivityTestRule<>(ShowMessageActivity.class);

    @Test
    public void recyclerViewIsDisplayed(){

//        onView(withId(R.id.cardView)).check(matches(isDisplayed()));
//        onView(withId(R.id.textView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycleList)).check(matches(isDisplayed()));
    }
    @Test
    public void deletMessageTest(){
        onView(withId(R.id.recycleList)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on button";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(R.id.btnDelet);
                v.performClick();
            }
        }));

    }
}
