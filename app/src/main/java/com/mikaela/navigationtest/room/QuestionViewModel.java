package com.mikaela.navigationtest.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mikaela.navigationtest.model.Question;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository repository;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        repository = new QuestionRepository(application);
    }

    public void insert(List<Question> questions) {
        repository.insert(questions);
    }

    public LiveData<Question> getQuestion(int id) {
        return repository.getQuestion(id);
    }
}
