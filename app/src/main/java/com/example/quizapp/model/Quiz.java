package com.example.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Quiz {

    @SerializedName("_id")
    private String id;

    private Module module;

    private ArrayList<Questions> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }
}
