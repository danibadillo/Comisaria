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
public class Coche extends Vehiculo {
    public String tipoCoche;

    public Coche(String tipoCoche, String matricula, String nifDueño) {
        super(matricula, nifDueño);
        this.tipoCoche = tipoCoche;
    }
    public String getTipo() {
        return tipoCoche;
    }
    public void setTipo(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }

    

    
}
