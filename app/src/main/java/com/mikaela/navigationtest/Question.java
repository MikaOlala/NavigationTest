package com.mikaela.navigationtest;

import java.util.Map;

public class Question {
    private int id;
    private String question;
    private String drawableName;
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
