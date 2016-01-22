/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

/**
 *
 * @author Lourdes
 */
public class Vehiculo {
    public String matricula,modelo,color,nifDueño,telefono;
    
    public Vehiculo(String matricula,String nifDueño){
        this.matricula=matricula;
        this.nifDueño=nifDueño;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getNifDueño() {
        return nifDueño;
    }
    public void setNifDueño(String nifDueño) {
        this.nifDueño = nifDueño;
    }
    public String getTelefono() {
        String mensaje="";
        if(telefono.length()>9){
            return "el telefono introducido no es correcto";
        }
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString(){
        return this.matricula+" "+this.modelo+" "+this.color;
            
    }
    
}
