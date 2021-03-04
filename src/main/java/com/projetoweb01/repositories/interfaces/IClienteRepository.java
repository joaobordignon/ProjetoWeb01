package com.projetoweb01.repositories.interfaces;

import com.projetoweb01.entities.Cliente;

import java.sql.SQLException;


public interface IClienteRepository extends IBaseRepository<Cliente, Integer> {
    Cliente findByEmail(String email) throws SQLException;
}
