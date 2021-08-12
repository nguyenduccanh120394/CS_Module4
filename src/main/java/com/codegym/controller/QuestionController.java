package com.codegym.controller;

import com.codegym.model.Answer;
import com.codegym.model.Question;
import com.codegym.service.answer.IAnswerService;
import com.codegym.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    IQuestionService questionService;

    @GetMapping("")
    public ResponseEntity<Iterable<Question>> findAll(){
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Question>> findAll(@PageableDefault(size = 12, direction = Sort.Direction.ASC, sort = "id") Pageable pageable) {
        Page<Question> products = questionService.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Question> findById(@RequestParam Long id){
        return new ResponseEntity<>(questionService.findById(id).get(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Question> create(@RequestBody Question question){
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
    @GetMapping("/{idQuestionCategory}")
    public ResponseEntity<Iterable<Question>> findByIdCategory(@PathVariable Long idQuestionCategory){
        Iterable<Question>questions=questionService.findAllByQuestionCategoryId(idQuestionCategory);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

}
