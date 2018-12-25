package com.shekhar.projector.domain.grading;

import com.shekhar.projector.domain.Employee;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class ReviewForm {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Employee employee;
    private int year;
    @OneToMany
    private Map<Question, Answer> questionAnswerMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<Question, Answer> getQuestionAnswerMap() {
        return questionAnswerMap;
    }

    public void setQuestionAnswerMap(Map<Question, Answer> questionAnswerMap) {
        this.questionAnswerMap = questionAnswerMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewForm that = (ReviewForm) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ReviewForm{" +
                "id=" + id +
                ", employee=" + employee +
                ", year=" + year +
                ", questionAnswerMap=" + questionAnswerMap +
                '}';
    }
}