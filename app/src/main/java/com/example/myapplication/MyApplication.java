package com.example.myapplication;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {

    public AppDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "CustomerRecord").build();
    }

    public AppDatabase getDb() {
        return db;
    }

    public void setDb(AppDatabase db) {
        this.db = db;
    }
}
