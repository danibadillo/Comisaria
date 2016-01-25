/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    public String alquilar(Vehiculo vehiculo){
        int mensaje;
        boolean preguntar=true;
        String resultado = null;
        Iterator<Integer> it= this.listaPlazas.keySet().iterator();
        while(it.hasNext() && preguntar==true){
            mensaje=it.next();
            if(this.listaPlazas.get(mensaje).getAparcado()==null){
                preguntar=false;
                this.listaPlazas.get(mensaje).setAparcado(vehiculo);
                resultado=Integer.toString(mensaje);
            }
        }
        return resultado;
    }
    public int darBaja(int numeroPlaza){
        int mensaje = 0;
        boolean preguntar=true;
        int resultado=-1;
        Iterator<Integer> it= this.listaPlazas.keySet().iterator();
        while(it.hasNext() && preguntar==true)
            mensaje=it.next();
        if(mensaje==numeroPlaza){
            preguntar=false;
            if(this.listaPlazas.get(mensaje).getAparcado()!=null){
                this.listaPlazas.get(mensaje).setAparcado(null);
                resultado=0;
            }else{
                resultado=2;
            }
        }else{
            resultado=1;
        }
        return resultado;
    }
    
        
    
    }



    
        

