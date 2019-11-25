package com.example.Unisystems.RoleAuthentication;

import com.example.Unisystems.Employee.EmployeeRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {


    boolean alreadySetup = false;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilege("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilege("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRole(RoleAssignment.ADMIN, adminPrivileges);
        createRole(RoleAssignment.USER, Arrays.asList(readPrivilege));

}
    @Transactional
    private Privilege createPrivilege(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
       if (privilege == null) {
          privilege = new Privilege();
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRole(
            RoleAssignment name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
