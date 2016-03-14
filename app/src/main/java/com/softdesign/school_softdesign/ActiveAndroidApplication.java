package com.softdesign.school_softdesign;

import com.activeandroid.ActiveAndroid;
import android.app.Application;

public class ActiveAndroidApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}