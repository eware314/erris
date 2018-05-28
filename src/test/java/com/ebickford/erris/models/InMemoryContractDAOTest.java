package com.ebickford.erris.models;

import com.ebickford.erris.ErrisApplicationDAOTestConfigs;
import com.ebickford.erris.ErrisApplicationTestConfigs;
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
@Import(ErrisApplicationTestConfigs.class)
public class InMemoryContractDAOTest {
    
    @Autowired
    IContractDAO contractDAO;
    
    
    @Test
    public void testListContracts() {
        List<ContractRecord> contractRecords = contractDAO.listContracts();
        
        Assert.assertEquals(21, contractRecords.size());
    }
    
    @Test
    public void testFindById() {
        ContractRecord contractRecord = contractDAO.findById(3);
        
        Assert.assertTrue(contractRecord.getContractName().equals("ME PBA"));
        Assert.assertTrue(contractRecord.getContractCompany().equals("ENV08"));
        Assert.assertTrue(contractRecord.getContractDepartment().equals("GHK"));
        Assert.assertTrue(contractRecord.getContractLocation().equals("LE"));
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
