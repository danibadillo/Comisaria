/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author daw1
 */
public class Parking {
    private String nombre;
    private String direccion;
    private Map<Integer,Plaza> listaPlazas = new HashMap<>();
    
    public Parking(String nombre){
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Map<Integer,Plaza> getListaPlazas() {
        return listaPlazas;
    }
    public void setListaPlazas(Map<Integer,Plaza> listaPlazas) {
        this.listaPlazas = listaPlazas;
    }
}
