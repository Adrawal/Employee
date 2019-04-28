# Employee project
this repository contains java code base for Employee API
this project was generated using spring boot initiliazer language as JAVA project as Maven Project Spring boot version 2.1.4.

System Requirement:-
JAvA JDK/JRE 1.8 or higher, IDE (Spring tool suite or any other preference), Postman tool

version :-
employee-0.0.1

Application feature
===================
this application is developed to maintain the employee information such as personal info, contact info. In this Application user gets to perform below operation :-
>#### *retrieve All Employee Info*
>#### *add new Employee*
>#### *remove employee info*
>#### *update an exsting Employee info*


to initilaize project :-
========================
>##### first you need to clone this project in your local " git clone https://github.com/Adrawal/Employee.git "
>##### open this project in any one of the IDE(STS/Eclipce/Intellij) based on your preference. i prefer STS.
>##### after opening project you need to run command "mvn clean install" or "mvn clean install -Dmaven.test.skip = true" to skip the test class
>##### once project succesfully build you can start the server. as this application is based on Spring boot you don't need to use external server.
>##### server starts at 8181 port number
>##### After project start you can  perform above Operation.
-------------------------------

>##### *retrieve All Employee Info* this is post call need to pass Employee JSON object http://localhost:8181/employee/saveEmployeeDetails
>#### *add new Employee* this is GET call without passing any input parameter http://localhost:8181/employee/fetchAllEmployees
>#### *remove employee info* this is DELETE call need to pass Employee ID http://localhost:8181/employee/removeEmployee/5cc55dd44cc76b16c0526055
>#### *update an exsting Employee info* this is POST call to update Employee data http://localhost:8181/employee/updateEmployee
>#### example of Employee Json
------------------------------
{
	
  "employeeName" : "Aditya Rawal",
  "employeeAge" : 26,
  "employeeSalary" : 50000,
  "designation" : "counsltant",
  "gender" : "male",
  "email" : "adrawal07@gmail.com",
  "mobileNumber" : 3001,
  "profileImage" : null,
  "employeeDepartment" : "IT Department"
}

 Project architecture diagram
==================================
![MVC_design_pattern](https://user-images.githubusercontent.com/35422207/56868895-330fa980-6a16-11e9-9621-eafe226112f7.jpg)

  





