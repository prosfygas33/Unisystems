package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.BusinessUnit.BusinessUnitRepository;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Company.CompanyRepository;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Department.DepartmentRepository;
import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeRepository;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskRepository;
import com.example.Unisystems.Task.TaskStatus;
import com.example.Unisystems.Unit.Unit;
import com.example.Unisystems.Unit.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UnisystemsApplication implements CommandLineRunner {

	@Autowired
	BusinessUnitRepository businessUnitRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	UnitRepository unitRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	TaskRepository taskRepository;

	public static void main(java.lang.String[] args) {
		SpringApplication.run(UnisystemsApplication.class, args);
	}

	@Override
	public void run(java.lang.String... args) throws Exception {

		Company c1 = new Company("UniSystems");
		//Company c2 = new Company("ACS","Transportation Services");

		companyRepository.save(c1);

		BusinessUnit b1 = new BusinessUnit("BusinessUnitA", c1);
		BusinessUnit b2 = new BusinessUnit("BusinessUnitB", c1);

		businessUnitRepository.save(b1);
		businessUnitRepository.save(b2);

		//BusinessUnit b3 = new BusinessUnit("BusinessUnitA","A",c2);
		//BusinessUnit b4 = new BusinessUnit("BusinessUnitB","B",c2);

		Department d1 = new Department("Human Resources", b1);
		Department d2 = new Department("IT Services", b1);
		Department d3 = new Department("Management", b2);

		departmentRepository.save(d1);
		departmentRepository.save(d2);
		departmentRepository.save(d3);

		Unit u1 = new Unit("Fire Squad", d1);
		Unit u2 = new Unit("Hiring Squad", d1);
		Unit u3 = new Unit("Database Management Squad", d2);
		Unit u4 = new Unit("Debugging Squad", d2);
		Unit u5 = new Unit("Shareholders", d3);

		unitRepository.save(u1);
		unitRepository.save(u2);
		unitRepository.save(u3);
		unitRepository.save(u4);
		unitRepository.save(u5);


		Task task1=new Task("Java app","Tournament",5,4,3, TaskStatus.DONE,task1.getUpdateList(),"Petros");
		taskRepository.save(task1);


		Employee emp1 = new Employee(111,"Panagiotis", "Milios", "Kimolou 14", "2108817081", new Date(113, 12, 1), new Date(), true, true, c1, b1, d2, u4,emp1.getTasksOwned(task1),"Junior Developer");
		Employee emp2 = new Employee(122,"Petros", "Euthimiou", "Spetson 17", "2108834081", new Date(111, 5, 15), new Date(), true, true, c1, b1, d3, u5,emp2.getTasksOwned() ,"Senior Developer");
		Employee emp3 = new Employee(123,"Mitsos", "Kitsou", "Spartis 25", "2108855284", new Date(110, 11, 5), new Date(), true, true, c1, b1, d1, u2,emp3.getTasksOwned() ,"Hr officer");
		Employee emp4 = new Employee(124,"Kostas", "Fleggas", "Tsoxa 13", "2107440081", new Date(112, 7, 15), new Date(), true, true, c1, b1, d3, u5, emp4.getTasksOwned()," Manager");
		Employee emp5 = new Employee(125,"George", "Dom", "Ymitou 40", "2105520081", new Date(112, 2, 15), new Date(), true, true, c1, b1, d2, u4, emp5.getTasksOwned()," Mid-Senior Developer");



		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
		employeeRepository.save(emp5);
	}
}
