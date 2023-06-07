package com.example.quizapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.network.QuizApi;
import com.example.quizapp.network.QuizService;

public class BaseActivity extends AppCompatActivity {

    protected QuizService quizService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpApiService();
    }

    public void setUpApiService() {
        QuizApi quizApi = new QuizApi();
        quizService = quizApi.createQuizService();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
