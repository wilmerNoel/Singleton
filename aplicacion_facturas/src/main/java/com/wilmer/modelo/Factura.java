/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wilmer
 */
public class Factura {
    
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private DetalleFactura[] detalleFactura;
    private int indiceDetalleFactura;
    private static int ultimoFolio;
    
    public static final int MAX_DETALLE_FACTURAS = 10;
    
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.detalleFactura = new DetalleFactura[MAX_DETALLE_FACTURAS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getFolio() {
        return folio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public DetalleFactura[] getDetalleFactura() {
        return detalleFactura;
    }
    
    public void itemDetalleFactura(DetalleFactura detalle) {
        if (indiceDetalleFactura < MAX_DETALLE_FACTURAS) {
            this.detalleFactura[indiceDetalleFactura++] = detalle;
        }
        
    }
    
    public float calcularTotal() {
        float total = 0.0f;
        for (DetalleFactura detalle : detalleFactura) {
            if (detalle == null) {
                continue;
            }
            total += detalle.calcularImporte();
        }
        return total;
    }
    
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        
        sb.append("\nNumero Factura: ").
                append(folio).
                append("\nCliente: ").
                append(this.cliente.getNombre()).
                append("\tNIT: ").
                append(this.cliente.getNit()).
                append("\nDescripcion: ").
                append(this.descripcion).
                append("\n").
                append("Fecha Emision: ").
                append(sf.format(this.fecha)).
                append("\n#\tNombre\t$\tCant.\tTotal\n");
        for (DetalleFactura detalle : detalleFactura) {
            if (detalle == null) {
                continue;
            }
            sb.append(detalle).append("\n");
            //otra manera de hacerlo es asi
            /*sb.append(detalle.getProducto().getCodigo())
                    .append("\t")
                    .append(detalle.getProducto().getNombre())
                    .append("\t")
                    .append(detalle.getProducto().getPrecio())
                    .append("\t")
                    .append(detalle.getCantidad())
                    .append("\t")
                    .append(detalle.calcularImporte())
                    .append("\n");*/
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());
        
        return sb.toString();
    }
}
