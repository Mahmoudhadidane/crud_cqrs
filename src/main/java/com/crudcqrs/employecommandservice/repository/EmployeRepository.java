package com.crudcqrs.employecommandservice.repository;

import com.crudcqrs.employecommandservice.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
