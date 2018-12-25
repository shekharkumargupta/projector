package com.shekhar.projector.repositories.grading;

import com.shekhar.projector.domain.grading.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shekhar.kumar on 10/30/2018.
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}