package com.projetoweb01.repositories.dal;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.interfaces.IClienteRepository;

import java.sql.SQLException;
import java.util.List;


public class ClienteRepository implements IClienteRepository {
    @Override
    public void create(Cliente obj) throws Exception {

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
