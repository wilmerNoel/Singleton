/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wilmer
 */
@Entity
@Table
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMara;

    private String nombre;

    public Long getIdMara() {
        return idMara;
    }

    public void setIdMara(Long idMara) {
        this.idMara = idMara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca() {
    }

    public Marca(Long idMara, String nombre) {
        this.idMara = idMara;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMara=" + idMara + ", nombre=" + nombre + '}';
    }

}
