package com.mikaela.navigationtest.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mikaela.navigationtest.model.Question;

import java.util.List;

public class QuestionRepository {
    private QuestionDao questionDao;

    public QuestionRepository(Application application) {
        Database database = Database.getDatabase(application);
        questionDao = database.questionDao();
    }

    public LiveData<Question> getQuestion(int id) {
        return questionDao.getQuestion(id);
    }

    public void insert(List<Question> questions) {
        new insertAsync(questionDao).execute(questions);
    }

    public static class insertAsync extends AsyncTask<List<Question>, Void, Void> {
        private QuestionDao questionDao;

        public insertAsync(QuestionDao questionDao) {
            this.questionDao = questionDao;
        }

        @Override
        protected Void doInBackground(List<Question>[] lists) {
            questionDao.insert(lists[0]);
            return null;
        }
    }
}
