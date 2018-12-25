package com.shekhar.projector.repositories;

import com.shekhar.projector.domain.Designation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shekhar.kumar on 10/30/2018.
 */
@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long>{
}