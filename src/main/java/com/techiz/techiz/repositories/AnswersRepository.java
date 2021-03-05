package com.techiz.techiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techiz.techiz.models.Answer;

@Repository
public interface AnswersRepository extends CrudRepository<Answer, Integer> {
}
