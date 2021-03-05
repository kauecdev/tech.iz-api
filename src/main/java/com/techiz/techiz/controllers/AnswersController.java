package com.techiz.techiz.controllers;

import com.techiz.techiz.models.Answer;
import com.techiz.techiz.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/answers")
public class AnswersController {

    @Autowired
    private AnswersRepository answersRepository;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> getAll() {
        Iterable<Answer> answers = answersRepository.findAll();
        return new ResponseEntity<Iterable<Answer>>(answers, HttpStatus.OK);
    }
}
