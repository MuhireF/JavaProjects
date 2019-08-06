package hrishi.gad.repository;

import hrishi.gad.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository{
    @Override
    public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("John Doe", "jd@gmail.com", 20000 ));
        employee.add(new Employee("Smith Doe", "sd@gmail.com", 30000 ));
        return employee;

    }

    @Override
    public Employee findOne(String id) {
        if(id.equals("100"))
            return null;
        return new Employee("John Doe", "jd@gmail.com", 20000 );
    }
}
