package com.example.siva1.bunky;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by siva1 on 18/04/2017.
 */
public class RespObj implements Serializable {
    String SemNo;
    String RollNo;
    String Name;
    String Programme;
    String date;
    ArrayList<Attendance>attend;

    @Override
    public String toString() {
        return "RespObj{" +
                "SemNo='" + SemNo + '\'' +
                ", RollNo='" + RollNo + '\'' +
                ", Name='" + Name + '\'' +
                ", Programme='" + Programme + '\'' +
                ", date='" + date + '\'' +
                ", attend=" + attend +
                '}';
    }
}
