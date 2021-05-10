/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.entity;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author wilmer
 */
@Data
public class Categoria implements Serializable {

    private Long idCategoria;
    private String nombre;

}
