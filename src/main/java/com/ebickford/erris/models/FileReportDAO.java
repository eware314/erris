package com.ebickford.erris.models;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReportDAO implements IReportDAO {
    
    File file;
    
    public FileReportDAO(File file) {
        this.file = file;
    }
    
    @Override
    public List<Employee> getEmployeeReport() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(file);
        
        
        // Getting the only sheet in the workbook
        Sheet sheet = workbook.getSheetAt(0);
        
        // Create a DataFormatter to format and get each cell's value as String
        List<Employee> employeeList = new ArrayList<>();
        
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        
        sheet.removeRow(sheet.getRow(0));
        sheet.forEach(row -> {
            //skip the first row of the spreadsheet as it contains headers
            
            //create an employee Object to hold the values of each row from the spreadsheet
            int id;
            String lastName;
            String firstName;
            String supervisorName;
            String companyCode;
            String department;
            String location;
            
            id = Integer.parseInt(row.getCell(0).getStringCellValue());
            lastName = row.getCell(1).getStringCellValue();
            firstName = row.getCell(2).getStringCellValue();
            supervisorName = row.getCell(17).getStringCellValue();
            companyCode = row.getCell(11).getStringCellValue();
            department = row.getCell(13).getStringCellValue();
            location = row.getCell(15).getStringCellValue();
            
            Employee employee = new Employee(id, lastName, firstName, supervisorName,
                  new ContractRecord(companyCode, department, location));
            
            employeeList.add(employee);
            
        });
        
        // Closing the workbook
        workbook.close();
        
        return employeeList;
    }
}
