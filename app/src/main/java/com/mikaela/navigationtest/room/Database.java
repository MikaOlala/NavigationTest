package com.mikaela.navigationtest.room;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mikaela.navigationtest.model.Question;

@androidx.room.Database(entities = {
        Question.class
    }, version = 1, exportSchema = false
)
public abstract class Database extends RoomDatabase {
    private static Database instance;

    public abstract QuestionDao questionDao();

    public static Database getDatabase(final Context context) {
        if (instance==null) {
            synchronized (Database.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    Database.class, "db.db").build();
                }
            }
        }
        return instance;
    }
}
