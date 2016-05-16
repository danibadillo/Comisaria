/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Datos.JDBCDAO;
import Vista.Principal;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author Lourdes
 */
public class Inicio {
    static Connection conexion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Principal principal=new Principal();
        principal.setVisible(true);
        JDBCDAO j = new JDBCDAO();
        conexion = j.conectar();
        
    }
    
}
