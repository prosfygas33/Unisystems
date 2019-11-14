package com.example.Unisystems.repositories;

import com.example.Unisystems.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Department entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Department> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
