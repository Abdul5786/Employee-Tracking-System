package com.Abdul.EmployeeManagementSystem.repositories;

import com.Abdul.EmployeeManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{

}
