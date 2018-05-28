package com.ebickford.erris.controllers;

import com.ebickford.erris.models.ContractRecord;
import com.ebickford.erris.models.IContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/contract")
public class ContractRecordController {
    
    IContractDAO contractDAO;
    
    public ContractRecordController(@Autowired IContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }
    
    @RequestMapping("/add")
    public String viewAddContract(Model model) {
        model.addAttribute("contract", new ContractRecord());
        return "contract/add";
    }
    
    @PostMapping("/create")
    public String create(@RequestParam("contractName") String contractName,
                         @RequestParam("contractCompany") String contractCompany,
                         @RequestParam("contractDepartment") String contractDepartment,
                         @RequestParam("contractLocation") String contractLocation) {
        //note: only name can be changed. If there are issues with other fields, item should be deleted and recreated
        contractDAO.addContract(contractName, contractCompany, contractDepartment, contractLocation);
        
        return "redirect:/home";
    }
    @RequestMapping("/edit/{contractID}")
    public String viewContractEdit(Model model, @PathVariable(value = "contractID") int contractID) {
        
        ContractRecord contractRecord = contractDAO.findById(contractID);
        model.addAttribute("contract", contractRecord);
        
        return "contract/edit";
    }
    
    @PostMapping("/delete/{contractID}")
    public String deleteContract(Model model, @PathVariable(value = "contractID") int contractID) {
        ContractRecord contractRecord = contractDAO.findById(contractID);
        model.addAttribute("contract", contractRecord);
        
        contractDAO.deleteContract(contractID);
        
        return "redirect:/home";
    }
    
    private ContractRecord findContractByID(int id) {
        
        return contractDAO.findById(id);
    }
    
    @PostMapping("/update")
    public String update(@RequestParam("contractId") String contractId, @RequestParam("contractName") String contractName) {
        int id = Integer.parseInt(contractId);
        //note: only name can be changed. If there are issues with other fields, item should be deleted and recreated
        contractDAO.updateContract(contractName, id);
        
        return "redirect:/home";
    }
    
    public List<ContractRecord> listContracts() {
        List<ContractRecord> contractRecords = contractDAO.listContracts();
        
        return contractRecords;
    }
    
    
    private boolean isAllowed() {
        //TODO use this method to implement user access controls
        return false;
    }
    
}
