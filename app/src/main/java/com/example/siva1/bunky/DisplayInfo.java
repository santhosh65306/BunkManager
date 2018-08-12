package com.example.siva1.bunky;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {
     RespObj details=null;
    TextView name,sem,date,roll,prog;
    Button showatt,bunk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendancedisp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        details= (RespObj) getIntent().getSerializableExtra("obj");
        name= (TextView) findViewById(R.id.tv_name);
        sem= (TextView) findViewById(R.id.tv_semester);
        date= (TextView) findViewById(R.id.tv_upto);
        roll= (TextView) findViewById(R.id.tv_roll);
        prog= (TextView) findViewById(R.id.tv_program);
        name.setText(details.Name);
        sem.setText(details.SemNo);
        date.setText(details.date);
        roll.setText(details.RollNo);
        prog.setText(details.Programme);
        showatt= (Button) findViewById(R.id.bt_seeattend);
        showatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayInfo.this, Attendancedisp.class);
                intent.putExtra("obj1", details);
                startActivity(intent);
            }
        });
        bunk= (Button) findViewById(R.id.bt_gobunk);
        bunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayInfo.this,Bunkmanager.class);
                intent.putExtra("obj1", details);
                startActivity(intent);
            }
        });




    }

}
