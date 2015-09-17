package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ProgressBar spinner;
    private Button jokeButton;
    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        jokeButton = (Button) root.findViewById(R.id.joke_button);
        spinner = (ProgressBar) root.findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndpointsAsyncTask task = new EndpointsAsyncTask();
                task.execute(new ButtonPackage(getActivity(), spinner, jokeButton));
                spinner.setVisibility(View.VISIBLE);
                jokeButton.setVisibility(View.INVISIBLE);
            }
        });

        return root;
    }


}
