package com.codegym.controller;

import com.codegym.model.Exam;
import com.codegym.service.exam.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin("*")
public class ExamController {
    @Autowired
    IExamService examService;


    @GetMapping()
    public ResponseEntity<Iterable<Exam>> findAll(){
        return new ResponseEntity<>(examService.findAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/create")
    public ResponseEntity<Exam> create(@RequestBody Exam exam){
        return new ResponseEntity<>(examService.save(exam),HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchByIdUser")
    public ResponseEntity<Iterable<Exam>> findByIdUser(@RequestParam Long id){
        return new ResponseEntity<>(examService.findByIdUser(id),HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Exam> edit(@RequestBody Exam exam){
        return new ResponseEntity<>(examService.save(exam),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Exam> delete(@RequestParam Long id){
        examService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }




}
