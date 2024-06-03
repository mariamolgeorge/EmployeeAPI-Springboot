package tech.employee.employee_data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.employee.employee_data.model.Employee;
import tech.employee.employee_data.service.EmployeeService;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
public void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
