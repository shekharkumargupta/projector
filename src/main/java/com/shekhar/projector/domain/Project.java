package com.shekhar.projector.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shekhar.kumar on 10/24/2018.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private Set<Task> tasks;
    @OneToMany
    private Set<ProjectResource> resources;
    private Date created;

    public Project(){}

    public Project(String name){
        this.name = name;
    }

    public void addResource(ProjectResource resource){
        if(resources == null){
            resources = new HashSet<>();
        }
        resources.add(resource);
    }

    public void addTask(Task task){
        if(tasks == null){
            tasks = new HashSet<>();
        }
        tasks.add(task);
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<ProjectResource> getResources() {
        return resources;
    }

    public void setResources(Set<ProjectResource> resources) {
        this.resources = resources;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return id != null ? id.equals(project.id) : project.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", resources=" + resources +
                ", created=" + created +
                '}';
    }
}