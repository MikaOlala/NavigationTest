package com.mikaela.navigationtest;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;

import com.mikaela.navigationtest.model.Question;
import com.mikaela.navigationtest.room.QuestionViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends FragmentActivity {

    private List<Integer> questionHistory = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();
    private Map<String, Integer> buttons = new HashMap<>();
    private QuestionViewModel questionViewModel;
    private NavController nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        setList();
        questionHistory.add(1);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        nav = navHostFragment.getNavController();
    }

    public int getCurrentQuestionId() {
        return questionHistory.get(questionHistory.size()-1);
    }

    public void nextPage(int nextId) {
        Bundle bundle = new Bundle();
        bundle.putInt("questionId", nextId);

        boolean hasPicture = false;
        for (Question q : questions) {
            if (q.getId()==nextId) {
                hasPicture = q.getDrawableName()!=null;
                break;
            }
        }

        if (hasPicture)
            nav.navigate(R.id.actio);
    }

    public void logs(kotlin.collections.ArrayDeque<NavBackStackEntry> backQueue) {
        int index = 0;
        for (NavBackStackEntry n : backQueue) {
            Log.i("element " + index, String.valueOf(n.getDestination().getLabel()));
            index++;
        }
    }

    private void setList() {
        buttons.put("Модный и яркий", 2);
        buttons.put("Нежный и пастельный", 7);
        buttons.put("Темный и блестящий", 9);
        questions.add(new Question(1, "Идеальный цвет маникюра?", null, getButtons()));
        questions.add(new Question(2, "Обожаешь наряжаться?", null, getStandardButtons(3, 5)));
        questions.add(new Question(3, "Любишь ходить по магазинам?", null, getStandardButtons(4, 6)));
        questions.add(new Question(4, "Следишь за модными тенденциями?", null, getStandardButtons(15, 6)));
        buttons.put("Кросовки", 6);
        buttons.put("Туфли", 3);
        questions.add(new Question(5, "Стильные туфли или модные кросовки?", null, getButtons()));
        questions.add(new Question(6, "Увлекаешься спортом?", null, getStandardButtons(16, 8)));
        questions.add(new Question(7, "Нравится розовый цвет?", null, getStandardButtons(8, 5)));
        questions.add(new Question(8, "Привлекают цветочки и ободки?", null, getStandardButtons(17, 18)));
        questions.add(new Question(9, "Приятно выделяться из толпы?", null, getStandardButtons(12, 10)));
        questions.add(new Question(10, "Лучше чувствовать себя комфортно, чем выглядеть нарядно?", null, getStandardButtons(11, 12)));
        questions.add(new Question(11, "Отдаешь предпочтение натуральному макияжу?", null, getStandardButtons(18, 8)));
        buttons.put("Дымчатые", 14);
        buttons.put("Яркие", 13);
        questions.add(new Question(12, "Дымчатый карандаш для глаз или яркие тени для век?", null, getButtons()));
        questions.add(new Question(13, "Эксперементируешь с цветом волос?", null, getStandardButtons(19, 11)));
        questions.add(new Question(14, "Хочешь быть знаменитой?", null, getStandardButtons(20, 13)));

        questions.add(new Question(15, "Ты Стелла, истинная модница", null, null));
        questions.add(new Question(16, "Ты Лейла, девушка-спортсменка", null, null));
        questions.add(new Question(17, "Ты Флора, одеваешься цветасто и воздушно", null, null));
        questions.add(new Question(18, "Ты Блум, естественна, всё гениальное просто", null, null));
        questions.add(new Question(19, "Ты Текна, любишь ультрамодное и выделяться из толпы", null, null));
        questions.add(new Question(20, "Ты Муза, изысканная и элегантная", null, null));

        Log.i("list", questions.toString());

        questionViewModel.insert(questions);

//        questions.add(new Question(1, "Хочешь иметь крылья?", null, ));
//        questions.add(new Question(2, "ВСЕ ХОТЯТ", null, ));
//        questions.add(new Question(3, "Хочешь крутое оружие?", null, ));
//        questions.add(new Question(4, "Конечно же хочешь!", null, ));
//        questions.add(new Question(5, "Хочешь призрачное зрение?", null, ));
//        questions.add(new Question(6, "Сможешь сэкономить на электричестве", null, ));
//        questions.add(new Question(7, "Любишь татуировки?", null, ));
//        questions.add(new Question(8, "Но они светятся!", null, ));
    }

    private Map<String, Integer> getButtons() {
        Map<String, Integer> buttons = new HashMap<>(this.buttons);
        this.buttons.clear();
        return buttons;
    }

    private Map<String, Integer> getStandardButtons(int yesId, int noId) {
        buttons.put("Да", yesId);
        buttons.put("Нет", noId);
        Map<String, Integer> buttons = new HashMap<>(this.buttons);
        this.buttons.clear();
        return buttons;
    }
}