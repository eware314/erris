package com.ebickford.erris.models;

import java.util.List;

public interface IContractDAO {
    
    List<ContractRecord> listContracts();
    
    void addContract(String name, String company, String department, String location);
    
    void updateContract(String name, int id);
    
    void deleteContract(int id);
    
    ContractRecord findById(int id);
}
