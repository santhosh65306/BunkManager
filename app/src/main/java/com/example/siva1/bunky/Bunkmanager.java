package com.example.siva1.bunky;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bunkmanager extends AppCompatActivity {
    RespObj details;
    ArrayList<String> courselist;
    TextView currpercent,hrstob;
    EditText hrstobunk,outof;
    Button htob;
    Spinner courses;
    int currentcourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunkmanager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hrstobunk= (EditText) findViewById(R.id.et_hrstobunk);
        hrstob= (TextView) findViewById(R.id.tv_hrstobunk);
        htob= (Button) findViewById(R.id.bt_hourstobunk);
        outof= (EditText) findViewById(R.id.et_outof);
        currpercent= (TextView) findViewById(R.id.tv_currper);
        details= (RespObj) getIntent().getSerializableExtra("obj1");
        courselist=new ArrayList<>();
        courses= (Spinner) findViewById(R.id.sp_course);
        for(int i=0;i<details.attend.size();i++){
            courselist.add(details.attend.get(i).COURSECODE);
        }
        ArrayAdapter<String> deptdataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,courselist);
        deptdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courses.setAdapter(deptdataAdapter);
        courses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentcourse = position;
                currpercent.setText(String.valueOf(details.attend.get(currentcourse).PERCENTAGEWITHEXEMP));
                hrstobunk.setText("");
                hrstob.setText("");
                outof.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currentcourse = -1;
            }
        });
        htob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!hrstobunk.getText().toString().equals(""))&&(!outof.getText().toString().equals(""))) {

                    int totpres = details.attend.get(currentcourse).TOTALPRESENT;
                    int exemhrs = details.attend.get(currentcourse).EXEMPTIONHOURS;
                    int tothrs = details.attend.get(currentcourse).TOTALHOURS;
                    System.out.println(totpres);
                    System.out.println(exemhrs);
                    System.out.println(tothrs);
                    int hrs = Integer.parseInt(hrstobunk.getText().toString());
                    int out=Integer.parseInt(outof.getText().toString());

                    int num = totpres+(out-hrs) + exemhrs;
                    System.out.println(num);

                    System.out.println(hrs);
                    double result = ((num * 100) / (tothrs + out));

                    System.out.println(result);
                    //result=result*100;
                    if(out>=hrs) {
                        hrstob.setText(String.valueOf(result));
                    }else{
                        Toast.makeText(Bunkmanager.this, "Out of should be greater.", Toast.LENGTH_SHORT).show();
                        hrstobunk.setText("");
                        outof.setText("");
                    }
                }
            }
        });


    }

}
