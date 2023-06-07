package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionItemLayoutBinding;
import com.example.quizapp.model.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {
    private List<Question> questionList;
    public void setQuestionsList(List<Question> questionList) {
        this.questionList = questionList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionItemLayoutBinding questionItemLayoutBinding = QuestionItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        QuestionsViewHolder questionsViewHolder = new QuestionsViewHolder(questionItemLayoutBinding);
        return questionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.questionItemLayoutBinding.questionsNumberTxt.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
