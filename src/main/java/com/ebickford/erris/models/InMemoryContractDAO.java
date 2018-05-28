package com.ebickford.erris.models;

import java.util.ArrayList;
import java.util.List;

public class InMemoryContractDAO implements IContractDAO {
    
    List<ContractRecord> contractList = new ArrayList<>();
    
    public InMemoryContractDAO() {
        int i = 1;
        
        contractList.add(new ContractRecord(i++, "Admin", "ENV08", "GHB", "LE"));
        contractList.add(new ContractRecord(i++, "Molina BPO", "ENV08", "GHC", "LH"));
        contractList.add(new ContractRecord(i++, "ME PBA", "ENV08", "GHK", "LE"));
        contractList.add(new ContractRecord(i++, "ME FCLOC", "ENV08", "GHH", "LE"));
        contractList.add(new ContractRecord(i++, "IT Operations", "ENV08", "GHF", "LE"));
        contractList.add(new ContractRecord(i++, "IT Development", "ENV08", "GHE", "LE"));
        contractList.add(new ContractRecord(i++, "IA PBA", "ENV08", "GHK", "LD"));
        contractList.add(new ContractRecord(i++, "IA Clinical", "ENV08", "GHD", "LD"));
        contractList.add(new ContractRecord(i++, "WY PBA", "ENV08", "GHK", "LQ"));
        contractList.add(new ContractRecord(i++, "GA Rebate", "ENV08", "GHP", "LB"));
        contractList.add(new ContractRecord(i++, "Molina Med PA", "ENV08", "GHI", "LH"));
        contractList.add(new ContractRecord(i++, "UT PBA", "ENV08", "GHK", "LN"));
        contractList.add(new ContractRecord(i++, "PA Rebate", "ENV08", "GHP", "LV"));
        contractList.add(new ContractRecord(i++, "WV Clinical", "ENV08", "GHD", "LT"));
        contractList.add(new ContractRecord(i++, "MS Clinical", "ENV08", "GHD", "LG"));
        contractList.add(new ContractRecord(i++, "ME OMS", "ENV08", "GHJ", "LE"));
        contractList.add(new ContractRecord(i++, "VT SSDC", "ENV08", "GHR", "LP"));
        contractList.add(new ContractRecord(i++, "VT PBA", "ENV08", "GHK", "LP"));
        contractList.add(new ContractRecord(i++, "IL PBA", "ENV08", "GHK", "LC"));
        contractList.add(new ContractRecord(i++, "OH PBA", "ENV08", "GHK", "LU"));
        contractList.add(new ContractRecord(i++, "Pharmacy Sales", "ENV08", "GHM", "LE"));
    }
    
    @Override
    public List<ContractRecord> listContracts() {
        
        return contractList;
    }
    
    @Override
    public void addContract(String name, String company, String department, String location) {
    
    }
    
    @Override
    public void updateContract(String name, int id) {
    }
    
    @Override
    public void deleteContract(int id) {
    
    }
    
    @Override
    public ContractRecord findById(int id) {
        ContractRecord foundRecord = null;
        
        for (ContractRecord contractRecord : contractList) {
            if (contractRecord.getContractID() == id) {
                foundRecord = contractRecord;
            }
        }
        
        return foundRecord;
    }
    
    public void deleteContract(ContractRecord contractRecord) {
        contractList.removeIf(contract -> contractList.contains(contractRecord));
        
    }
}
