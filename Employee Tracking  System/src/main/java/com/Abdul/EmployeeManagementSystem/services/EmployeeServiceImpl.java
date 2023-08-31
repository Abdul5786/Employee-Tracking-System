package com.Abdul.EmployeeManagementSystem.services;

import com.Abdul.EmployeeManagementSystem.config.EmployeeConfig;
import com.Abdul.EmployeeManagementSystem.entities.Employee;
import com.Abdul.EmployeeManagementSystem.excpetion.ResourceNotFoundException;
import com.Abdul.EmployeeManagementSystem.payloads.EmployeeDto;
import com.Abdul.EmployeeManagementSystem.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService
{

    @Autowired
    EmployeeConfig modelmapper;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee = this.EmployeeDtoToEmployee(employeeDto);
        //employee.setPerformance(Performance.Bad);
//        int empPerformanceScore = employee.getEmpPerformanceScore();
//        if (empPerformanceScore>=10)
//        {
//        } else if (empPerformanceScore>=20) {
//
        Employee save = employeeRepo.save(employee);
        return this.EmployeeToEmployeeDto(save);


    }

    @Override
    public EmployeeDto getEmployeeById(Integer empId)
    {
        Employee employee = employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException(+empId, "with resource", "not found"));
        return EmployeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployeeList()
    {
        List<Employee> all = employeeRepo.findAll();
        List<EmployeeDto> employeeDtoList = all.stream().map(a -> this.EmployeeToEmployeeDto(a)).collect(Collectors.toList());
         return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(Integer empId,EmployeeDto  employeeDto)
    {
        Employee emp = employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException(+empId, "not found with resurce ", " not"));
        emp.setEmpName(employeeDto.getEmpName());
        emp.setEmpDepartment(employeeDto.getEmpDepartment());
        emp.setEmpMail(employeeDto.getEmpMail());
      //  emp.setEmpPassword(employeeDto.getEmpPassword());
        Employee save = employeeRepo.save(emp);
        return this.EmployeeToEmployeeDto(save);
    }

    @Override
    public void deleteEmp(Integer empId)
    {
        employeeRepo.deleteById(empId);
    }


    public EmployeeDto EmployeeToEmployeeDto(Employee employee)
    {
        return   this.modelmapper.modelMapper().map(employee,EmployeeDto.class);
    }

   public Employee EmployeeDtoToEmployee(EmployeeDto employeeDto)
   {
      return this.modelmapper.modelMapper().map(employeeDto,Employee.class);
   }

}
