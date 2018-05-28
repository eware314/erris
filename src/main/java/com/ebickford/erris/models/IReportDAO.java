package com.ebickford.erris.models;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;

public interface IReportDAO {
    
    public List<Employee> getEmployeeReport() throws IOException, InvalidFormatException;
}
