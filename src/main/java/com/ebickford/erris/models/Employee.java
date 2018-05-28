package com.ebickford.erris.models;

public class Employee {
    
    int employeeID;
    String employeeLastName;
    String employeeFirstName;
    String employeeSupervisorName;
    ContractRecord contractRecord;
    
    public Employee(int employeeID, String employeeLastName, String employeeFirstName, String employeeSupervisorName, ContractRecord contractRecord) {
        this.employeeID = employeeID;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeSupervisorName = employeeSupervisorName;
        this.contractRecord = contractRecord;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }
    
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    public String getEmployeeLastName() {
        return employeeLastName;
    }
    
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }
    
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    
    public String getEmployeeSupervisorName() {
        return employeeSupervisorName;
    }
    
    public void setEmployeeSupervisorName(String employeeSupervisorName) {
        this.employeeSupervisorName = employeeSupervisorName;
    }
    
    public ContractRecord getContractRecord() {
        return contractRecord;
    }
    
    public void setContractRecord(ContractRecord contractRecord) {
        this.contractRecord = contractRecord;
    }
}
