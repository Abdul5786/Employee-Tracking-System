package com.Abdul.EmployeeManagementSystem.services;

import com.Abdul.EmployeeManagementSystem.payloads.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
     EmployeeDto createEmployee(EmployeeDto employeeDto);
     EmployeeDto getEmployeeById(Integer empId);
     List<EmployeeDto> getAllEmployeeList();

     EmployeeDto updateEmployee(Integer empId,EmployeeDto employeeDto);

     void deleteEmp(Integer empId);

     // 1) get employee by name,department,

}
