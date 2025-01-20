package com.example.autowire.annotation.Componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Manager {

    private Employee employee;


    // constructor injection (recommended)
    @Autowired
    public Manager(Employee employee) {
        this.employee = employee;
    }

    //field injection
    @Autowired
    @Qualifier("manager")
    private Manager manager;

    @Override
    public String toString() {
        return "Manager{" +
                "employee=" + employee +
                '}';
    }
}
