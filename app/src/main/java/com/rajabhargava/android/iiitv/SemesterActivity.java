package com.rajabhargava.android.iiitv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        Button sem1 = (Button) findViewById(R.id.b_sem1);
        Button sem2 = (Button) findViewById(R.id.b_sem2);
//        Button sem3 = (Button) findViewById(R.id.b_sem3);

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SemesterActivity.this,CourseNameActivity.class);
                i.putExtra("semester","Semester I");
                i.putExtra("branch",getIntent().getStringExtra("branch"));
                startActivity(i);
            }
        });

        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SemesterActivity.this,CourseNameActivity.class);
                i.putExtra("semester","Semester II");
                i.putExtra("branch",getIntent().getStringExtra("branch"));
                startActivity(i);
            }
        });


    }
}
