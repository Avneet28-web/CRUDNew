package com.example.hrmanagementavneet;

public class Employee {
    private int empid;
    private String empname;
    private String emppassw;
    private double salary;

    public Employee(int empid, String empname, String emppassw, double salary) {
        this.empid = empid;
        this.empname = empname;
        this.emppassw = emppassw;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmppassw() {
        return emppassw;
    }

    public void setEmppassw(String emppassw) {
        this.emppassw = emppassw;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
