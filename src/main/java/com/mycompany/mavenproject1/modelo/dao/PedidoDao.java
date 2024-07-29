/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.modelo.dao;

/**
 *
 * @author rulli
 */

import com.mycompany.mavenproject1.modelo.entidade.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PedidoDao extends GenericoDAO<Pedido> {

    public void salvar(Pedido p) {
        String insert = "INSERT INTO Pedido (cliente_id, data, total) VALUES (?, ?, ?)";
        save(insert, p.getClienteId(), p.getData(), p.getTotal());
    }

    public void alterar(Pedido p) {
        String update = "UPDATE Pedido SET cliente_id = ?, data = ?, total = ? WHERE id = ?";
        save(update, p.getClienteId(), p.getData(), p.getTotal(), p.getId());
    }

    public void excluir(Pedido p) {
        String delete = "DELETE FROM Pedido WHERE id = ?";
        save(delete, p.getId());
    }

    public Pedido buscarPorId(int id) {
        String select = "SELECT * FROM Pedido WHERE id = ?";
        return buscarPorId(select, new PedidoRowMapper(), id);
    }

    public List<Pedido> buscarTodos() {
        String select = "SELECT * FROM Pedido";
        return buscarTodos(select, new PedidoRowMapper());
    }

    public static class PedidoRowMapper implements RowMapper<Pedido> {
        @Override
        public Pedido mapRow(ResultSet rs) throws SQLException {
            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setClienteId(rs.getInt("cliente_id"));
            pedido.setData(rs.getDate("data"));
            pedido.setTotal(rs.getDouble("total"));
            return pedido;
        }
    }
}

