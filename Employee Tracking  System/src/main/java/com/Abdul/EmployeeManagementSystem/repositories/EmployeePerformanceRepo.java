package com.Abdul.EmployeeManagementSystem.repositories;

import com.Abdul.EmployeeManagementSystem.entities.EmployeePerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePerformanceRepo extends JpaRepository<EmployeePerformance,Integer>
{
}
