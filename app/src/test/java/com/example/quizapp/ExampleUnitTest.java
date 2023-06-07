package com.example.quizapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.network.QuizApi;
import com.example.quizapp.network.QuizService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void fetchDetails() throws IOException {
        QuizService quizService = new QuizApi().createQuizService();
        Call <List<Quiz>> call = quizService.fetchQuizDetails();
        List<Quiz> quiz = call.execute().body();
        assertNotNull(quiz);
        assertFalse(quiz.isEmpty());
        System.out.println(quiz.get(0));
    }
}