package com.codegym.model;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private Correct correct;
    @ManyToOne
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(Long id, String content, Correct correct, Question question) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.question = question;
    }

    public Answer(String content, Correct correct, Question question) {
        this.content = content;
        this.correct = correct;
        this.question = question;
    }

    public Answer() {
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

    public Correct getCorrect() {
        return correct;
    }

    public void setCorrect(Correct correct) {
        this.correct = correct;
    }
}
