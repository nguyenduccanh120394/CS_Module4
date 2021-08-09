package com.codegym.model;

import javax.persistence.*;

@Entity
public class QuizComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private Question question;

    public QuizComponent(Long id, Quiz quiz, Question question) {
        this.id = id;
        this.quiz = quiz;
        this.question = question;
    }

    public QuizComponent(Quiz quiz, Question question) {
        this.quiz = quiz;
        this.question = question;
    }

    public QuizComponent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
