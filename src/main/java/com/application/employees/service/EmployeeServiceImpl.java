package com.application.employees.service;

import static com.application.employees.utils.Constant.EMPLOYEE_DOES_NOT_EXIST_CODE;
import static com.application.employees.utils.Constant.EMPLOYEE_DOES_NOT_EXIST_STATUS;
import static com.application.employees.utils.Constant.SUCCESFULLY_DELETED_CODE;
import static com.application.employees.utils.Constant.SUCCESFULLY_DELETED_STATUS;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.application.employees.dataobject.EmployeeDO;
import com.application.employees.repo.CustomRepository;
import com.application.employees.repo.EmployeeRepository;
import com.application.employees.view.BaseInfoView;
import com.application.employees.view.EmployeeDataView;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * The Class EmployeeServiceImpl.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private CustomRepository customRepo;

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    MapperFacade mapper = mapperFactory.getMapperFacade();

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /*
     * (non-Javadoc)
     * @see com.application.employees.service.EmployeeService#getAllEmployeeInfo()
     */
    @Override
    public List<EmployeeDataView> getAllEmployeeInfo()
    {
        Marker marker = MarkerFactory.getMarker("inside getAllEmployeeInfo method");
        log.info(marker, "method invokation starts ");
        List<EmployeeDataView> EmployeeList = new ArrayList<EmployeeDataView>();
        List<EmployeeDO> employeeResult = employeeRepo.findAll();
        if (log.isDebugEnabled()) {
            log.debug(marker, "total employee retrieved from database {{}}", employeeResult.size());
        }
        // Using Java 8 Stream feature and Orika mapper framework, mapped 2 different object that have similar fields.
        employeeResult.forEach(employeeDo -> {
            EmployeeDataView employee = mapper.map(employeeDo, EmployeeDataView.class);
            EmployeeList.add(employee);
        });

        /*
         * db.Employees.find({}).sort({"Emp salary":-1}).limit(1) //for first highest salary
         * db.Employees.find({}).sort({"Emp salary":-1}).skip(1).limit(1)
         */

        return EmployeeList;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.application.employees.service.EmployeeService#saveEmployee(com.application.employees.view.EmployeeDataView)
     */
    @Override
    public EmployeeDataView saveEmployee(EmployeeDataView employeeDataRequest)
    {
        Marker marker = MarkerFactory.getMarker("inside SaveEmployee method");
        log.info(marker, "method invokation starts ");
        // Creating new ID combination of employeeName + department name + mobile number
        String newID = createEmployeeID(employeeDataRequest);

        if (log.isDebugEnabled()) {
            log.debug(marker, "newly created EmployeeID {{}}", newID);
        }
        employeeDataRequest.setId(newID);
        EmployeeDataView employeeData = new EmployeeDataView();
        try {
            EmployeeDO mapedDO = mapper.map(employeeDataRequest, EmployeeDO.class);
            EmployeeDO savedEmployeeData = employeeRepo.save(mapedDO);
            if (log.isDebugEnabled()) {
                log.debug(marker, "newly created Employee {{}}", savedEmployeeData.getId());
            }
            employeeData = mapper.map(savedEmployeeData, EmployeeDataView.class);

        } catch (Exception e0) {
            log.info(e0.getMessage());
            e0.printStackTrace();
        }

        return employeeData;
    }

    private String createEmployeeID(EmployeeDataView employeeDataRequest)
    {
        String newID;
        UUID randomUUID = UUID.randomUUID();
        newID = randomUUID.toString();
        return newID;
    }

    /*
     * (non-Javadoc)
     * @see com.application.employees.service.EmployeeService#updateEmployeeInfo(com.application.employees.view.
     * EmployeeDataView)
     */
    @Override
    public EmployeeDataView updateEmployeeInfo(EmployeeDataView employeeData)
    {
        EmployeeDataView response = new EmployeeDataView();
        Marker marker = MarkerFactory.getMarker("inside updateEmployeeInfo method");
        log.info(marker, "method invokation starts ");
        EmployeeDataView employeeExist = isEmployeeExist(employeeData);
        if (!StringUtils.isEmpty(employeeExist.getId())) {
            employeeRepo.deleteById(employeeExist.getId());
            EmployeeDO empDO = mapper.map(employeeData, EmployeeDO.class);
            EmployeeDO updateDO = employeeRepo.save(empDO);
            response = mapper.map(updateDO, EmployeeDataView.class);
        } else {
            response.setCode(EMPLOYEE_DOES_NOT_EXIST_CODE);
            response.setMsg(EMPLOYEE_DOES_NOT_EXIST_STATUS);
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * @see com.application.employees.service.EmployeeService#removeImployeeInfo(int)
     */
    @Override
    public BaseInfoView removeImployeeInfo(String id)
    {
        BaseInfoView response = new BaseInfoView();
        Marker marker = MarkerFactory.getMarker("inside removeImployeeInfo method");
        log.info(marker, "method invokation starts ");
        employeeRepo.deleteById(id);
        response.setCode(SUCCESFULLY_DELETED_CODE);
        response.setMsg(SUCCESFULLY_DELETED_STATUS);

        return response;
    }

    @Override
    public EmployeeDataView isEmployeeExist(EmployeeDataView emp)
    {
        String id = emp.getId();
        Marker marker = MarkerFactory.getMarker("inside isEmployeeExist method");
        log.info(marker, "method invokation starts ");
        EmployeeDataView employeeData = new EmployeeDataView();

        if (!StringUtils.isEmpty(id)) {
            Optional<EmployeeDO> findById = findById(id);
            EmployeeDO employeeDO = findById.get();
            employeeData = mapper.map(employeeDO, EmployeeDataView.class);
            if (log.isDebugEnabled()) {
                log.debug(marker, "employee data found in database based on id{{}} ", employeeData.getId());

            }
        } else {
            Optional<EmployeeDO> employeeExist =
                customRepo.findByMobileNumberAndEmail(emp.getMobileNumber(), emp.getEmail());
            if (employeeExist.isPresent()) {
                EmployeeDO employeeDO = employeeExist.get();
                employeeData = mapper.map(employeeDO, EmployeeDataView.class);
            }
            if (log.isDebugEnabled()) {
                log.debug(marker, "employee data found in databasebased on employeeName mobile number and email{{}} ",
                    employeeData.getId());

            }
        }

        return employeeData;
    }

    private Optional<EmployeeDO> findById(String id)
    {
        Optional<EmployeeDO> findById = employeeRepo.findById(id);
        return findById;
    }

}
