package com.projetoweb01.repositories.dal;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.interfaces.IClienteRepository;
import com.projetoweb01.rowMapper.ClienteRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;


public class ClienteRepository implements IClienteRepository {

    private final JdbcTemplate jdbc;

    public ClienteRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Cliente obj) throws Exception {
        String query = "insert into Cliente values (null,?,?)";
        Object[] params = {obj.getNome(), obj.getEmail()};

        jdbc.update(query,params);
    }

    @Override
    public void update(Cliente obj) throws Exception {
        String query = "update Cliente set nome=?, email=? where idcliente=?";
        Object[] params = {obj.getNome(), obj.getEmail(), obj.getIdCliente()};

        jdbc.update(query,params);
    }

    @Override
    public void delete(Integer id) throws Exception {
        String query = "delete from Cliente where idcliente=?";
        Object[] params = {id};

        jdbc.update(query,params);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        String query = "select * from Clientes";
        return jdbc.query(query, new ClienteRowMapper());
    }

    @Override
    public Cliente findById(Integer id) throws Exception {
        String query = "Select * from Clientes where idCliente = ?";
        return jdbc.queryForObject(query, new Object[]{id},new ClienteRowMapper());
    }

    @Override
    public Cliente findByEmail(String email) throws SQLException {
        String query = "Select * from Clientes where email = ?";
        return jdbc.queryForObject(query, new Object[]{email},new ClienteRowMapper());
    }
}
