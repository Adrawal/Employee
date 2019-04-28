/**
 * 
 */
package com.application.employees.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * The Class EmployeeDataView.
 *
 * @author Aditya Rawal
 */
public class EmployeeDataView extends BaseInfoView
{

    /** The id. */
    private String id;

    /** The employee name. */
    private String employeeName;

    /** The employee age. */
    private int employeeAge;

    /** The employee salary. */
    private int employeeSalary;

    /** The Employee department. */
    private String EmployeeDepartment;

    /** The designation. */
    private String designation;

    /** The gender. */
    private String gender;

    /** The email. */
    private String email;

    /** The mobile number. */
    private int mobileNumber;

    /** The profile image. */
    private String profileImage;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Gets the employee name.
     *
     * @return the employee name
     */
    public String getEmployeeName()
    {
        return employeeName;
    }

    /**
     * Sets the employee name.
     *
     * @param employeeName the new employee name
     */
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    /**
     * Gets the employee age.
     *
     * @return the employee age
     */
    public int getEmployeeAge()
    {
        return employeeAge;
    }

    /**
     * Sets the employee age.
     *
     * @param employeeAge the new employee age
     */
    public void setEmployeeAge(int employeeAge)
    {
        this.employeeAge = employeeAge;
    }

    /**
     * Gets the employee salary.
     *
     * @return the employee salary
     */
    public int getEmployeeSalary()
    {
        return employeeSalary;
    }

    /**
     * Sets the employee salary.
     *
     * @param employeeSalary the new employee salary
     */
    public void setEmployeeSalary(int employeeSalary)
    {
        this.employeeSalary = employeeSalary;
    }

    /**
     * Gets the employee department.
     *
     * @return the employee department
     */
    public String getEmployeeDepartment()
    {
        return EmployeeDepartment;
    }

    /**
     * Sets the employee department.
     *
     * @param employeeDepartment the new employee department
     */
    public void setEmployeeDepartment(String employeeDepartment)
    {
        EmployeeDepartment = employeeDepartment;
    }

    /**
     * Gets the designation.
     *
     * @return the designation
     */
    public String getDesignation()
    {
        return designation;
    }

    /**
     * Sets the designation.
     *
     * @param designation the new designation
     */
    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Gets the mobile number.
     *
     * @return the mobile number
     */
    public int getMobileNumber()
    {
        return mobileNumber;
    }

    /**
     * Sets the mobile number.
     *
     * @param mobileNumber the new mobile number
     */
    public void setMobileNumber(int mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Gets the profile image.
     *
     * @return the profile image
     */
    public String getProfileImage()
    {
        return profileImage;
    }

    /**
     * Sets the profile image.
     *
     * @param profileImage the new profile image
     */
    public void setProfileImage(String profileImage)
    {
        this.profileImage = profileImage;
    }

    
  /*  public static void main (String args []) {
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        EmployeeDataView emp = new EmployeeDataView();
        try {
            String json = ow.writeValueAsString(emp);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
