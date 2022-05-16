package com.example.coldcallingapp;

import java.lang.reflect.Constructor;
import java.util.Locale;

public class Student {
    private String mFirst;
    private String mLast;

    public Student(String first, String last) {
        mFirst = first;
        mLast = last;
    }

    public String getFirst() {
        return mFirst;
    }

    public String getLast() {
        return mLast;
    }

    public String getFileName(){
        return (mFirst + "_" + mLast).toLowerCase();
    }

    public  String toString(){
        return (mFirst + " " + mLast);
    }

    private int mTimesCalled = 0;
    private long mLastcalled;



    public int getTimesCalled() {
        return mTimesCalled;
    }

    public void setTimesCalled(int timesCalled) {
        mTimesCalled = timesCalled;
    }

    public long getLastcalled() {
        return mLastcalled;
    }

    public void setLastcalled(long lastcalled) {
        mLastcalled = lastcalled;
    }
}
