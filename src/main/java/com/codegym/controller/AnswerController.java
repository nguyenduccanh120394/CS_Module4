package com.codegym.controller;

import com.codegym.model.Answer;
import com.codegym.service.answer.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    IAnswerService answerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Answer>> findAll(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.ACCEPTED);
    }
}
