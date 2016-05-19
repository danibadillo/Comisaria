/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Multa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Lourdes
 */
public class JDBCDAO {

   private Connection conexion;
   
   public JDBCDAO() throws SQLException{
       String bd = "comisaria";
        String login = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/" + bd;
       conexion=DriverManager.getConnection(url, login, password);
   }

    public Connection getConexion() {
        return conexion;
    }
    
    public int introducirMultas(Connection conexion,String nombreDelito,String nombre,int importe,Multa multa) throws SQLException{
            int seleccion = 0;
            String insertar="insert into multas(descripcion,fecha,importe,idpolicia,nifinfractor,idtipo) values (?,?,?,?,?,?)";
            String consultaPolicia="select idPolicia from policia where nombre=?";
            String consultaMultas="select id from multastipo where descripcion=?";
            int numero = 0;
            int idmulta = 0;
            java.util.Date dt=new java.util.Date();
            java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHora=sdf.format(dt);
            PreparedStatement psConsultaMulta=conexion.prepareStatement(consultaMultas);            
            psConsultaMulta.setString(1,nombreDelito);
            ResultSet rsMulta=psConsultaMulta.executeQuery();
            rsMulta.next();
            idmulta=rsMulta.getInt(1);
            PreparedStatement psConsulta=conexion.prepareStatement(consultaPolicia);          
            psConsulta.setString(1,nombre);
            ResultSet rs=psConsulta.executeQuery();
            rs.next();
            numero=rs.getInt("idPolicia");
            PreparedStatement ps=conexion.prepareStatement(insertar);
            String descripcion=multa.getDescripcion();
            ps.setString(1,descripcion);
            ps.setString(2,fechaHora);
            ps.setInt(3,importe);
            ps.setInt(4,numero);
            String nif=multa.getNifinfractor();
            ps.setString(5,nif);
            ps.setInt(6,idmulta);
            seleccion=ps.executeUpdate();
            if(seleccion>=1){
                JOptionPane.showMessageDialog(null,"Datos introducidos con exito","Mensaje de confirmacion",JOptionPane.INFORMATION_MESSAGE);
            }
            return seleccion;
    }
   



}
