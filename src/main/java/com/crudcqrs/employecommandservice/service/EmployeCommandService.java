package com.crudcqrs.employecommandservice.service;

import com.crudcqrs.employecommandservice.dto.EmployeEvent;
import com.crudcqrs.employecommandservice.entity.Employe;
import com.crudcqrs.employecommandservice.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeCommandService {

    @Autowired
    private EmployeRepository repository ;
    @Autowired
    private KafkaTemplate<String,Object> KafkaTemplate ;

    public Employe createEmploye(EmployeEvent employeEvent){
        Employe employeDO = repository.save(employeEvent.getEmploye());
        EmployeEvent event=new EmployeEvent("CreateEmploye", employeDO);
        KafkaTemplate.send("employe-event-topic",event);
        return employeDO;
    }

    public Employe updateEmploye(long id,EmployeEvent employeEvent){
        Employe existingEmploye = repository.findById(id).get();
        Employe newEmploye=employeEvent.getEmploye();
        existingEmploye.setName(newEmploye.getName());
        existingEmploye.setDescription(newEmploye.getDescription());
        Employe employeDO = repository.save(existingEmploye);
        EmployeEvent event=new EmployeEvent("UpdateEmploye", employeDO);
        KafkaTemplate.send("employe-event-topic",event);
        return employeDO;
    }
}
