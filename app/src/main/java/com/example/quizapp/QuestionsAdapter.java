package com.example.quizapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionItemLayoutBinding;
import com.example.quizapp.model.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {
    private List<Question> questionList;
    protected int currentPositionNumber = 0;
    private OnItemActionListener onItemActionListener;
    public void setQuestionsList(List<Question> questionList) {
        this.questionList = questionList;
        notifyDataSetChanged();
    }

    public void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
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
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Question question = questionList.get(position);
        holder.questionItemLayoutBinding.questionsNumberTxt.setText(String.valueOf(position+1));
        holder.questionItemLayoutBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(question);
            currentPositionNumber = position;
        });
        if (currentPositionNumber == position) {
            holder.questionItemLayoutBinding.questionsNumberTxt.setTextColor(Color.parseColor("#311B92"));
        } else {
            holder.questionItemLayoutBinding.questionsNumberTxt.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
