package com.Abdul.EmployeeManagementSystem.payloads;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class EmployeeDto
{
    private int id;
    private String empName;
    private String empMail;
    private String empDepartment;
//    private String empPassword;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    private String salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

//    public String getEmpPassword() {
//        return empPassword;
//    }
//
//    public void setEmpPassword(String empPassword) {
//        this.empPassword = empPassword;
//    }
}
