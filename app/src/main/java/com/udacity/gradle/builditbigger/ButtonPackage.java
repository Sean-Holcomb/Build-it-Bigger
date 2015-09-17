package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by seanholcomb on 9/16/15.
 */
public class ButtonPackage {
    private Context context;
    private ProgressBar spinner;
    private Button jokeButton;

    public ButtonPackage(Context context, ProgressBar progressBar, Button button){
        this.context = context;
        spinner = progressBar;
        jokeButton = button;
    }
    public Button getButton(){
        return jokeButton;
    }
    public ProgressBar getSpinner(){
        return spinner;
    }
    public Context getContext(){
        return context;
    }
}
