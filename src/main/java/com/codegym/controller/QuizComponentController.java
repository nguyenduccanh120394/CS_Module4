package com.codegym.controller;


import com.codegym.model.QuizComponent;
import com.codegym.service.quizComponent.IQuizComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizComponents")
@CrossOrigin("*")
public class QuizComponentController {

    @Autowired
    IQuizComponentService quizComponentService;

    @GetMapping
    public ResponseEntity<Iterable<QuizComponent>> findAll(){
        return new ResponseEntity<>(quizComponentService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getQuestions")
    public ResponseEntity<Iterable<QuizComponent>> findByIdQuiz(@RequestParam Long id,@PageableDefault( size = 1) Pageable pageable){
        return new ResponseEntity<>(quizComponentService.searchByIdQuiz(id, pageable),HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<QuizComponent> create(@RequestBody QuizComponent quizComponent){
        return new ResponseEntity<>(quizComponentService.save(quizComponent),HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<QuizComponent> remove(@RequestParam Long id){
        quizComponentService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<QuizComponent> edit(@RequestBody QuizComponent quizComponent){
        return new ResponseEntity<>(quizComponentService.save(quizComponent),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<QuizComponent> findById(@RequestParam Long id){
        return new ResponseEntity<>(quizComponentService.findById(id).get(),HttpStatus.ACCEPTED);
    }
}
