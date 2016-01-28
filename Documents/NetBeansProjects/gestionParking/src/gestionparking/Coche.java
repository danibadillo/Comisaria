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
    public char tipo;

    public Coche(char tipo, String matricula, String nifDueño) {
        super(matricula, nifDueño);
        this.tipo = tipo;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    

    
}
