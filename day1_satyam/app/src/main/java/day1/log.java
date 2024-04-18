package day1;
import day1.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class log {


    public static final Logger logger = LoggerFactory.getLogger(log.class);

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