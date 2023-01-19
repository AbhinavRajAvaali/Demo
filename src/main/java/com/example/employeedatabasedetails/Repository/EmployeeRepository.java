package com.example.employeedatabasedetails.Repository;

import com.example.employeedatabasedetails.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

    @Query("select a from EmployeeEntity a where employeeId=?1")
    EmployeeEntity findByEmployeeId(Integer employeeId);
}