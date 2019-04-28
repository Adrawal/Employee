/**
 * 
 */
package com.application.employees.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.employees.dataobject.EmployeeDO;

/**
 * @author aditya Rawal
 *
 */
@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeDO, String>{

}
