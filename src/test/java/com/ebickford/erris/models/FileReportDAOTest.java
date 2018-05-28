package com.ebickford.erris.models;

import com.ebickford.erris.ErrisApplicationDAOTestConfigs;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@Import(ErrisApplicationDAOTestConfigs.class)
public class FileReportDAOTest {
    
    @Autowired
    @Qualifier("File")
    IReportDAO fileReportDAO;
    
    @Autowired
    @Qualifier("InMemory")
    IReportDAO inMemoryReportDAO;
    
    //TestFileReader
    //compare file to in memory list
    @Test
    public void testCompareFileToInMemoryList() throws IOException, InvalidFormatException {
        List<Employee> inMemoryEmployeeList = inMemoryReportDAO.getEmployeeReport();
        
        List<Employee> fileEmployeeList = fileReportDAO.getEmployeeReport();
        
        Assert.assertEquals(inMemoryEmployeeList.size(), fileEmployeeList.size());
        
        int size = inMemoryEmployeeList.size();
        
        for (int i = 0; i < size; i++) {
            try {
                Assert.assertTrue(areEqual(inMemoryEmployeeList.get(i), fileEmployeeList.get(i)));
            } catch (Exception e) {
                System.out.println("element" + i + "failed");
            }
        }
        
    }
    
    @Test
    public void testAreEqual() throws IOException, InvalidFormatException {
        //verify that the 'areEqual' method is comparing the correct fields
        List<Employee> inMemoryEmployeeList = inMemoryReportDAO.getEmployeeReport();
        
        Assert.assertTrue(areEqual(inMemoryEmployeeList.get(0), inMemoryEmployeeList.get(0)));
        
    }
    
    @Test
    public void testFileReader() throws IOException, InvalidFormatException {
        List<Employee> fileEmployeeList = fileReportDAO.getEmployeeReport();
        
        System.out.println("testing");
        
        Employee employee = new Employee(
              1010020,
              "SIMPSON",
              "AURELIE",
              "Howell, Sara",
              new ContractRecord(
                    "ENV08",
                    "GHC",
                    "LH"
              ));
        
        Assert.assertTrue(areEqual(employee, fileEmployeeList.get(2)));
        
    }
    
    public boolean areEqual(Employee fileEmployee, Employee inMemoryEmployee) {
        
        return compare(fileEmployee.getEmployeeFirstName(), inMemoryEmployee.getEmployeeFirstName()) &&
              compare(fileEmployee.getEmployeeLastName(), inMemoryEmployee.getEmployeeLastName()) &&
              compare(fileEmployee.getEmployeeID(), inMemoryEmployee.getEmployeeID()) &&
              compare(fileEmployee.getEmployeeSupervisorName(), inMemoryEmployee.getEmployeeSupervisorName()) &&
              compare(fileEmployee.getContractRecord(), inMemoryEmployee.getContractRecord());
    }
    
    public boolean compare(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
    
}
