package com.Abdul.EmployeeManagementSystem.excpetion;

public class ResourceNotFoundException extends  RuntimeException
{
   String resourceName;
   int fieldValue;
   String fieldName;

    public ResourceNotFoundException(int fieldValue,String resourceName,String fieldName)
    {
        super(String.format("%s with resource not found %s: %s",fieldValue,resourceName,fieldName));
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
