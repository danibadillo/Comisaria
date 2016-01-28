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
public class Plaza {
    public Vehiculo aparcado;
    public int numeroSotano,numeroPlaza;
    public char tipo;
    
    public Plaza(int numeroPlaza,int numeroSotano,char tipo){
        this.numeroPlaza=numeroPlaza;
        this.numeroSotano=numeroSotano;
        this.tipo=tipo;
    }
    public Vehiculo getAparcado() {
        return aparcado;
    }
    public void setAparcado(Vehiculo aparcado) {
        this.aparcado = aparcado;
    }
    public int getNumeroSotano() {
        return numeroSotano;
    }
    public void setNumeroSotano(int numeroSotano) {
        this.numeroSotano = numeroSotano;
    }
    public int getNumeroPlaza() {
        return numeroPlaza;
    }
    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public int precio(){
        int precio = 0;
        if(this.aparcado!=null){
            if(this.aparcado instanceof Motocicleta){
                precio=20;
            }
            if(this.aparcado instanceof Coche){
                Coche c=(Coche) this.aparcado;
                String tipoPrecio=""+c.getTipo();
                if(tipoPrecio.equalsIgnoreCase("l")){
                    precio=55;
                }else{
                    precio=40;
                }
            }
            if(this.numeroSotano==2){
                precio-=5;
            }
        }
        return precio;
    }
    @Override
    public String toString(){
        String mensaje;
        if(this.aparcado==null){
            mensaje="Numero de plaza: "+this.numeroPlaza+" Sotano: "+this.numeroSotano;
        }else{
            mensaje="Numero de plaza: "+this.numeroPlaza+" Sotano: "+this.numeroSotano+"\nVehiculo: "+this.aparcado.toString()+"\nPrecio: "+this.precio();
        }
        return mensaje;
    }
}
