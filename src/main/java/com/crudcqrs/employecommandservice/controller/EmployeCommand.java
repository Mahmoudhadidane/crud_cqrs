package com.crudcqrs.employecommandservice.controller;

import com.crudcqrs.employecommandservice.dto.EmployeEvent;
import com.crudcqrs.employecommandservice.entity.Employe;
import com.crudcqrs.employecommandservice.service.EmployeCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employes")
public class EmployeCommand {
    @Autowired
    private EmployeCommandService commandService ;
    @PostMapping
    public Employe createEmploye(@RequestBody EmployeEvent employeEvent){
        return commandService.createEmploye(employeEvent);
    }
    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable long id ,@RequestBody EmployeEvent employeEvent) {
        return commandService.updateEmploye(id , employeEvent);
    }

    }
