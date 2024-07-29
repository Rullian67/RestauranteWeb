/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo.dao;

import com.mycompany.mavenproject1.modelo.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tulio
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDao extends GenericoDAO<Cliente> {
    
    public void salvar(Cliente c) {
        String insert = "INSERT INTO Cliente (nome, email, telefone, cpf, senha) VALUES (?, ?, ?, ?, ?)";
        save(insert, c.getNome(), c.getEmail(), c.getTelefone(), c.getCpf(), c.getSenha());
    }
    
    public void alterar(Cliente c) {
        String update = "UPDATE Cliente SET nome = ?, email = ?, telefone = ?, cpf = ?, senha = ? WHERE id = ?";
        save(update, c.getNome(), c.getEmail(), c.getTelefone(), c.getCpf(), c.getSenha(), c.getId());
    }
    
    public void excluir(Cliente c) {
        String delete = "DELETE FROM Cliente WHERE id = ?";
        save(delete, c.getId());
    }
    
    public Cliente buscarPorId(int id) {
        String select = "SELECT * FROM Cliente WHERE id = ?";
        return buscarPorId(select, new ClienteRowMapper(), id);
    }
    
    public List<Cliente> buscarTodos() {
        String select = "SELECT * FROM Cliente";
        return buscarTodos(select, new ClienteRowMapper());
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setSenha(rs.getString("senha"));
            return cliente;
        }
    }
     public Cliente buscarPorUsername(String username) {
        String select = "SELECT * FROM USUARIO WHERE USERNAME = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cliente usuario = new Cliente();
                usuario.setId(resultSet.getInt("ID"));
                usuario.setUsername(resultSet.getString("USERNAME"));
                usuario.setPassword(resultSet.getString("PASSWORD"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

