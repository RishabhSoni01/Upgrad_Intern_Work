package org.example;

import org.example.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void logEmployeeAddition(Employee employee) {
        logger.info("Employee added: {}", employee.getEmployeeName());
    }

    public static void logEmployeeRetrieval(int id) {
        logger.info("Employee retrieved with ID: {}", id);
    }

    public static void logEmployeeUpdate(Employee employee) {
        logger.info("Employee information updated: {}", employee.getEmployeeName());
    }
}