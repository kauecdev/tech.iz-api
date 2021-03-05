package com.techiz.techiz.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "question", nullable = false)
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qa_fid")
    private List<Answer> answers = new ArrayList<Answer>();

    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }

    public Integer getCode() {
        return code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
