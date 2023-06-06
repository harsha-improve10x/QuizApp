package com.example.quizapp;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.network.QuizApi;
import com.example.quizapp.network.QuizService;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setUpApiService();
    }

    public void setUpApiService() {
        QuizApi quizApi = new QuizApi();
        QuizService quizService = quizApi.createQuizService();
    }
}
