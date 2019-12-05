package com.example.Unisystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UnisystemsApplication{ //implements CommandLineRunner {
/*
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

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PrivilegeRepository privilegeRepository;
*/
	public static void main(java.lang.String[] args) {
		SpringApplication.run(UnisystemsApplication.class, args);
	}
/*
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

		List<String> updateList = new ArrayList<>();

		Task task1 = new Task("Java app", "Tournament", 5, 4, 3, TaskStatus.DONE, null, updateList);
		List<Task> taskList = new ArrayList<>();
		taskList.add(task1);
		taskRepository.save(task1);

		Privilege readPrivilege = new Privilege("Read");
		Privilege writePrivilege = new Privilege("Write");
		privilegeRepository.save(readPrivilege);
		privilegeRepository.save(writePrivilege);

		List<Privilege> adminPrivileges = new ArrayList<>();
		adminPrivileges.add(readPrivilege);
		adminPrivileges.add(writePrivilege);

		List<Privilege> employeePrivileges = new ArrayList<>();
		employeePrivileges.add(readPrivilege);


		Role adminRole = new Role(RoleAssignment.ADMIN,adminPrivileges);
		Role employeeRole = new Role(RoleAssignment.EMPLOYEE,employeePrivileges);
		roleRepository.save(adminRole);
		roleRepository.save(employeeRole);


		Employee emp1 = new Employee(111, "Panagiotis", "Milios", "Kimolou 14", "2108817081", new Date(113, 12, 1), null, true, true, c1, b1, d2, u4, taskList, "Junior Developer",adminRole);
		List<Employee> employees= new ArrayList<>();
		employees.add(emp1);
		task1.setAssignedEmployees(employees);
		Employee emp2 = new Employee(122, "Petros", "Euthimiou", "Spetson 17", "2108834081", new Date(111, 5, 15), null, true, true, c1, b1, d3, u5, null, "Senior Developer", employeeRole);
		Employee emp3 = new Employee(123, "Mitsos", "Kitsou", "Spartis 25", "2108855284", new Date(110, 11, 5), null , true, true, c1, b1, d1, u2, null, "Hr officer",employeeRole);
		Employee emp4 = new Employee(124, "Kostas", "Fleggas", "Tsoxa 13", "2107440081", new Date(112, 7, 15), null, true, true, c1, b1, d3, u5, null, " Manager",employeeRole);
		Employee emp5 = new Employee(125, "George", "Dom", "Ymitou 40", "2105520081", new Date(112, 2, 15), new Date(120, 2, 15), true, true, c1, b1, d2, u4, null, " Mid-Senior Developer",employeeRole);

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
		employeeRepository.save(emp5);

    }
 */
}
