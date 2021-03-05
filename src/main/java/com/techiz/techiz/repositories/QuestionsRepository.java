package com.techiz.techiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techiz.techiz.models.Question;

@Repository
public interface QuestionsRepository extends CrudRepository<Question, Integer> {
    Question findByCode(Integer id);
}
