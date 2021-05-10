/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.dao;

import com.wilmer.entity.Marca;
import com.wilmer.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class MarcaRepositorioImpl implements Repositorio<Marca> {

    private Connection getConexion() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Marca> listar() {
        List<Marca> marcas = new ArrayList<>();
        String sql = "SELECT * FROM marca";
        try (Statement stm = getConexion().createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Marca m = crearMarca(rs);
                marcas.add(m);
            }

        } catch (Exception e) {
        }
        return marcas;
    }

    @Override
    public Marca porId(Long id) {
        Marca marca = null;
        String sql = "SELECT * FROM marca WHERE id_marca = ?";
        try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                marca = crearMarca(rs);
            }

        } catch (Exception e) {
        }
        return marca;
    }

    @Override
    public void guardar(Marca t) {
        String ejemploInnerJoin = "SELECT p.nombre AS NOMBRE_PRODUCTO,p.precio as PRECIO, m.nombre as Nombre_Marca FROM ferreteria.producto as p inner join marca as m on (p.marca_id=m.id_marca);";
        String sql = "INSERT INTO marca(nombre) values(?)";
        try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
            ps.setString(1, t.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        String sql = "DELETE FROM marca WHERE id_marca=?";
        try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Marca crearMarca(ResultSet rs) throws SQLException {
        Marca m = new Marca();
        m.setIdMara(rs.getLong(1));
        m.setNombre(rs.getString(2));
        return m;
    }
}
