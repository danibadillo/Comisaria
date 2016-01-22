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
    public int numPlaza;
    public int numSotano;
    public Vehiculo aparcado;
    public char tipo;
    
    public Plaza(int numPlaza,int numSotano){
        this.numPlaza=numPlaza;
        this.numSotano=numSotano;
    }
    public int getNumPlaza() {
        return numPlaza;
    }
    public void setNumPlaza(int numPlaza) {
        this.numPlaza = numPlaza;
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
    public void setTipo(char tipo){
        this.tipo=tipo;
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
            mensaje="Numero plaza: "+this.numPlaza+" Sotano: "+this.numSotano;
        }else{
            mensaje="Numero plaza: "+this.numPlaza+" Sotano: "+this.numSotano+"\nVehiculo: "+this.aparcado.toString()+"\nPrecio: "+this.precio();
        }
        return mensaje;
    }
        
    
}
