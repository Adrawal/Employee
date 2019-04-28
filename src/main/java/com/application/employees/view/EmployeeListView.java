/**
 * 
 */
package com.application.employees.view;

import java.util.List;

/**
 * The Class EmployeeListView.
 *
 * @author Aditya Rawal
 */
public class EmployeeListView extends BaseInfoView
{

    /** The Employee list. */
    private List<EmployeeDataView> EmployeeList;

    /**
     * Gets the employee list.
     *
     * @return the employee list
     */
    public List<EmployeeDataView> getEmployeeList()
    {
        return EmployeeList;
    }

    /**
     * Sets the employee list.
     *
     * @param employeeList the new employee list
     */
    public void setEmployeeList(List<EmployeeDataView> employeeList)
    {
        EmployeeList = employeeList;
    }

}
