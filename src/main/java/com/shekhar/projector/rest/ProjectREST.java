package com.shekhar.projector.rest;

import com.shekhar.projector.domain.Project;
import com.shekhar.projector.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shekhar.kumar on 10/24/2018.
 */
@RestController
@RequestMapping("project-rest")
public class ProjectREST {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(value = "/ping", produces = "text/html")
    public String ping(){
        return "OK";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Project findById(@PathVariable("id") Long id){
        return projectRepository.findById(id).get();
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach((p) ->
            projects.add(p)
        );
        return projects;
    }

    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public List<Project> create(@RequestBody Project project){
        projectRepository.save(project);
        return findAll();
    }


}