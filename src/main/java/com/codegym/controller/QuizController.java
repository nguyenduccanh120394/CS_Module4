package com.codegym.controller;

import com.codegym.model.Question;
import com.codegym.model.Quiz;
import com.codegym.service.quiz.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import com.codegym.model.Quiz;
import com.codegym.service.quiz.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/page")
    public ResponseEntity<Page<Quiz>> findAll(@PageableDefault(size = 12, direction = Sort.Direction.ASC, sort = "id") Pageable pageable) {
        Page<Quiz> products = quizService.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
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
        if (quiz.getName()==null){
            Optional<Quiz> quizCurrent=quizService.findById(quiz.getId());
            quizService.save(quizCurrent.get());
        }

        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Quiz> findById(@RequestParam Long id){
        return new ResponseEntity<>(quizService.findById(id).get(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/quizName")
    public ResponseEntity<Iterable<Quiz>>findByName(@RequestParam("key")String key){
        Iterable<Quiz>quizzes=quizService.findByNameContaining(key);
        return new ResponseEntity<>(quizzes,HttpStatus.OK);
    }

}
