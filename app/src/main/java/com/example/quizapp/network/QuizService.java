package com.example.quizapp.network;

import com.example.quizapp.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuizService {

    @GET("api/479dd07f8c1d482e9219f7dcb48e25f4/renuTodo")
    Call <List<Quiz>> fetchQuizDetails();
}
