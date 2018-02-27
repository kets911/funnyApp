package ru.example.kets.funnyapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
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

//        onView(withId(R.id.cardView)).check(matches(not(isDisplayed())));
//        onView(withId(R.id.textView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycleList)).check(matches(isDisplayed()));
    }
}
