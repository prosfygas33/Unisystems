package com.example.Unisystems.Company;

import com.example.Unisystems.Company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Company entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Company> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
