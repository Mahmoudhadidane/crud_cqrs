package com.crudcqrs.employequeryservice.service;

import com.crudcqrs.employequeryservice.dto.EmployeEvent;
import com.crudcqrs.employequeryservice.entity.Employe;
import com.crudcqrs.employequeryservice.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeQueryService {
    @Autowired
    private EmployeRepository repository ;

    public List<Employe> getEmployes(){
        return repository.findAll();
    }

    @KafkaListener(topics="employe-event-topic",groupId="employe-event-group")
    public void processEmployeEvents(EmployeEvent employeEvent){
        Employe employe = employeEvent.getEmploye();
        if(employeEvent.getEventType().equals("CreateEmploye")){
            repository.save(employe);
        }
        if (employeEvent.getEventType().equals("UpdateEmploye")) {
            Employe existingEmploye = repository.findById(employe.getId()).get();
            existingEmploye.setName(employe.getName());
            existingEmploye.setDescription(employe.getDescription());
            repository.save(existingEmploye);
        }
    }
}
