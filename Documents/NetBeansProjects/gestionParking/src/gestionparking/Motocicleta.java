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
public class Motocicleta extends Vehiculo {
    public int numRuedas;

    public Motocicleta(String matricula, String nifDueño) {
        super(matricula, nifDueño);
    }
    public int getNumRuedas() {
        return numRuedas;
    }
    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
}
