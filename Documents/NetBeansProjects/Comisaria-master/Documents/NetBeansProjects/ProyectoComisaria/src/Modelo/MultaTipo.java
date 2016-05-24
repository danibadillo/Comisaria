/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lourdes
 */
public class MultaTipo {
    private int id,carnetpuntos;
    private String descripcion,tipo;
    private double importe;
    
    public MultaTipo(){
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCarnetpuntos() {
        return carnetpuntos;
    }
    public void setCarnetpuntos(int carnetpuntos) {
        this.carnetpuntos = carnetpuntos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    
}
