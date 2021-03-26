package com.projetoweb01.repositories.dal;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.interfaces.IClienteRepository;
import com.projetoweb01.rowMapper.ClienteRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ClienteRepository implements IClienteRepository {

    private final JdbcTemplate jdbc;

    public ClienteRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Cliente obj) throws Exception {
        String query = "insert into Clientes values (null,?,?)";
        Object[] params = {obj.getNome(), obj.getEmail()};

        jdbc.update(query,params);
    }

    @Override
    public void update(Cliente obj) throws Exception {
        String query = "update Clientes set nome= ?, email= ? where idcliente= ?";
        Object[] params = {obj.getNome(), obj.getEmail(), obj.getIdCliente()};

        jdbc.update(query,params);
    }

    @Override
    public void delete(Integer id) throws Exception {
        String query = "delete from Clientes where idcliente=?";
        Object[] params = {id};

        jdbc.update(query,params);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        String query = "select * from Clientes";
        return jdbc.query(query, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getCliente(rs);
            }

        });
    }

    @Override
    public Cliente findById(Integer id) throws Exception {
        String query = "Select * from Clientes where idCliente = ?";
        return jdbc.queryForObject(query, new Object[]{id},new ClienteRowMapper());
    }

/*    @Override
    public Cliente findByEmail(String email) throws SQLException {
        String query = "Select * from Clientes where email = ?";
        return jdbc.queryForObject(query, new Object[]{email},new ClienteRowMapper());
    }*/

    @Override
    public Cliente findByEmail(String email) throws Exception {
        String query = "select * from clientes where email = ?";
        Object[] params = { email };

        List<Cliente> result = jdbc.query(query, params, new RowMapper<Cliente>() {

            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getCliente(rs);
            }
        });

        if(result != null && result.size() > 0)
            return result.get(0);

        return null;
    }



    private Cliente getCliente(ResultSet rs) throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idcliente"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));

        return cliente;
    }
}
