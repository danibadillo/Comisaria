/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

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
        boolean f = false;
        String numeroPlaza=null;
        Iterator<String> it= listaPlazas.keySet().iterator();
        while(it.hasNext() || f==true){
            String snn = it.next();
            Plaza aparcado = listaPlazas.get(it);
            if (aparcado.getAparcado()==null){
                listaPlazas.put(snn,aparcado);
                f=true;
                numeroPlaza=aparcado.getNumeroPlaza();
            }
        }
        
        return numeroPlaza;
    }
    public int darBaja(int numeroPlaza){
        int mensaje = 0;
        Iterator<String> it=listaPlazas.keySet().iterator();
        while(it.hasNext()){
            String snn=it.next();
            Plaza aparcado=listaPlazas.get(it);
            if(aparcado.getAparcado()!=null){
                listaPlazas.remove(snn,aparcado);
                mensaje=0;
            }else{
                mensaje=1;
            }
            if(aparcado==null){
                mensaje=2;
            }
        }
        return mensaje;
    }
    public List<Plaza>listarPlazas(String estado,char tipo){
        
    }
    }



    
        

