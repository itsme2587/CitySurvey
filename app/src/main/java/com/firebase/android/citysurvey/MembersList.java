package com.firebase.android.citysurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MembersList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_list);

        RecyclerView rv = findViewById(R.id.recycler_view_members);
        rv.setLayoutManager(new LinearLayoutManager(this));
       // rv.setAdapter(new MembersAdapter(this,translation));

    }
}
