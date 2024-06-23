package com.crudcqrs.employequeryservice.repository;

import com.crudcqrs.employequeryservice.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
