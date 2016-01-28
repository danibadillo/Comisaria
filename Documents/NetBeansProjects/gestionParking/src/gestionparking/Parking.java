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
 * @author Lourdes
 */
public class Parking {
    private String nombre,direccion;
    private Map<Integer,Plaza> listaPlazas = new HashMap<>();
    
    public Parking(String nombre){
        this.nombre=nombre;
        //almacenamos las plazas que hay en nuestro garaje
        Plaza p1=new Plaza(12,1,'c');
        Plaza p2=new Plaza(15,1,'l');
        Plaza p3=new Plaza(45,2,'c');
        Plaza p4=new Plaza(7,2,'c');
        Plaza p5=new Plaza(56,2,'l');
        Plaza p6=new Plaza(10,2,'l');
        Plaza p7=new Plaza(25,2,'M');
        Plaza p8=new Plaza(23,1,'M');
        Plaza p9=new Plaza(8,1,'c');
        Plaza p10=new Plaza(7,1,'l');
        listaPlazas.put(p1.getNumeroPlaza()+p1.getNumeroSotano(), p1);
        listaPlazas.put(p2.getNumeroPlaza()+p2.getNumeroSotano(), p2);
        listaPlazas.put(p3.getNumeroPlaza()+p3.getNumeroSotano(), p3);
        listaPlazas.put(p4.getNumeroPlaza()+p4.getNumeroSotano(), p4);
        listaPlazas.put(p5.getNumeroPlaza()+p5.getNumeroSotano(), p5);
        listaPlazas.put(p6.getNumeroPlaza()+p6.getNumeroSotano(), p6);
        listaPlazas.put(p7.getNumeroPlaza()+p7.getNumeroSotano(), p7);
        listaPlazas.put(p8.getNumeroPlaza()+p8.getNumeroSotano(), p8);
        listaPlazas.put(p9.getNumeroPlaza()+p9.getNumeroSotano(), p9);
        listaPlazas.put(p10.getNumeroPlaza()+p10.getNumeroSotano(), p10);
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
        String mensaje = null;
        boolean auxiliar=false;
        Plaza value;
        Iterator<Integer>it =listaPlazas.keySet().iterator();
        while(it.hasNext() && auxiliar==false){
            value=this.listaPlazas.get(it.next());
            String tipo=""+value.getTipo();
            if(vehiculo instanceof Motocicleta && tipo.equalsIgnoreCase("M") && value.getAparcado()==null){
                value.setAparcado(vehiculo);
                auxiliar=true;
                mensaje=value.getNumeroPlaza()+" "+value.getNumeroSotano();
            }
            String tipo2=""+value.getTipo();
            if(vehiculo instanceof Coche && tipo2.equalsIgnoreCase("c") && value.getAparcado()==null){
                value.setAparcado(vehiculo);
                auxiliar=true;
                mensaje=value.getNumeroPlaza()+" "+value.getNumeroSotano();
            }
            String tipo3=""+value.getTipo();
            if(vehiculo instanceof Coche &&tipo3.equalsIgnoreCase("l") && value.getAparcado()==null){
                value.setAparcado(vehiculo);
                auxiliar=true;
                mensaje=value.getNumeroPlaza()+" "+value.getNumeroSotano();
            }
        }
        return mensaje;
}
    public int darBaja(int numeroPlaza){
        int mensaje=1;
        Iterator<Integer>it =listaPlazas.keySet().iterator();
        while(it.hasNext()){
            int numero=it.next();
            Plaza pl=listaPlazas.get(numero);
            if(numeroPlaza==pl.getNumeroPlaza()){
                if(pl.getAparcado()!=null){
                    pl.setAparcado(null);
                    mensaje=0;
                }else{
                    mensaje=2;
                }
            }
        }
        return mensaje;
    }
    public List<Plaza> listarPlazas(String estado,char tipoVehiculo){
        List<Plaza> lista = new ArrayList<>();
        for(Plaza pl:listaPlazas.values()){
            if(estado.equalsIgnoreCase("libre") && pl.getAparcado()==null && tipoVehiculo==pl.getTipo()){
                lista.add(pl);
            }
            if(estado.equalsIgnoreCase("ocupado") && pl.getAparcado()!=null && tipoVehiculo==pl.getTipo()){
                lista.add(pl);
            }
        }
        return lista;
    }
    public int ganancias(){
        int beneficios = 0;
        List<Plaza> listaCochesCortos=new ArrayList<>();
        listaCochesCortos=listarPlazas("ocupado",'c');
        List<Plaza> listaCochesLargos=new ArrayList<>();
        listaCochesLargos=listarPlazas("ocupado",'l');
        List<Plaza> listaMotos=new ArrayList<>();
        listaMotos=listarPlazas("ocupado",'M');
        for(Plaza p:listaCochesCortos){
            beneficios+=p.precio();
        }
        for(Plaza pl:listaMotos){
            beneficios+=pl.precio();
        }
        for(Plaza plaza:listaCochesLargos){
            beneficios+=plaza.precio();
        }
        return beneficios;
    }
        
    }

