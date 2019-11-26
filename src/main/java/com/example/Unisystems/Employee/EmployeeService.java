package com.example.Unisystems.Employee;

import com.example.Unisystems.BusinessUnit.BusinessUnitRepository;
import com.example.Unisystems.Company.CompanyRepository;
import com.example.Unisystems.Department.DepartmentRepository;
import com.example.Unisystems.SearchEmployeeStrategy;
import com.example.Unisystems.SearchEmployeeStrategyFactory;
import com.example.Unisystems.Unit.UnitRepository;
import com.example.Unisystems.Error;
import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BusinessUnitRepository businessUnitRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private EmployeeMapper mapper;
    @Autowired
    private SearchEmployeeStrategyFactory factory;


    public List<EmployeeResponse> getAllEmployees() {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            employees.add(mapper.mapEmployeeResponseFromEmployee(employee));
        }
        return employees;
    }

    public GenericResponse<List<EmployeeResponse>>getAllEmployeesById(Long id) {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getId())
                employees.add(mapper.mapEmployeeResponseFromEmployee(employee));

        }
        if(employees.isEmpty())  return new GenericResponse<>(new Error(0,"Not Found", "No employee record exist for given id " + id));
        return new GenericResponse<>(employees);
    }

    public GenericResponse<List<EmployeeResponse>> getAllEmployeesByCriteria(String criteria, Long id) {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees;// = new ArrayList<>();
        SearchEmployeeStrategy strategy = factory.makeStrategyForCriteria(criteria);
        if(strategy == null)  return new GenericResponse<>(new Error(0,"Wrong Input", "This " +  criteria + " do not exist"));

        employees = mapper.mapAllEmployees(strategy.execute(id, retrieveEmployees));

        if(employees.isEmpty())  return new GenericResponse<>(new Error(0,"Not Found", "No employee record exist for given id " + id));

        return new GenericResponse<>(employees);
    }

    /*

    public EmployeeDetailsResponse updateEmployee(Employee employee, Long id) {
        Optional<Employee> employeeOptional  = repository.findById(id);

        employee.setId(id);
        employee.setCompany(getCompany(employee.getCompanyName()));
        employee.setBusinessUnit(getBusinessUnit(employee.getBusinessUnitName()));
        employee.setDepartment(getDepartment(employee.getDepartmentName()));
        employee.setUnit(getUnit(employee.getUnitName()));
        repository.save(employee);
        return mapper.mapEmployeeDetailsResponse(employee);
    }

    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "OK";
    }


     */

/*
    private Company getCompany(String name){
        Iterable<Company> retrieveCompanyes = companyRepository.findAll();
        for(Company company: retrieveCompanyes){
            if(name.equals(company.getName()))
                return company;
        }
        return null;
    }

    private BusinessUnit getBusinessUnit(String name){
        Iterable<BusinessUnit> retrieveBusinessUnits = businessUnitRepository.findAll();
        for(BusinessUnit businessUnit: retrieveBusinessUnits){
            if(name.equals(businessUnit.getName()))
                return businessUnit;
        }
        return null;
    }

    private Department getDepartment(String name){
        Iterable<Department> retrieveDepartments = departmentRepository.findAll();
        for(Department department: retrieveDepartments){
            if(name.equals(department.getName()))
                return department;
        }
        return null;
    }

    private Unit getUnit(String name){
        Iterable<Unit> retrieveUnits = unitRepository.findAll();
        for(Unit unit: retrieveUnits){
            if(name.equals(unit.getName()))
                return unit;
        }
        return null;
    }

 */


    /*
    public List<EmployeeResponse> getAllEmployeesByCriteria(String searchCriteria, Long id) {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();

        if(searchCriteria.equalsIgnoreCase("company"))
            //return  new SearchEmployeeByCompanyStrategy();//employees = searchInCompany(retrieveEmployees, id);
        if(searchCriteria.equalsIgnoreCase("businessUnit"))
            //employees = searchInBusinessUnit(retrieveEmployees, id);
        if(searchCriteria.equalsIgnoreCase("department"))
            //employees = searchInDepartment(retrieveEmployees, id);
        if(searchCriteria.equalsIgnoreCase("unit"))
            //employees = searchInUnit(retrieveEmployees, id);
        return employees;
    }
*/

    /*
    private List<EmployeeResponse> searchInUnit(Iterable<Employee> retrieveEmployees, Long id) {
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getUnit().getId())
                employees.add(mapper.mapEmployeeResponse(employee));
        }
        return employees;
    }

    private List<EmployeeResponse> searchInDepartment(Iterable<Employee> retrieveEmployees, Long id) {
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getDepartment().getId())
                employees.add(mapper.mapEmployeeResponse(employee));
        }
        return employees;
    }

    private List<EmployeeResponse> searchInBusinessUnit(Iterable<Employee> retrieveEmployees, Long id) {
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getBusinessUnit().getId())
                employees.add(mapper.mapEmployeeResponse(employee));
        }
        return employees;
    }

    private List<EmployeeResponse> searchInCompany(Iterable<Employee> retrieveEmployees, Long id) {
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getCompany().getId())
                employees.add(mapper.mapEmployeeResponse(employee));
        }
        return employees;
    }
*/
}