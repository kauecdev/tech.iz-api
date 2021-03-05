package com.techiz.techiz.controllers;

import com.techiz.techiz.models.Answer;
import com.techiz.techiz.models.Question;
import com.techiz.techiz.repositories.AnswersRepository;
import com.techiz.techiz.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/questions")
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private AnswersRepository answersRepository;


    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question) {
        questionsRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll() {
        Iterable<Question> questionsResponse = questionsRepository.findAll();
        List<Question> questionsList = new ArrayList<Question>();
        questionsResponse.forEach(questionsList::add);
        Collections.shuffle(questionsList);
        return new ResponseEntity<List<Question>>(questionsList, HttpStatus.OK);
    }


    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Question>> getById(@PathVariable Integer id) {
        Optional<Question> question;
        try {
            question = questionsRepository.findById(id);
            return new ResponseEntity<Optional<Question>>(question, HttpStatus.OK);
        } catch (NoSuchElementException err) {
            return new ResponseEntity<Optional<Question>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/{code}")
    public ResponseEntity<Answer> save(@PathVariable("code") Integer code, @RequestBody Answer answer) {
        Question question;
        question = questionsRepository.findByCode(code);

        List<Answer> list = question.getAnswers();
        list.add(answer);
        question.setAnswers(list);

        answersRepository.save(answer);
        questionsRepository.save(question);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
