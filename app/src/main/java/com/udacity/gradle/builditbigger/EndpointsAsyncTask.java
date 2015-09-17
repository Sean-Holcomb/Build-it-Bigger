package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.seanholcomb.jokeactivity.JokeActivity;
import com.example.seanholcomb.myapplication.jokebackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by seanholcomb on 9/16/15.
 */
public class EndpointsAsyncTask extends AsyncTask<ButtonPackage, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressBar spinner;
    private Button jokeButton;

    @Override
    protected String doInBackground(ButtonPackage... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1071.appspot.com/_ah/api/");


            myApiService = builder.build();
        }
        context = params[0].getContext();
        spinner= params[0].getSpinner();
        jokeButton=params[0].getButton();

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        Intent intent =new Intent(context, JokeActivity.class);
        intent.putExtra("EXTRA_STRING", result);
        context.startActivity(intent);
        if (spinner != null && jokeButton !=null) {
            spinner.setVisibility(View.INVISIBLE);
            jokeButton.setVisibility(View.VISIBLE);
        }
    }
}
