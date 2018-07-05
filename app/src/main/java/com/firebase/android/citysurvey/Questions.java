package com.firebase.android.citysurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Questions extends AppCompatActivity {

    public static ProgressBar pb;
    public static StringBuilder answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questions);
        pb = findViewById(R.id.progressBar);
        pb.setProgress(1);

        answers = new StringBuilder("");

        IndividualQuestion ques1 = new IndividualQuestion();
        IndividualQuestion ques2 = new IndividualQuestion();
        IndividualQuestion ques3 = new IndividualQuestion();
        IndividualQuestion ques4 = new IndividualQuestion();

        ques1.setQuestion("In general,do you approve or disapprove of the efforts of the Indian Nations?");
        ques1.setChoice1("I approve");
        ques1.setChoice2("I disapprove");
        ques1.setObj(ques2);

        ques2.setQuestion("In general,do you approve or disapprove of the efforts of the Indian Nations?");
        ques2.setChoice1("I approve");
        ques2.setChoice2("I disapprove");
        ques2.setObj(ques3);

        ques3.setQuestion("In general,do you approve or disapprove of the efforts of the Indian Nations?");
        ques3.setChoice1("I approve");
        ques3.setChoice2("I disapprove");
        ques3.setObj(ques4);

        ques4.setQuestion("In general,do you approve or disapprove of the efforts of the Indian Nations?");
        ques4.setChoice1("I approve");
        ques4.setChoice2("I disapprove");

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ques1).commit();
        }
    }
}
