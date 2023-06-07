package com.example.quizapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quizapp.databinding.ActivityQuestionsBinding;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends BaseActivity {

    private ActivityQuestionsBinding activityQuestionsBinding;
    private List<Question> questions = new ArrayList<>();
    private QuestionsAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuestionsBinding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(activityQuestionsBinding.getRoot());
        setUpQuestionsAdapter();
        setUpQuestionRv();
        fetchQuestionDetails();
    }

    private void setUpQuestionRv() {
        activityQuestionsBinding.questionsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        activityQuestionsBinding.questionsRv.setAdapter(questionsAdapter);
    }

    private void setUpQuestionsAdapter() {
        questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setQuestionsList(new ArrayList<>());
    }

    private void fetchQuestionDetails() {
        Call<List<Quiz>> call = quizService.fetchQuizDetails();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                if (response.isSuccessful()) {
                    questions = response.body().get(0).getQuestions();
                    questionsAdapter.setQuestionsList(questions);
                }
            }
            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                showToast("Failed to fetch Data");
            }
        });
    }
}