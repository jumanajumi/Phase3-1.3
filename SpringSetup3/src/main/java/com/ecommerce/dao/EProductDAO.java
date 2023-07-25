package com.ecommerce.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository; // Add this import
import com.ecommerce.entity.Eproduct;

@Repository // Add the @Repository annotation
public class EProductDAO {

    private JdbcTemplate template;

    @Autowired // Autowire the JdbcTemplate
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public EProductDAO() {
        // Create a default constructor
    }

    public List<Eproduct> getProducts() {
        return template.query("select * from eproduct", new RowMapper<Eproduct>() {
            public Eproduct mapRow(ResultSet rs, int row) throws SQLException {
                Eproduct e = new Eproduct();
                e.setID(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPrice(rs.getBigDecimal(3));
                e.setDateAdded(rs.getDate(4));
                return e;
            }
        });
    }
}
