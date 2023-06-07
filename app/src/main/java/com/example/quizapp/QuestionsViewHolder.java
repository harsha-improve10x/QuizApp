package com.example.quizapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionItemLayoutBinding;

public class QuestionsViewHolder extends RecyclerView.ViewHolder {
    QuestionItemLayoutBinding questionItemLayoutBinding;
    public QuestionsViewHolder(@NonNull QuestionItemLayoutBinding questionItemLayoutBinding) {
        super(questionItemLayoutBinding.getRoot());
        this.questionItemLayoutBinding = questionItemLayoutBinding;
    }
}
