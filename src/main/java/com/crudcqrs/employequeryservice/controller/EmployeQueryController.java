package com.crudcqrs.employequeryservice.controller;

import com.crudcqrs.employequeryservice.entity.Employe;
import com.crudcqrs.employequeryservice.service.EmployeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employes")
@RestController
public class EmployeQueryController {

    @Autowired
    private EmployeQueryService queryService ;


    @GetMapping
    public List<Employe> fetchAllEmployes(){
        return queryService.getEmployes();

    }


}
