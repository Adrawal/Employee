/**
 * 
 */
package com.application.employees.service;

import java.util.List;

import com.application.employees.view.BaseInfoView;
import com.application.employees.view.EmployeeDataView;

/**
 * The Interface EmployeeService.
 *
 * @author Aditya Rawal
 */
public interface EmployeeService
{
    
    /**
     * Gets the all employee info.
     *
     * @return the all employee info
     */
    public List<EmployeeDataView> getAllEmployeeInfo();
    
    /**
     * Save employee.
     *
     * @param employeeData the employee data
     * @return the employee data view
     */
    public EmployeeDataView saveEmployee(EmployeeDataView employeeData);
    
    /**
     * Update employee info.
     *
     * @param employeeData the employee data
     * @return the employee data view
     */
    public EmployeeDataView updateEmployeeInfo(EmployeeDataView employeeData);
    
    /**
     * Removes the imployee info.
     *
     * @param id the id
     * @return the base info view
     */
    public BaseInfoView removeImployeeInfo(String id);
    
    /**
     * Checks if is employee exist.
     *
     * @param emp the emp
     * @return the employee data view
     */
    public EmployeeDataView isEmployeeExist(EmployeeDataView emp);
    
    
    

    
}
