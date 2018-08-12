package com.example.siva1.bunky;

import java.io.Serializable;

/**
 * Created by siva1 on 18/04/2017.
 */
public class Attendance implements Serializable{
    int TOTALHOURS;
    int PERCENTAGEWITHEXEMP;
    int PERCENTAGEOFATTENDANCE;
    int TOTALPRESENT;
    int EXEMPTIONHOURS;
    String COURSECODE;
    int TOTALABSENT;

    @Override
    public String toString() {
        return "Attendance{" +
                "TOTALHOURS=" + TOTALHOURS +
                ", PERCENTAGEWITHEXEMP=" + PERCENTAGEWITHEXEMP +
                ", PERCENTAGEOFATTENDANCE=" + PERCENTAGEOFATTENDANCE +
                ", TOTALPRESENT=" + TOTALPRESENT +
                ", EXEMPTIONHOURS=" + EXEMPTIONHOURS +
                ", COURSECODE='" + COURSECODE + '\'' +
                ", TOTALABSENT=" + TOTALABSENT +
                '}';
    }
}

