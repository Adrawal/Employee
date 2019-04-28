/**
 * 
 */
package com.application.employees.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.employees.service.EmployeeService;
import com.application.employees.utils.EmployeeException;
import com.application.employees.view.BaseInfoView;
import com.application.employees.view.EmployeeDataView;
import com.application.employees.view.EmployeeListView;
import static com.application.employees.utils.Constant.SUCCESS_CODE;
import static com.application.employees.utils.Constant.SUCCESS_MESSAGE;
import static com.application.employees.utils.Constant.RECORDS_NOT_FOUND_CODE;
import static com.application.employees.utils.Constant.RECORDS_NOT_FOUND_MESSAGE;
import static com.application.employees.utils.Constant.FALIURE_CODE;
import static com.application.employees.utils.Constant.FALIURE_MESSAGE;
import static com.application.employees.utils.Constant.EMPLOYEE_ALREADY_EXIST_CODE;
import static com.application.employees.utils.Constant.EMPLOYEE_ALREADY_EXIST;
import static com.application.employees.utils.Constant.EMPLOYEE_SUCCESSFULLY_SAVED_CODE;
import static com.application.employees.utils.Constant.EMPLOYEE_SUCCESSFULLY_SAVED_MESSAGE;
import static com.application.employees.utils.Constant.EMPLOYEE_SUCCESFULLY_UPDATED_CODE;
import static com.application.employees.utils.Constant.EMPLOYEE_SUCCESFULLY_UPDATED_STATUS;

/**
 * The Class EmployeeController.
 *
 * @author aditya rawal
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController
{

    /** The service. */
    @Autowired
    private EmployeeService service;

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * Gets the all employees.
     *
     * @return the all employees
     */
    @GetMapping("/fetchAllEmployees")
    public EmployeeListView getAllEmployees()
    {
        long startTime = System.currentTimeMillis();
        Marker marker = MarkerFactory.getMarker("inside fetch All Employee method");
        log.info(marker, "method invoked getAllEmployees");
        EmployeeListView employeeList = new EmployeeListView();
        try {
            List<EmployeeDataView> allEmployeeInfo = service.getAllEmployeeInfo();
            if (!allEmployeeInfo.isEmpty() && allEmployeeInfo.size() > 0) {
                employeeList.setEmployeeList(allEmployeeInfo);
                employeeList.setCode(SUCCESS_CODE);
                employeeList.setMsg(SUCCESS_MESSAGE);
            } else {
                employeeList.setCode(RECORDS_NOT_FOUND_CODE);
                employeeList.setMsg(RECORDS_NOT_FOUND_MESSAGE);

            }
            if (log.isDebugEnabled()) {

                log.debug(marker, "total Employee Retrieved message {{}}, count of Employee {{}}",
                    employeeList.getMsg(), allEmployeeInfo.size());
            }

        } catch (EmployeeException excption) {

            log.error(marker, "error->{{}}", excption.getMessage());
            employeeList.setCode(FALIURE_CODE);
            employeeList.setMsg(FALIURE_MESSAGE);

        } catch (Exception e) {
            log.error(marker, "error->{{}}", e.getMessage());
            employeeList.setCode(FALIURE_CODE);
            employeeList.setMsg(FALIURE_MESSAGE);

        }

        log.info(marker, "total time taken to complete operation {{} }ms", System.currentTimeMillis() - startTime);

        return employeeList;
    }

    @PostMapping("/saveEmployeeDetails")
    public EmployeeDataView saveEmployeeInfo(@RequestBody EmployeeDataView employeeRequest)
    {
        long startTime = System.currentTimeMillis();
        Marker marker = MarkerFactory.getMarker("inside save Employee Info method");
        log.info(marker, "method invoked saveEmployeeInfo");
        EmployeeDataView employeeInfo = new EmployeeDataView();

        try {
            EmployeeDataView employeeExist = service.isEmployeeExist(employeeRequest);
            if (!StringUtils.isEmpty(employeeExist) && !StringUtils.isEmpty(employeeExist.getEmployeeName())) {
                employeeInfo.setCode(EMPLOYEE_ALREADY_EXIST_CODE);
                employeeInfo.setMsg(EMPLOYEE_ALREADY_EXIST);

            } else {
                employeeInfo = service.saveEmployee(employeeRequest);
                employeeInfo.setCode(EMPLOYEE_SUCCESSFULLY_SAVED_CODE);
                employeeInfo.setMsg(EMPLOYEE_SUCCESSFULLY_SAVED_MESSAGE);
            }

        } catch (EmployeeException exception) {
            log.error(marker, "error->{{}}", exception.getMessage());
            employeeInfo.setCode(FALIURE_CODE);
            employeeInfo.setMsg(FALIURE_MESSAGE);

        } catch (Exception e) {
            log.error(marker, "error->{{}}", e.getMessage());
            employeeInfo.setCode(FALIURE_CODE);
            employeeInfo.setMsg(FALIURE_MESSAGE);

        }

        log.info(marker, "total time taken to complete operation {{} }ms", System.currentTimeMillis() - startTime);

        return employeeInfo;
    }

    @PostMapping("/updateEmployee")
    public EmployeeDataView updateEmployee(@RequestBody EmployeeDataView employee)
    {
        long startTime = System.currentTimeMillis();
        Marker marker = MarkerFactory.getMarker("inside update Employee method");
        log.info(marker, "method invoked updateEmployee");
        EmployeeDataView updateEmployeeInfo = new EmployeeDataView();
        try {
            updateEmployeeInfo = service.updateEmployeeInfo(employee);
            updateEmployeeInfo.setCode(EMPLOYEE_SUCCESFULLY_UPDATED_CODE);
            updateEmployeeInfo.setMsg(EMPLOYEE_SUCCESFULLY_UPDATED_STATUS);

        } catch (EmployeeException exception) {
            log.error(marker, "error->{{}}", exception.getMessage());
            updateEmployeeInfo.setCode(FALIURE_CODE);
            updateEmployeeInfo.setMsg(FALIURE_MESSAGE);

        } catch (Exception e) {

            log.error(marker, "error->{{}}", e.getMessage());
            updateEmployeeInfo.setCode(FALIURE_CODE);
            updateEmployeeInfo.setMsg(FALIURE_MESSAGE);

        }
        log.info(marker, "total time taken to complete operation {{} }ms", System.currentTimeMillis() - startTime);

        return updateEmployeeInfo;
    }

    @DeleteMapping("/removeEmployee/{id}")
    public BaseInfoView removeEmployee(@PathVariable String id)
    {
        long startTime = System.currentTimeMillis();
        Marker marker = MarkerFactory.getMarker("inside remove Employee method");
        log.info(marker, "method invoked removeEmployee");
        BaseInfoView removeImployeeInfo = new BaseInfoView();
        try {
            removeImployeeInfo = service.removeImployeeInfo(id);

        } catch (EmployeeException exception) {
            log.error(marker, "error->{{}}", exception.getMessage());
            removeImployeeInfo.setCode(FALIURE_CODE);
            removeImployeeInfo.setMsg(FALIURE_MESSAGE);

        } catch (Exception e) {

            log.error(marker, "error->{{}}", e.getMessage());
            removeImployeeInfo.setCode(FALIURE_CODE);
            removeImployeeInfo.setMsg(FALIURE_MESSAGE);

        }
        log.info(marker, "total time taken to complete operation {{} }ms", System.currentTimeMillis() - startTime);
        return removeImployeeInfo;
    }

}
