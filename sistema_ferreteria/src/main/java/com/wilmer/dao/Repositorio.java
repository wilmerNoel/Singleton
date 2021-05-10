/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.dao;

import java.util.List;

/**
 *
 * @author wilmer
 */
public interface Repositorio<T> {

    public List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
