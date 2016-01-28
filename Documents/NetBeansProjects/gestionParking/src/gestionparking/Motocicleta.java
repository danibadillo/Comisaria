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
    public int numeroRuedas;

    public Motocicleta(String matricula, String nifDueño) {
        super(matricula, nifDueño);
    }
    public int getNumeroRuedas() {
        return numeroRuedas;
    }
    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }
}
