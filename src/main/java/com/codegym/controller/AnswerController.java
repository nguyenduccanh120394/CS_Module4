package com.codegym.controller;

import com.codegym.model.Answer;
import com.codegym.service.answer.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    IAnswerService answerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Answer>> findAll(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/question")
    public ResponseEntity<Iterable<Answer>> findAllbyQuestion(@RequestParam Long id){
        return new ResponseEntity<>(answerService.findAllByQuestion(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Answer> create(@RequestBody Answer answer){
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Answer> findById(@RequestParam Long id){
        return new ResponseEntity<>(answerService.findById(id).get(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Answer> edit(@RequestBody Answer answer){
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    public ResponseEntity<Answer> remove(@RequestParam Long id){
        answerService.remove(id);
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }
}
