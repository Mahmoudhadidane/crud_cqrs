package com.crudcqrs.employecommandservice.dto;

import com.crudcqrs.employecommandservice.entity.Employe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeEvent {

    private String eventType;
    public Employe employe ;
}
