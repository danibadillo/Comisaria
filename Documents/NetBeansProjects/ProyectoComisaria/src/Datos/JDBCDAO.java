/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Vista.MultasIntroducir;

/**
 *
 * @author Lourdes
 */
public class JDBCDAO {
   private static String bd = "comisaria";
   private static String login = "root";
   private static String password = "root";
   private static String url = "jdbc:mysql://localhost:3306/" + bd;
   Connection conexion;
   
   public Connection conectar () throws SQLException{
       try{
       conexion=DriverManager.getConnection(url, login, password);

       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
       }
       return conexion;
   }




}
