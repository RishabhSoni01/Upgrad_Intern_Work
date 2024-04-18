package org.example.Day1;

import org.example.Day1.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {


    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void logEmployeeAddition(Employee employee) {
        logger.info("Employee added: {}", employee.getName());
    }

    public static void logEmployeeRetrieval(int id) {
        logger.info("Employee retrieved with ID: {}", id);
    }

    public static void logEmployeeUpdate(Employee employee) {
        logger.info("Employee information updated: {}", employee.getName());
    }
}