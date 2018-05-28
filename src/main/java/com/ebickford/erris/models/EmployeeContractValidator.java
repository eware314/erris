package com.ebickford.erris.models;

import java.util.List;

public class EmployeeContractValidator {
    
    public List<Employee> validate(List<Employee> employeeList, List<ContractRecord> contractList) {
        
        employeeList.removeIf(employee -> contractList.contains(employee.getContractRecord()));
        
        return employeeList;
        
    }
}
