/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2;
import java.time.LocalDate;
/**
 *
 * @author Leo_1
 */
public class Task {
    private String name;
    private LocalDate executionDate;

    public Task(String name, LocalDate executionDate) {
        this.name = name;
        this.executionDate = executionDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', executionDate=" + executionDate + '}';
    }
}
