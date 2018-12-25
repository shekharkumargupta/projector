package com.shekhar.projector.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class TaskStatus {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public TaskStatus(){}

    public TaskStatus(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskStatus taskStatus = (TaskStatus) o;

        return id != null ? id.equals(taskStatus.id) : taskStatus.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}