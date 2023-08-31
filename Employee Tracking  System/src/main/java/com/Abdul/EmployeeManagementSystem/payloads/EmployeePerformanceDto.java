package com.Abdul.EmployeeManagementSystem.payloads;

import com.Abdul.EmployeeManagementSystem.Enum.Performance;
import com.Abdul.EmployeeManagementSystem.Enum.PerformanceGrade;
import com.Abdul.EmployeeManagementSystem.Enum.Promoted;

public class EmployeePerformanceDto
{
    private int performanceId;
    private PerformanceGrade performanceGrade;
//    private Date date;
    private Performance performance;
    private Promoted promoted;
    private  int performanceScore;

    private String emName;

    public String getEmpName() {
        return emName;
    }

    public void setEmpName(String empName) {
        this.emName = empName;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public PerformanceGrade getPerformanceGrade() {
        return performanceGrade;
    }

    public void setPerformanceGrade(PerformanceGrade performanceGrade) {
        this.performanceGrade = performanceGrade;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Promoted getPromoted() {
        return promoted;
    }

    public void setPromoted(Promoted promoted) {
        this.promoted = promoted;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }
}
