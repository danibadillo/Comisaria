/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author daw1
 */
public class Parking {
    private String nombre;
    private String direccion;
    private Map<String,Plaza> listaPlazas = new HashMap<>();
    
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
    public Map<String,Plaza> getListaPlazas() {
        return listaPlazas;
    }
    public void setListaPlazas(Map<String,Plaza> listaPlazas) {
        this.listaPlazas = listaPlazas;
    }
    public String alquilar(Vehiculo vehiculo){
        Iterator<String> it =listaPlazas.keySet().iterator();
        String plaza=null;
        while(it.hasNext()){
            String numPlaza=it.next();
            Plaza plazaP=listaPlazas.get(numPlaza);
            if(plazaP.getAparcado()==null){
                listaPlazas.put(numPlaza, plazaP);
                return numPlaza;
            }
        }
        return null;
    }
}
