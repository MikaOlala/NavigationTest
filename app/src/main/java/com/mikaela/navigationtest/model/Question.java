package com.mikaela.navigationtest.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Map;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey
    private int id;
    private String question;
    private String drawableName;
    @TypeConverters(ButtonsMapConverter.class)
    private Map<String, Integer> buttons;

    public Question(int id, String question, String drawableName, Map<String, Integer> buttons) {
        this.id = id;
        this.question = question;
        this.drawableName = drawableName;
        this.buttons = buttons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDrawableName() {
        return drawableName;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
    }

    public Map<String, Integer> getButtons() {
        return buttons;
    }

    public void setButtons(Map<String, Integer> buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", drawableName='" + drawableName + '\'' +
                ", buttons=" + buttons +
                '}';
    }
}
