package com.ebickford.erris.controllers;


import com.ebickford.erris.models.ContractRecord;
import com.ebickford.erris.models.IContractDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {
    
    IContractDAO contractDAO;
    
    public HomeController(IContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }
    
    @RequestMapping("/home")
    public String viewHome(Model model) {
        List<ContractRecord> contractRecords = listContracts();
        model.addAttribute("contracts", contractRecords);
        return "home";
    }
    
    public List<ContractRecord> listContracts() {
        List<ContractRecord> contractRecords = contractDAO.listContracts();
        
        return contractRecords;
    }
}
