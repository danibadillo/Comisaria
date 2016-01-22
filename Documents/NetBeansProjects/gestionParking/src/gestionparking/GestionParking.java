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
public class GestionParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehiculo v1=new Vehiculo("2375-BNK","45684667");
        Coche c1=new Coche("corto","2375-BNK","45684667");
        Coche c2=new Coche("largo","4386-HFG","45847098");
        Motocicleta m1=new Motocicleta("7657-BVC","86257809");
        Plaza p1=new Plaza(2,1);
        Plaza p2=new Plaza(3,2);
        Parking pk1=new Parking("blanco");
        
        
        
        v1.setModelo("seat ibiza");
        v1.setColor("azul");
        System.out.println(v1.toString());
        System.out.println("el precio del parking es: "+p1.precio());
        System.out.println(p1.toString());
        p1.setAparcado(c1);
        
        
        
        
        
        

    }
    
}
