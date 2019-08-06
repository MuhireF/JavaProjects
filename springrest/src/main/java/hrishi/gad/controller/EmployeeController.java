package hrishi.gad.controller;

import hrishi.gad.entity.Employee;
import hrishi.gad.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller - Mapping logic

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @RequestMapping(method = RequestMethod.GET)
        public List<Employee> findAll(){
            return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
        public Employee findOne(@PathVariable("id") String empId){
        return service.findOne(empId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return employee;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String empId, @RequestBody Employee employee){
        return employee;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empId){

    }
}
