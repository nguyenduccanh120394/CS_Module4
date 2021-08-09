package com.codegym.model;

import jdk.jfr.Category;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private QuestionCategory questionCategory;

    public Question(Long id, String content, QuestionCategory questionCategory) {
        this.id = id;
        this.content = content;
        this.questionCategory = questionCategory;
    }

    public Question(String content, QuestionCategory questionCategory) {
        this.content = content;
        this.questionCategory = questionCategory;
    }
    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategory questionCategory) {
        this.questionCategory = questionCategory;
    }
}
