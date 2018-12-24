package com.shekhar.projector.domain.grading;

import com.shekhar.projector.domain.Designation;

import javax.persistence.*;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private String heading;
    private String summary;
    @ManyToOne
    private Designation designation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id != null ? id.equals(question.id) : question.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", summary='" + summary + '\'' +
                ", designation=" + designation +
                '}';
    }
}