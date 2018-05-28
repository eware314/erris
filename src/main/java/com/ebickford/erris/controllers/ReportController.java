package com.ebickford.erris.controllers;

import com.ebickford.erris.models.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/report")
public class ReportController {
    
    
    IContractDAO contractDAO;
    
    public ReportController(@Autowired IContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }
    
    @RequestMapping("/import")
    public String viewReportImport(Model model) {
        return "/report/import";
    }
    
    @RequestMapping("/output")
    public String viewReportOutput(@ModelAttribute("errorList") List<Employee> employeeList, Model model) {
        
        List<Employee> employees = employeeList;
        model.addAttribute("errors", employees);
        return "/report/output";
    }
    
    @PostMapping("/process") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile mpFile,
                                   RedirectAttributes redirectAttributes) throws IOException, InvalidFormatException {
        
        if (mpFile.isEmpty()) {
            
            return "redirect:import";
        }
        
        File file = File.createTempFile("temp", "xlsx");
        mpFile.transferTo(file);
        FileReportDAO fileReportDAO = new FileReportDAO(file);
        
        List<ContractRecord> contractRecords = contractDAO.listContracts();
        
        List<Employee> employeeReport = fileReportDAO.getEmployeeReport();
        
        EmployeeContractValidator validator = new EmployeeContractValidator();
        List<Employee> errorList = validator.validate(employeeReport, contractRecords);
        
        redirectAttributes.addFlashAttribute("errorList", errorList);
        
        
        return "redirect:output";
    }
}
