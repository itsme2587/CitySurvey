package com.firebase.android.citysurvey;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ayush on 03-07-2018.
 */

public class Ques5Fragment extends Fragment {

    private Button endBtn;
    private EditText suggestion;

    public Ques5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ques5,container,false);

        final String[] array = Questions.answers.toString().split(",");

        suggestion = rootView.findViewById(R.id.editText2);

        endBtn = rootView.findViewById(R.id.endBtn);
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndividualQuestion.progress = 1;
                Answers ans = new Answers(array[0],array[1],array[2],array[3],suggestion.getText().toString());
                Log.i("Hakunammatata", "onClick: " + ans);

                getActivity().finish();

            }
        });


        return rootView;

    }
}
