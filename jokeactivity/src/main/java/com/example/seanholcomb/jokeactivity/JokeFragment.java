package com.example.seanholcomb.jokeactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {


    public JokeFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeView = (TextView) root.findViewById(R.id.joke_view);
        jokeView.setText(getActivity().getIntent().getExtras().getString("EXTRA_STRING"));

        return root;
    }




}
