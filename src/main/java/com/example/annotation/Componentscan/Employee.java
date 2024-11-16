package com.example.annotation.Componentscan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private  int empoloyee;
    @Value("Latha")
    private  String firstName;
    @Value("${java.home}")
     private String lastName;
    @Value("#{4*4}")
    private  Double salary;

    public int getEmpoloyee() {
        return empoloyee;
    }

    public void setEmpoloyee(int empoloyee) {
        this.empoloyee = empoloyee;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empoloyee=" + empoloyee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
