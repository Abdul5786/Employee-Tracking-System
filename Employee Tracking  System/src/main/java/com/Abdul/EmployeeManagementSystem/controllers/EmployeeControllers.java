package com.Abdul.EmployeeManagementSystem.controllers;

import com.Abdul.EmployeeManagementSystem.payloads.EmployeeDto;
import com.Abdul.EmployeeManagementSystem.payloads.EmployeePerformanceDto;
import com.Abdul.EmployeeManagementSystem.services.EmployeePerformanceService;
import com.Abdul.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/employee")
public class EmployeeControllers
{

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeePerformanceService employeePerformanceService;

    @PostMapping(value="/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer empId)
    {
        EmployeeDto employeeById = employeeService.getEmployeeById(empId);
        return  ResponseEntity.ok(employeeById);
    }

    @GetMapping(value ="/getAll" )
   public ResponseEntity<List<EmployeeDto>> getAllEmployee()
   {
       List<EmployeeDto> allEmployeeList = employeeService.getAllEmployeeList();
       return  ResponseEntity.ok(allEmployeeList);
   }

   @PostMapping(value = "/addPerformance")
   public ResponseEntity<EmployeePerformanceDto> AddEmployeePerformance(@RequestBody EmployeePerformanceDto employeePerformanceDto)
   {
       EmployeePerformanceDto addperformacne = employeePerformanceService.Addperformacne(employeePerformanceDto);
       return ResponseEntity.ok(addperformacne);
   }
   @GetMapping("/getPerformanceById/{empId}")
   public ResponseEntity<EmployeePerformanceDto> getEmployeePerformanceResult(@PathVariable Integer empId)
   {
       EmployeePerformanceDto performanceResult = employeePerformanceService.getPerformanceResult(empId);
       return ResponseEntity.ok(performanceResult);
   }

   @PostMapping(value = "/update/{empId}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer empId,@RequestBody EmployeeDto employeeDto)
   {
       EmployeeDto updateEmployee = employeeService.updateEmployee(empId,employeeDto);
       return ResponseEntity.ok(employeeDto);
   }

   @DeleteMapping(value = "/delete/{empId}")
   public void deleteEmp(@PathVariable Integer empId)
   {
      employeeService.deleteEmp(empId);
   }

   @GetMapping(value = "/getEmpPerformanceList")
    public ResponseEntity<List<EmployeePerformanceDto>> getAllEmpPerformanceList()
    {
        List<EmployeePerformanceDto> allEmployeePerformance = employeePerformanceService.getAllEmployeePerformance();
        return ResponseEntity.ok(allEmployeePerformance);
    }

    @PostMapping(value = "/updateEmpFormane/{empfId}")
    public ResponseEntity<EmployeePerformanceDto> updateEmpPerforance(@PathVariable Integer empfId,@RequestBody EmployeePerformanceDto employeePerformanceDto)
    {
        EmployeePerformanceDto updateEmpf = employeePerformanceService.updateEmployePerformance(employeePerformanceDto, empfId);
        return  ResponseEntity.ok(updateEmpf);
    }


}
