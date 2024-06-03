package tech.employee.employee_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.employee.employee_data.model.Employee;
import tech.employee.employee_data.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee)
    {
//        employee.setId(Long.parseLong(UUID.randomUUID().toString()));
        employee.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);

        return employeeRepo.save(employee);
    }
    public String deleteEmployee(Long id)
    {
        Employee employee=employeeRepo.findById(id).get();
        employeeRepo.delete(employee);
        return "Employee deleted successfully";
    }
    public List<Employee> getAllEmployee()
    {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee,Long id)
    {
        Employee employee1=employeeRepo.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setRole(employee.getRole());
        employee1.setPhone(employee.getPhone());
        employee1.setImageUrl(employee.getImageUrl());
        employee1.setEmployeeCode(employee.getEmployeeCode());
        return employeeRepo.save(employee1);
    }
    public Employee updateEmployees(Employee employee)
    {
        return employeeRepo.save(employee);
    }
    public String deleteEmployeeById(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }
    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User Id"+id+"not found"));
    }


}
