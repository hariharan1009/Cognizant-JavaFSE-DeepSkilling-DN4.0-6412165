package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee get(int id) {
        LOGGER.info("Start");
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start getAllPermanentEmployees");
        return employeeRepository.getAllPermanentEmployees();
    }
}
