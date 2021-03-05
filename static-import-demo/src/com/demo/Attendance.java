package com.demo;

import com.example.Day;

public class Attendance {
    private Day DAY;
    private String name;
    private boolean isPresent;

    public Attendance(Day DAY, String name, boolean isPresent) {
        this.DAY = DAY;
        this.name = name;
        this.isPresent = isPresent;
    }

    public String getAttendance()
    {
        String str=null;
        if(isPresent==true)
        {
            str= "Present";
        }
        if(isPresent==false)
        {
            str= "Absent";
        }
        return str;
    }
    @Override
    public String toString() {
        return "Name Of The Employee is: " + name + " DAY is: " + DAY.getDay()
                + " Attendance Status: " + getAttendance();
    }
}
