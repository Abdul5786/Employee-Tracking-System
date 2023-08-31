package com.Abdul.EmployeeManagementSystem.services;

import com.Abdul.EmployeeManagementSystem.payloads.EmployeePerformanceDto;

import java.util.List;

public interface EmployeePerformanceService
{
    EmployeePerformanceDto Addperformacne(EmployeePerformanceDto employeePerformanceDto);
    EmployeePerformanceDto getPerformanceResult(Integer empId);

    List<EmployeePerformanceDto> getAllEmployeePerformance();
    EmployeePerformanceDto updateEmployePerformance(EmployeePerformanceDto employeePerformanceDto,Integer empfId);
    void deleteEmployePerformance(Integer empfId);

}
