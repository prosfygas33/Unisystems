package com.example.Unisystems.EmployeeStrategy;

        import com.example.Unisystems.Employee.Employee;

        import java.util.List;

public interface SearchEmployeeStrategy {

    List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees);
}
