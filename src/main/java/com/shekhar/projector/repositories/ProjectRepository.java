package com.shekhar.projector.repositories;

import com.shekhar.projector.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shekhar.kumar on 10/24/2018.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}