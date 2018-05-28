package com.ebickford.erris.models;

import java.util.Objects;

public class ContractRecord {
    
    private int contractID;
    private String contractName;
    private String contractCompany;
    private String contractDepartment;
    private String contractLocation;
    
    
    public ContractRecord(int contractID, String contractName, String contractCompany, String contractDepartment, String contractLocation) {
        
        Objects.requireNonNull(contractName, "Contract Name may not be null");
        Objects.requireNonNull(contractCompany, "Contract Company may not be null");
        Objects.requireNonNull(contractDepartment, "Contract Department may not be null");
        Objects.requireNonNull(contractLocation, "Contract Location may not be null");
        
        
        this.contractID = contractID;
        this.contractName = contractName;
        this.contractCompany = contractCompany;
        this.contractDepartment = contractDepartment;
        this.contractLocation = contractLocation;
    }
    
    public ContractRecord(String contractCompany, String contractDepartment, String contractLocation) {
        Objects.requireNonNull(contractCompany, "Contract Company may not be null");
        Objects.requireNonNull(contractDepartment, "Contract Department may not be null");
        Objects.requireNonNull(contractLocation, "Contract Location may not be null");
        
        
        this.contractCompany = contractCompany;
        this.contractDepartment = contractDepartment;
        this.contractLocation = contractLocation;
    }
    
    public ContractRecord() {
    
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractRecord that = (ContractRecord) o;
        //Not including contract name as this is not included on the employee reports
        return Objects.equals(contractCompany, that.contractCompany) &&
              Objects.equals(contractDepartment, that.contractDepartment) &&
              Objects.equals(contractLocation, that.contractLocation);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(contractName, contractCompany, contractDepartment, contractLocation);
    }
    
    public int getContractID() {
        return contractID;
    }
    
    public void setContractID(int contractID) {
        this.contractID = contractID;
    }
    
    public String getContractName() {
        return contractName;
    }
    
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    
    public String getContractCompany() {
        return contractCompany;
    }
    
    public void setContractCompany(String contractCompany) {
        this.contractCompany = contractCompany;
    }
    
    public String getContractDepartment() {
        return contractDepartment;
    }
    
    public void setContractDepartment(String contractDepartment) {
        this.contractDepartment = contractDepartment;
    }
    
    public String getContractLocation() {
        return contractLocation;
    }
    
    public void setContractLocation(String contractLocation) {
        this.contractLocation = contractLocation;
    }
}
