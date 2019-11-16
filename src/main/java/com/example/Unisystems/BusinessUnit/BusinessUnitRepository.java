package com.example.Unisystems.BusinessUnit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRepository extends CrudRepository<BusinessUnit,Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(BusinessUnit entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends BusinessUnit> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
