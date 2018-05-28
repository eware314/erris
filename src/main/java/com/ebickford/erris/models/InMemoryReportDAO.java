package com.ebickford.erris.models;

import java.util.ArrayList;
import java.util.List;

public class InMemoryReportDAO implements IReportDAO {
    
    List<Employee> employeeList = new ArrayList<>();
    
    @Override
    public List<Employee> getEmployeeReport() {
        //For use in testing, this list contains only VALID contract data
        //Invalid records will be added during testing
        
        employeeList.add(new Employee(
                    10000,
                    "SIMPSON",
                    "CARA",
                    "Howell, Sara",
                    new ContractRecord("ENV08", "GHK", "LQ")
              )
        );
        employeeList.add(new Employee(
                    10001,
                    "BUCKLEY-SMITH",
                    "STEPHANIE",
                    "Cook, Ivy",
                    new ContractRecord("ENV08", "GHJ", "LE")
              )
        );
        employeeList.add(new Employee(
                    1010020,
                    "SIMPSON",
                    "AURELIE",
                    "Howell, Sara",
                    new ContractRecord("ENV08", "GHC", "LH")
              )
        );
        employeeList.add(new Employee(
                    10003,
                    "O'REILLY",
                    "JOANNE",
                    "Eureka, Chad",
                    new ContractRecord("ENV08", "GHH", "LE")
              )
        );
        
        employeeList.add(new Employee(
                    10016,
                    "VAN HALEN",
                    "CHRISTINA",
                    "Howell, Sara",
                    new ContractRecord("ENV08", "GHH", "LE")
              )
        );
        
        employeeList.add(new Employee(
                    //incorrect location
                    10009,
                    "DYER",
                    "ALAIN",
                    "Russo, James",
                    new ContractRecord("ENV08", "GHK", "LM")
              )
        );
        
        employeeList.add(new Employee(
                    //incorrect department
                    10013,
                    "SIMPSON",
                    "JEFFREY",
                    "Harkins, Dan",
                    new ContractRecord("ENV08", "GHZ", "LE")
              )
        );
        
        employeeList.add(new Employee(
                    //incorrect company
                    10017,
                    "SMITH",
                    "LAURA",
                    "Lefleur, Bruce",
                    new ContractRecord("ENV25", "GHK", "LE")
              )
        );
        
        employeeList.add(new Employee(
                    //incorrect company, dept and loc
                    10018,
                    "DUBE",
                    "MELISSA",
                    "Marin, Sharyl",
                    new ContractRecord("ENV25", "GHZ", "LM")
              )
        );
        
        return employeeList;
    }
    
}
