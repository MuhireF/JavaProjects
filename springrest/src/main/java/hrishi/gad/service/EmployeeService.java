package hrishi.gad.service;

import hrishi.gad.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
    Employee update(String id, Employee employee);
    void delete(String id);
}
