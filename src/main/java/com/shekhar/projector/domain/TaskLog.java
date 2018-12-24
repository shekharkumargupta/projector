package com.shekhar.projector.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class TaskLog {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private float spentHrs;
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSpentHrs() {
        return spentHrs;
    }

    public void setSpentHrs(float spentHrs) {
        this.spentHrs = spentHrs;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskLog taskLog = (TaskLog) o;

        return id != null ? id.equals(taskLog.id) : taskLog.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", spentHrs=" + spentHrs +
                ", createdDate=" + createdDate +
                '}';
    }
}