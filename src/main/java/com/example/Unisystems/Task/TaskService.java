package com.example.Unisystems.Task;


import com.example.Unisystems.Employee.EmployeeRepository;
import com.example.Unisystems.Employee_Task.Employee_Task_Mapper;
import com.example.Unisystems.*;
import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeRepository;
import com.example.Unisystems.Error;
import com.example.Unisystems.TaskStrategy.SearchTaskStrategy;
import com.example.Unisystems.TaskStrategy.SearchTaskStrategyFactory;
import org.graalvm.compiler.nodes.java.LoadExceptionObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private Employee_Task_Mapper employee_task_mapper;

    @Autowired
    private SearchTaskStrategyFactory searchTaskStrategyFactory;

    public GenericResponse<TaskResponse> getTaskById(Long id) {
        Iterable<Task> retrievedTasks = taskRepository.findAll();
        TaskResponse taskResponse = null;

        for (Task task: retrievedTasks){
            if(id == task.getId())
                taskResponse = taskMapper.mapTaskResponseFromTask(task);
        }
        if (taskResponse == null)
            return new GenericResponse<>(new Error(0, "Not Found", "No Task record exist for given id " + id));
        return new GenericResponse<>(taskResponse);
    }

    public GenericResponse<String> createTask(TaskRequest taskRequest) {
        Task newTask = mapper.mapTaskFromTaskRequest(taskRequest);
        try {
            taskRepository.save(newTask);
            return new GenericResponse<>("Post Successful");
        } catch (Exception e) {
            return new GenericResponse<>("Post UnSuccessful");
        }

        return genericResponse;
    }

    public GenericResponse<TaskResponse> updateTaskFromTaskRequest(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId()).orElseThrow(()->new RuntimeException("There is no task with this id"));
        Iterable<Employee> employeeList= employeeRepository.findAllById(taskRequest.getEmployeesIds());
        ///Check if employees requested are in the same Unit by taking the distinct unit names
        final List<String> distinctUnitNames = StreamSupport.stream(employeeList.spliterator(), false)
                .map(employee -> employee.getUnit().getName())
                .distinct()
                .collect(Collectors.toList());
        if(distinctUnitNames.size() > 1){
            throw new RuntimeException("The employees not at the same Unit");
        }
        final Task taskNew =  mapper.mapTaskFromTaskRequest(taskRequest);
        task.setTitle(taskNew.getTitle());
        task.setDesc(taskNew.getDesc());
        task.setEstimationA(taskNew.getEstimationA());
        task.setEstimationB(taskNew.getEstimationB());
        task.setEstimationC(taskNew.getEstimationC());
        List<Employee> employeeListNew = StreamSupport.stream(employeeList.spliterator(), false)
                .collect(Collectors.toList());
        task.getAssignedEmployees().clear();
        task.setAssignedEmployees(employeeListNew);
        taskRepository.save(task);
        return getTaskById(task.getId());
    }


    public GenericResponse<List<TaskResponse>> getTaskByCriteria(String difficulty, Long numberOfEmployees) {
        Iterable<Task> retrievedTasks = taskRepository.findAll();
        List<TaskResponse> tasks;

        SearchTaskStrategy strategy = searchTaskStrategyFactory.makeStrategyForCriteria(difficulty,numberOfEmployees);
        if(strategy == null)  return new GenericResponse<>(new Error(0,"Wrong Input", "This difficulty: (" +  difficulty + ") does not exist or this number: (" + numberOfEmployees + ") is invalid!"));

        tasks = mapper.mapAllTasks(strategy.execute(difficulty,numberOfEmployees,retrievedTasks));

        if(tasks.isEmpty())  return new GenericResponse<>(new Error(0,"Not Found", "No Task records exist for given difficulty: " + difficulty + " and given number of employees: " + numberOfEmployees));

        return new GenericResponse<>(tasks);
    }

}
