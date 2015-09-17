package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by seanholcomb on 9/16/15.
 *
 */
public class AsyncTestCase extends AndroidTestCase {
    public void verifyNonemptyString() {
        String joke = "";
        try {
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();
            jokeTask.execute(new ButtonPackage(getContext(), null, null));
            joke = jokeTask.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Timed out");
        }
        assertEquals(joke.equals(""), false);
    }
}
