package com.vladwave.projectfortopacademy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private static ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private String name;
    private String surname;
    private String patronymic;
    private String rang;
    private String departmentname;
    private String bossname;
    private String bosssurname;
    private String bosspatronymic;
    private String salary;
    private String dataofemployment;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Employee(String name, String surname, String patronymic, String rang, String departmentname, String bossname, String bosssurname, String bosspatronymic, String salary, String dataofemployment) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rang = rang;
        this.departmentname = departmentname;
        this.bossname = bossname;
        this.bosssurname = bosssurname;
        this.bosspatronymic = bosspatronymic;
        this.salary = salary;
        this.dataofemployment = dataofemployment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDataofemployment() {
        return dataofemployment;
    }

    public void setDataofemployment(String dataofemployment) {
        this.dataofemployment = dataofemployment;
    }

    public void editEmployee(String name, String surname, String patronymic, String rang, String departmentname, String bossname, String bosssurname, String bosspatronymic, String salary, String dataofemployment) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rang = rang;
        this.departmentname = departmentname;
        this.bossname = bossname;
        this.bosssurname = bosssurname;
        this.bosspatronymic = bosspatronymic;
        this.salary = salary;
        this.dataofemployment = dataofemployment;
    }

    public static ObservableList<Employee> getEmployeeList() {
        return employeeList;
    }
    public static void addEmployeeinList(Employee e){
        employeeList.add(e);
    }
    public static void removeEmployeeinList(Employee e){
        employeeList.remove(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getBossname() {
        return bossname;
    }

    public void setBossname(String bossname) {
        this.bossname = bossname;
    }

    public String getBosssurname() {
        return bosssurname;
    }

    public void setBosssurname(String bosssurname) {
        this.bosssurname = bosssurname;
    }

    public String getBosspatronymic() {
        return bosspatronymic;
    }

    public void setBosspatronymic(String bosspatronymic) {
        this.bosspatronymic = bosspatronymic;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic + " " + rang  + " " + departmentname + " " + bossname + " " + bosssurname + " " + bosspatronymic + " " + salary + " " + dataofemployment;
    }
}
