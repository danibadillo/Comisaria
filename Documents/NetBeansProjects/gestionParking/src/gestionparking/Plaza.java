/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionparking;

/**
 *
 * @author daw1
 */
class Plaza {
    public String numeroPlaza;
    public int numSotano;
    public Vehiculo aparcado;
    public char tipo;
    
    public Plaza(String numeroPlaza,int numSotano){
        this.numeroPlaza=numeroPlaza;
        this.numSotano=numSotano;
    }
    public String getNumeroPlaza() {
        return numeroPlaza;
    }
    public void setNumeroPlaza(String numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
    public int getNumSotano() {
        return numSotano;
    }
    public void setNumSotano(int numSotano) {
        this.numSotano = numSotano;
    }
    public Vehiculo getAparcado() {
        return aparcado;
    }
    public void setAparcado(Vehiculo aparcado) {
        this.aparcado = aparcado;
    }
    public char getTipo(){
        return tipo;
    }
    public boolean setTipo(char tipo){
        boolean valido = false;
        if (tipo == 'C' || tipo == 'M') {
            valido = true;
            this.tipo = tipo;
        }
        return valido;
    }
    public int precio(){
        int precio = 0;
        if(this.aparcado instanceof Coche){
            Coche automovil=(Coche) this.aparcado;
            if(automovil.getTipo().equalsIgnoreCase("corto")){
                precio=40;
            }
            if(automovil.getTipo().equalsIgnoreCase("largo")){
                precio=55;
            }
        }
        if(this.aparcado instanceof Motocicleta){
            Motocicleta moto=(Motocicleta) this.aparcado;
            precio=25;
        }
      return precio;
    }
    @Override
    public String toString(){
        String mensaje=null;
        if(this.aparcado==null){
            mensaje="Numero plaza: "+this.numeroPlaza+" Sotano: "+this.numSotano;
        }else{
            mensaje="Numero plaza: "+this.numeroPlaza+" Sotano: "+this.numSotano+"\nVehiculo: "+this.aparcado.toString()+"\nPrecio: "+this.precio();
        }
        return mensaje;
    }
        
    
}
