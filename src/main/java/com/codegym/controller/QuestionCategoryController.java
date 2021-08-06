package com.codegym.controller;

import com.codegym.model.QuestionCategory;
import com.codegym.service.questionCategory.IQuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questionCategories")
public class QuestionCategoryController {

    @Autowired
    IQuestionCategoryService questionCategoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<QuestionCategory>> findAll(){
        return new ResponseEntity<>(questionCategoryService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<QuestionCategory> findById(@RequestParam Long id){
        return new ResponseEntity<>(questionCategoryService.findById(id).get(), HttpStatus.ACCEPTED);
    }

    @PutMapping("")
    public ResponseEntity<QuestionCategory> edit(@RequestBody QuestionCategory questionCategory){
        return new ResponseEntity<>(questionCategoryService.save(questionCategory), HttpStatus.ACCEPTED);
    }

}
