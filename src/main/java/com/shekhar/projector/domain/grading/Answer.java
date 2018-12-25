package com.shekhar.projector.domain.grading;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by shekhar.kumar on 10/30/2018.
 */
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private Integer rate;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return id != null ? id.equals(answer.id) : answer.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                '}';
    }
}