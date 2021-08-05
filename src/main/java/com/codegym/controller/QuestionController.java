package com.codegym.controller;

import com.codegym.model.Answer;
import com.codegym.model.Question;
import com.codegym.service.answer.IAnswerService;
import com.codegym.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    IAnswerService answerService;

    @Autowired
    IQuestionService questionService;

    @GetMapping("")
    public ResponseEntity<Iterable<Question>> findAll(){
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<Question> findById(@RequestParam Long id){
        return new ResponseEntity<>(questionService.findById(id).get(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Question> create(@RequestBody Question question, Answer answer1){
        answerService.save(answer1);
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Question> delete(@RequestParam Long id){
        questionService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Question> delete(@RequestBody Question question){
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Question>> search(@RequestParam String questionCategory){
        return new ResponseEntity<>(questionService.findByCategory(questionCategory), HttpStatus.ACCEPTED);
    }

}
