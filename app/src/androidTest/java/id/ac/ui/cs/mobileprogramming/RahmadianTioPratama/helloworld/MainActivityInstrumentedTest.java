package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = (MainActivity) activityTestRule.getActivity();
    }

    @Test
    public void test_edit_text(){
        onView(withId(R.id.input)).perform(typeText("17"),closeSoftKeyboard());
        onView(withId(R.id.tombol)).perform(click());
        onView(withId(R.id.hasil)).check(matches(withText("Ganjil")));
    }

    @After
    public void tearDown(){}
}
