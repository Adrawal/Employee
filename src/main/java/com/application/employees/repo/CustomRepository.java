/**
 * 
 */
package com.application.employees.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.employees.dataobject.EmployeeDO;

/**
 * The Interface CustomRepository.
 *
 * @author Aditya Rawal
 */
@Repository
public interface CustomRepository extends MongoRepository<EmployeeDO,String>
{

    
    /**
     * Find by employee name and mobile number and email.
     *
     * @param employeeName the employee name
     * @param mobileNumber the mobile number
     * @param email the email
     * @return the optional
     */
    Optional<EmployeeDO>findByMobileNumberAndEmail(int mobileNumber,String email);
}
