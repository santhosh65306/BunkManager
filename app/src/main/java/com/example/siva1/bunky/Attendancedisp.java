package com.example.siva1.bunky;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Attendancedisp extends AppCompatActivity {
    RespObj details;
    TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendancedisp2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        details= (RespObj) getIntent().getSerializableExtra("obj1");
        table= (TableLayout) findViewById(R.id.tl_table);
        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        TextView course=new TextView(this);
        course.setText("Course");
        TextView tothrs =new TextView(this);
        tothrs.setText("Total\n Hours");
        TextView totpre=new TextView(this);
        totpre.setText("Total\n Present");
        TextView totab=new TextView(this);
        totab.setText("Total\n Absent");
        TextView exemphrs=new TextView(this);
        exemphrs.setText("Exemption\n Hours");
        TextView preexmp=new TextView(this);
        preexmp.setText("Percent \nwith Exemp");
        TextView preatt =new TextView(this);
        preatt.setText("Percent \nof Attend");
        row.addView(course);
        row.addView(tothrs);
        row.addView(totpre);
        row.addView(totab);
        row.addView(exemphrs);
        row.addView(preexmp);
        row.addView(preatt);

        table.addView(row, 0);
        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        for(int i=0;i<details.attend.size();i++){
            Attendance a=details.attend.get(i);
            TableRow row1= new TableRow(this);
            TableRow.LayoutParams lp1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row1.setLayoutParams(lp1);
            TextView course1=new TextView(this);
            course1.setText(a.COURSECODE);
            course1.setWidth(width / 7);
            TextView tothrs1 =new TextView(this);
            tothrs1.setText(String.valueOf(a.TOTALHOURS));
            tothrs1.setWidth(width / 7);
            TextView totpre1=new TextView(this);
            totpre1.setText(String.valueOf(a.TOTALPRESENT));
            totpre1.setWidth(width / 7);
            TextView totab1=new TextView(this);
            totab1.setText(String.valueOf(a.TOTALABSENT));
            totab1.setWidth(width/7);
            TextView exemphrs1=new TextView(this);
            exemphrs1.setText(String.valueOf(a.EXEMPTIONHOURS));
            exemphrs1.setWidth(width / 7);
            TextView preexmp1=new TextView(this);
            preexmp1.setText(String.valueOf(a.PERCENTAGEWITHEXEMP));
            preexmp1.setWidth(width / 7);
            TextView preatt1 =new TextView(this);
            preatt1.setText(String.valueOf(a.PERCENTAGEOFATTENDANCE));
            preatt1.setWidth(width / 7);
            row1.addView(course1);
            row1.addView(tothrs1);
            row1.addView(totpre1);
            row1.addView(totab1);
            row1.addView(exemphrs1);
            row1.addView(preexmp1);
            row1.addView(preatt1);
            table.addView(row1,i+1);
        }



    }

}
