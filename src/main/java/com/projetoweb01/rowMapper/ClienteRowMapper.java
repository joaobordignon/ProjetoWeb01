package com.projetoweb01.rowMapper;

import com.projetoweb01.entities.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRowMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Cliente c = new Cliente();
        c.setIdCliente(rs.getInt(1));
        c.setNome(rs.getString(2));
        c.setEmail(rs.getString(3));
        return c;
    }
}
