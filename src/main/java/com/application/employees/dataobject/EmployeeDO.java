/**
 * 
 */
package com.application.employees.dataobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class EmployeeDO.
 *
 * @author Aditya Rawal
 */
@Document
public class EmployeeDO
{


/** The id. */
@Id
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

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((EmployeeDepartment == null) ? 0 : EmployeeDepartment.hashCode());
    result = prime * result + ((designation == null) ? 0 : designation.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + employeeAge;
    result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
    result = prime * result + employeeSalary;
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + mobileNumber;
    result = prime * result + ((profileImage == null) ? 0 : profileImage.hashCode());
    return result;
}

/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj)
{
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    EmployeeDO other = (EmployeeDO) obj;
    if (EmployeeDepartment == null) {
        if (other.EmployeeDepartment != null)
            return false;
    } else if (!EmployeeDepartment.equals(other.EmployeeDepartment))
        return false;
    if (designation == null) {
        if (other.designation != null)
            return false;
    } else if (!designation.equals(other.designation))
        return false;
    if (email == null) {
        if (other.email != null)
            return false;
    } else if (!email.equals(other.email))
        return false;
    if (employeeAge != other.employeeAge)
        return false;
    if (employeeName == null) {
        if (other.employeeName != null)
            return false;
    } else if (!employeeName.equals(other.employeeName))
        return false;
    if (employeeSalary != other.employeeSalary)
        return false;
    if (gender == null) {
        if (other.gender != null)
            return false;
    } else if (!gender.equals(other.gender))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    if (mobileNumber != other.mobileNumber)
        return false;
    if (profileImage == null) {
        if (other.profileImage != null)
            return false;
    } else if (!profileImage.equals(other.profileImage))
        return false;
    return true;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
    return "EmployeeDO [id=" + id + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
        + ", employeeSalary=" + employeeSalary + ", EmployeeDepartment=" + EmployeeDepartment + ", designation="
        + designation + ", gender=" + gender + ", email=" + email + ", mobileNumber=" + mobileNumber + ", profileImage="
        + profileImage + "]";
}


}
