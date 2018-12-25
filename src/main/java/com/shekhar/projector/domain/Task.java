package com.shekhar.projector.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private TaskType taskType;
    @ManyToOne
    private Employee assignee;
    @ManyToOne
    private Employee assignedBy;
    private Date createdOn;
    @OneToOne
    private TaskStatus status;
    @OneToMany
    private Set<Task> subTasks;
    @OneToMany
    private Set<TaskLog> logs;




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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    public Employee getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Employee assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Set<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(Set<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public Set<TaskLog> getLogs() {
        return logs;
    }

    public void setLogs(Set<TaskLog> logs) {
        this.logs = logs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id != null ? id.equals(task.id) : task.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskType=" + taskType +
                ", assignee=" + assignee +
                ", assignedBy=" + assignedBy +
                ", createdOn=" + createdOn +
                ", status=" + status +
                ", subTasks=" + subTasks +
                ", logs=" + logs +
                '}';
    }
}