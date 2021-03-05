package com.projetoweb01.repositories.dal;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.interfaces.IClienteRepository;
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
        String query = "insert into Cliente(idCliente, nome, email) values (NULL,?,?)";
        Object[] params = {obj.getNome(), obj.getEmail()};

        jdbc.update(query,params);
    }

    @Override
    public void update(Cliente obj) throws Exception {

    }

    @Override
    public void delete(Integer integer) throws Exception {

    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return null;

        // row mapper
    }

    @Override
    public Cliente findById(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Cliente findByEmail(String email) throws SQLException {
        return null;
    }
}
