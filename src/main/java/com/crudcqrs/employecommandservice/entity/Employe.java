package com.crudcqrs.employecommandservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "EMPLOYE_COMMAND")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employe {
    @Id
    @GeneratedValue
    private long id;
    private String name ;
    private String description;
}
