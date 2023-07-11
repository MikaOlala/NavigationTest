package com.mikaela.navigationtest.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mikaela.navigationtest.model.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Question> questions);

    @Query("select * from questions where id = :id")
    LiveData<Question> getQuestion(int id);
}
