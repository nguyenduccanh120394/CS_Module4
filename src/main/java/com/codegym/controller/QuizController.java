package com.codegym.controller;

import com.codegym.model.Quiz;
import com.codegym.service.quiz.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizs")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    IQuizService quizService;

    @GetMapping
    public ResponseEntity<Iterable<Quiz>>findAll(){
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Quiz> remove(@RequestParam Long id){
        quizService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<Quiz> edit(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Quiz> findById(@RequestParam Long id){
        return new ResponseEntity<>(quizService.findById(id).get(),HttpStatus.ACCEPTED);
    }


}
