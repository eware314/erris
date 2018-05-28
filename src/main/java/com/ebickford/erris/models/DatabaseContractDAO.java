package com.ebickford.erris.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseContractDAO implements IContractDAO {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ContractRecord> listContracts() {
        return jdbcTemplate.query("select * from contract ORDER BY NAME ", new ContractRowMapper());
        
    }
    
    @Override
    public void addContract(String name, String company, String department, String location) {
        jdbcTemplate.update(
              "INSERT INTO contract (id, name, company, department, location) " +
                    "VALUES (default, ?, ?, ?, ?)",
              name, company, department, location
        );
    }
    
    @Override
    public void updateContract(String name, int id) {
        this.jdbcTemplate.update("update contract set name = ? where id = ?",
              name, id);
    }
    
    @Override
    public void deleteContract(int id) {
        jdbcTemplate.update(
              "DELETE FROM contract where id = ?", id);
    }
    
    @Override
    public ContractRecord findById(int id) {
        return jdbcTemplate.queryForObject("select * from contract where id=?",
              new Object[]{id},
              new ContractRowMapper());
        
    }
    
    class ContractRowMapper implements RowMapper<ContractRecord> {
        @Override
        public ContractRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
            ContractRecord contract = new ContractRecord(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("company"),
                  rs.getString("department"),
                  rs.getString("location"));
            
            return contract;
        }
    }
}
