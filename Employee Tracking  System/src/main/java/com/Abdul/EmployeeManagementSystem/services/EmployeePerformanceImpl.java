package com.Abdul.EmployeeManagementSystem.services;
import com.Abdul.EmployeeManagementSystem.Enum.Performance;
import com.Abdul.EmployeeManagementSystem.Enum.PerformanceGrade;
import com.Abdul.EmployeeManagementSystem.Enum.Promoted;
import com.Abdul.EmployeeManagementSystem.config.EmployeeConfig;
import com.Abdul.EmployeeManagementSystem.entities.EmployeePerformance;
import com.Abdul.EmployeeManagementSystem.excpetion.ResourceNotFoundException;
import com.Abdul.EmployeeManagementSystem.payloads.EmployeePerformanceDto;
import com.Abdul.EmployeeManagementSystem.repositories.EmployeePerformanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePerformanceImpl implements EmployeePerformanceService
{

    @Autowired
    EmployeePerformanceRepo employeePerformanceRepo;
    @Autowired
    EmployeeConfig modelmapper;
    @Override
    public EmployeePerformanceDto Addperformacne(EmployeePerformanceDto employeePerformanceDto)
    {
        int performanceScore = employeePerformanceDto.getPerformanceScore();
        if(performanceScore<=50)
        {

            EmployeePerformance employeePerformance = this.empDtoToemp(employeePerformanceDto);
            employeePerformance.setPerformance(Performance.Bad);
            employeePerformance.setPerformanceGrade(PerformanceGrade.C);
            employeePerformance.setPromoted(Promoted.notPromoted);
            EmployeePerformance employeePerformance1 = employeePerformanceRepo.save(employeePerformance);
            return this.empToEmpDto(employeePerformance1);


        }
        else if(performanceScore>50&&performanceScore<=75)
        {
            EmployeePerformance empPerformance = this.empDtoToemp(employeePerformanceDto);
            empPerformance.setPerformance(Performance.Average);
            empPerformance.setPerformanceGrade(PerformanceGrade.B);
            empPerformance.setPromoted(Promoted.partiallyPromoted);
            EmployeePerformance emp = employeePerformanceRepo.save(empPerformance);
            return this.empToEmpDto(emp);
        }
        else if(performanceScore>75&&performanceScore<=100)
        {
            EmployeePerformance employeePerformance = this.empDtoToemp(employeePerformanceDto);
            employeePerformance.setPerformance(Performance.Good);
            employeePerformance.setPerformanceGrade(PerformanceGrade.A);
            employeePerformance.setPromoted(Promoted.promoted);
            employeePerformanceRepo.save(employeePerformance);
            return this.empToEmpDto(employeePerformance);
        }

        return null;
    }

    @Override
    public EmployeePerformanceDto getPerformanceResult(Integer empId)
    {
        EmployeePerformance employeePerformance = employeePerformanceRepo.findById(empId).orElseThrow(); // use exception properly
         return empToEmpDto(employeePerformance);
    }

    @Override
    public List<EmployeePerformanceDto> getAllEmployeePerformance()
    {
        List<EmployeePerformance> all = employeePerformanceRepo.findAll();
          List<EmployeePerformanceDto> employeePerformanceDtoList = all.stream().map(a -> this.empToEmpDto(a)).collect(Collectors.toList());
          return  employeePerformanceDtoList;
    }

    @Override
    public EmployeePerformanceDto updateEmployePerformance(EmployeePerformanceDto employeePerformanceDto, Integer empfId)
    {
        EmployeePerformance employeePerformance = employeePerformanceRepo.findById(empfId).orElseThrow(() -> new ResourceNotFoundException(+empfId, "resource", "id"));
        employeePerformance.setEmpName(employeePerformanceDto.getEmpName());
        int performanceScore = employeePerformanceDto.getPerformanceScore();
        if(performanceScore<=50)
        {

//            EmployeePerformance employeePerformance = this.empDtoToemp(employeePerformanceDto);
            employeePerformance.setPerformanceScore(employeePerformanceDto.getPerformanceScore());
            employeePerformance.setPerformance(Performance.Bad);
            employeePerformance.setPerformanceGrade(PerformanceGrade.C);
            employeePerformance.setPromoted(Promoted.notPromoted);
            EmployeePerformance employeePerformance1 = employeePerformanceRepo.save(employeePerformance);
            return this.empToEmpDto(employeePerformance1);


        }
        else if(performanceScore>50&&performanceScore<=75)
        {
//            EmployeePerformance empPerformance = this.empDtoToemp(employeePerformanceDto);
            employeePerformance.setPerformanceScore(employeePerformanceDto.getPerformanceScore());
            employeePerformance.setPerformance(Performance.Average);
            employeePerformance.setPerformanceGrade(PerformanceGrade.B);
            employeePerformance.setPromoted(Promoted.partiallyPromoted);
            EmployeePerformance emp = employeePerformanceRepo.save( employeePerformance);
            return this.empToEmpDto(emp);
        }
        else if(performanceScore>75&&performanceScore<=100)
        {
//            EmployeePerformance employeePerformance = this.empDtoToemp(employeePerformanceDto);
            employeePerformance.setPerformanceScore(employeePerformanceDto.getPerformanceScore());
            employeePerformance.setPerformance(Performance.Good);
            employeePerformance.setPerformanceGrade(PerformanceGrade.A);
            employeePerformance.setPromoted(Promoted.promoted);
            employeePerformanceRepo.save(employeePerformance);
            return this.empToEmpDto(employeePerformance);
        }

        return null;

    }

    @Override
    public void deleteEmployePerformance(Integer empfId)
    {employeePerformanceRepo.deleteById(empfId);
    }


    public EmployeePerformance empDtoToemp(EmployeePerformanceDto employeePerformanceDto)
      {
         return this.modelmapper.modelMapper().map(employeePerformanceDto,EmployeePerformance.class);
      }

      public EmployeePerformanceDto empToEmpDto(EmployeePerformance employeePerformance)
      {
         return this.modelmapper.modelMapper().map(employeePerformance,EmployeePerformanceDto.class);
      }

}
