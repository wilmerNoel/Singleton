/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.run;

import com.wilmer.modelo.*;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class EjemploFactura {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();

        cliente1.setNombre("WILMER NOEL MEMBREÑO ARGUETA");
        cliente1.setNit("1204-060195-101-8");

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese descripcion de factura: ");
        Factura factura1 = new Factura(s.nextLine(), cliente1);

        Producto producto;

        for (int i = 0; i < 5; i++) {

            producto = new Producto();

            System.out.println("Ingrese el producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.println("Ingrese el precio del producto : ");
            producto.setPrecio(s.nextFloat());

            System.out.println("Ingrese la cantidad");
            factura1.itemDetalleFactura(new DetalleFactura(s.nextInt(), producto));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura1.generarDetalle());
    }
}
