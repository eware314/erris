package com.ebickford.erris.models;

import com.ebickford.erris.ErrisApplicationTestConfigs;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@Import(ErrisApplicationTestConfigs.class)
public class EmployeeContractValidatorTest {
    
    @Autowired
    IContractDAO contractDAO;
    
    @Autowired
    IReportDAO reportDAO;
    
    @Autowired
    EmployeeContractValidator employeeContractValidator;
    
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testValidEmployeeList() throws IOException, InvalidFormatException {
        //The first five records in the employee list are valid
        List<Employee> errorList = employeeContractValidator.validate(
              reportDAO.getEmployeeReport().subList(0,5),
              contractDAO.listContracts());
    
        Assert.assertTrue(errorList.isEmpty());
    
    }
    
    @Test
    public void testInvalidCompanyCode() throws IOException, InvalidFormatException {
        //The last four records in the employee list are invalid
        List<Employee> employeeReport = reportDAO.getEmployeeReport().subList(8,9);
        
        List<Employee> errorList = employeeContractValidator.validate(employeeReport, contractDAO.listContracts());
        
        Assert.assertEquals(1, errorList.size());
    }
    
    @Test
    public void testInvalidDepartmentCode() throws IOException, InvalidFormatException {
        List<Employee> employeeReport = reportDAO.getEmployeeReport().subList(6,7);
    
        List<Employee> errorList = employeeContractValidator.validate(employeeReport, contractDAO.listContracts());
    
        Assert.assertEquals(1, errorList.size());
    
    }
    
    @Test
    public void testInvalidLocationCode() throws IOException, InvalidFormatException {
        List<Employee> employeeReport = reportDAO.getEmployeeReport().subList(5,6);
    
        List<Employee> errorList = employeeContractValidator.validate(employeeReport, contractDAO.listContracts());
    
        Assert.assertEquals(1, errorList.size());
    
    }
    
    @Test
    public void testInvalidEmployee() throws IOException, InvalidFormatException {
        List<Employee> employeeReport = reportDAO.getEmployeeReport().subList(7,8);
    
        List<Employee> errorList = employeeContractValidator.validate(employeeReport, contractDAO.listContracts());
    
        Assert.assertEquals(1, errorList.size());
    
    }
    
}