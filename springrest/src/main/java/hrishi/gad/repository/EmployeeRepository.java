package hrishi.gad.repository;

import hrishi.gad.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();
    Employee findOne(String id);
}
