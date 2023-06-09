package com.example.quizapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

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
    private int currentQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuestionsBinding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(activityQuestionsBinding.getRoot());
        setUpQuestionsAdapter();
        setUpQuestionRv();
        fetchQuestionDetails();
        handleNextBtn();
        handlePreviousBtn();
    }

    private void setUpQuestionRv() {
        activityQuestionsBinding.questionsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        activityQuestionsBinding.questionsRv.setAdapter(questionsAdapter);
    }

    private void setUpQuestionsAdapter() {
        questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setQuestionsList(new ArrayList<>());
        questionsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(Question question) {
                showData(question);
            }
        });
    }

    private void fetchQuestionDetails() {
        Call<List<Quiz>> call = quizService.fetchQuizDetails();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                if (response.isSuccessful()) {
                    questions = response.body().get(0).getQuestions();
                    questionsAdapter.setQuestionsList(questions);
                    showData(questions.get(0));
                }
            }
            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                showToast("Failed to fetch Data");
            }
        });
    }

    private void showData(Question question) {
        activityQuestionsBinding.questionTxt.setText(question.getQuestion());
        activityQuestionsBinding.rb1.setText(question.getAnswers().get(0));
        activityQuestionsBinding.rb2.setText(question.getAnswers().get(1));
        activityQuestionsBinding.rb3.setText(question.getAnswers().get(2));
        activityQuestionsBinding.rb4.setText(question.getAnswers().get(3));
        currentQuestionNumber = question.getNumber()-1;
        questionsAdapter.currentPositionNumber = currentQuestionNumber;
        questionsAdapter.notifyDataSetChanged();
        if (currentQuestionNumber == 0) {
            activityQuestionsBinding.questionPrevBtn.setVisibility(View.INVISIBLE);
        } else {
            activityQuestionsBinding.questionPrevBtn.setVisibility(View.VISIBLE);
        }
        if (currentQuestionNumber == questions.size()-1) {
            activityQuestionsBinding.questionNextBtn.setVisibility(View.INVISIBLE);
            activityQuestionsBinding.submitBtn.setVisibility(View.VISIBLE);
        } else {
            activityQuestionsBinding.questionNextBtn.setVisibility(View.VISIBLE);
            activityQuestionsBinding.submitBtn.setVisibility(View.INVISIBLE);
        }
    }

    private void handleNextBtn() {
            activityQuestionsBinding.questionNextBtn.setOnClickListener(v -> {
                try {
                currentQuestionNumber++;
                Question question = questions.get(currentQuestionNumber);
                showData(question);
                } catch (Exception exception) {
                    showToast("Invalid Question");
                }
            });
    }

    private void handlePreviousBtn() {
        activityQuestionsBinding.questionPrevBtn.setOnClickListener(v -> {
            try {
                currentQuestionNumber--;
                Question question = questions.get(currentQuestionNumber);
                showData(question);
            } catch (Exception exception) {
                showToast("Invalid Question");
            }
        });
    }
}