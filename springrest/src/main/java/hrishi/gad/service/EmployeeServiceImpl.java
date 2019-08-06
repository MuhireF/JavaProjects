package hrishi.gad.service;

import hrishi.gad.entity.Employee;
import hrishi.gad.exception.EmployeeNotFoundException;
import hrishi.gad.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(String id) {
        Employee employee = employeeRepository.findOne(id);
        if(employee != null)
            return employee;
        throw new EmployeeNotFoundException("Employee with id " + id + " not found");
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee update(String id, Employee employee) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
