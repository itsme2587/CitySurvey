package com.firebase.android.citysurvey;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by Ayush on 04-07-2018.
 */

public class IndividualQuestion extends Fragment {

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private IndividualQuestion obj;
    public static int progress = 1;
    private TextView text;
    private TextView questionTv;

    public IndividualQuestion() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_individual_questions, container, false);
        final Button nextBtn = rootView.findViewById(R.id.nextBtn);
        text = rootView.findViewById(R.id.textView);
        text.setText("Question " + progress + " of 5 or fewer:");
        questionTv = rootView.findViewById(R.id.quesField);
        questionTv.setText(getQuestion());

        final RadioGroup rg = rootView.findViewById(R.id.radioGroup2);
        final RadioButton rb1 = rootView.findViewById(R.id.radioBtn1);
        final RadioButton rb2 = rootView.findViewById(R.id.radioBtn2);
        final RadioButton rb3 = rootView.findViewById(R.id.radioBtn3);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress == 4) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Ques5Fragment()).commit();
                    int selectedId = rg.getCheckedRadioButtonId();
                    RadioButton selectedRadioBtn = rootView.findViewById(selectedId);
                    Questions.answers.append(selectedRadioBtn.getText());
                    progress++;
                    Questions.pb.setProgress(progress);
                }
                else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,getObj()).commit();
                    progress++;
                    Questions.pb.setProgress(progress);
                    int selectedId = rg.getCheckedRadioButtonId();
                    RadioButton selectedRadioBtn = rootView.findViewById(selectedId);
                    Questions.answers.append(selectedRadioBtn.getText() + ",");
                }

            }
        });

        nextBtn.setClickable(false);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioBtn1) {
                    nextBtn.setClickable(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                }
                else if(i == R.id.radioBtn2) {
                    nextBtn.setClickable(true);
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                }
                else {
                    nextBtn.setClickable(true);
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                }
            }
        });

        return rootView;
    }

    public IndividualQuestion getObj() {
        return obj;
    }

    public void setObj(IndividualQuestion obj) {
        this.obj = obj;
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }



}
