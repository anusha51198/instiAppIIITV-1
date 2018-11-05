package com.rajabhargava.android.iiitv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String TAG = "MainActivity";

    private DrawerLayout dl;
    private ActionBarDrawerToggle adt;
    private Button qabtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qabtn = (Button) findViewById(R.id.b_qa);
        qabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QAActivity.class);
                startActivity(intent);
            }
        });


        dl = (DrawerLayout) findViewById(R.id.dl_main);
        adt = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        adt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(adt);
        adt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_main);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id == R.id.menu_about)
                {
                    Toast.makeText(MainActivity.this,"About",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_hec) {
                    Toast.makeText(MainActivity.this,"HEC Guilidelines",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_cal) {
                    Toast.makeText(MainActivity.this,"Academic Calendar",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_timetable){
                    Toast.makeText(MainActivity.this,"Time Table",Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        Button courses = (Button) findViewById(R.id.b_courses);

        final Intent i = new Intent(this,BranchActivity.class);

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return adt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}
