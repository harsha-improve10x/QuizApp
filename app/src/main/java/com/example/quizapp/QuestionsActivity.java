package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuestionsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getSupportActionBar().setTitle("QuizBee");
    }
}