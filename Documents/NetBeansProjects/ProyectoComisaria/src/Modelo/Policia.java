/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;


public class Policia {
    private int idPolicia,edad;
    private String nombre,numPlaca,departamento;
    private Image foto;
    
    public Policia(int idPolicia,String nombre,String numPlaca,int edad,String departamento,Image foto){
        this.idPolicia=idPolicia;
        this.nombre=nombre;
        this.numPlaca=numPlaca;
        this.edad=edad;
        this.departamento=departamento;
        this.foto=foto;
    }
    public int getIdPolicia() {
        return idPolicia;
    }
    public void setIdPolicia(int idPolicia) {
        this.idPolicia = idPolicia;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumPlaca() {
        return numPlaca;
    }
    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public Image getFoto() {
        return foto;
    }
    public void setFoto(Image foto) {
        this.foto = foto;
    }
}
