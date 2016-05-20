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
import Modelo.Policia;
import Vista.MultasListado;
import Vista.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes
 */
public class JDBCDAO {

    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    public JDBCDAO() throws SQLException {
        String bd = "comisaria";
        String login = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        conexion = DriverManager.getConnection(url, login, password);
    }

    public Connection getConexion() {
        return conexion;
    }

    public int introducirMultas(Connection conexion, String nombreDelito, String nombre, int importe, Multa multa) throws SQLException {
        int seleccion = 0;
        String insertar = "insert into multas(descripcion,fecha,importe,idpolicia,nifinfractor,idtipo) values (?,?,?,?,?,?)";
        String consultaPolicia = "select idPolicia from policia where nombre=?";
        String consultaMultas = "select id from multastipo where descripcion=?";
        int numero = 0;
        int idmulta = 0;
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        PreparedStatement psConsultaMulta = conexion.prepareStatement(consultaMultas);
        psConsultaMulta.setString(1, nombreDelito);
        ResultSet rsMulta = psConsultaMulta.executeQuery();
        rsMulta.next();
        idmulta = rsMulta.getInt(1);
        PreparedStatement psConsulta = conexion.prepareStatement(consultaPolicia);
        psConsulta.setString(1, nombre);
        ResultSet rs = psConsulta.executeQuery();
        rs.next();
        numero = rs.getInt("idPolicia");
        PreparedStatement ps = conexion.prepareStatement(insertar);
        String descripcion = multa.getDescripcion();
        ps.setString(1, descripcion);
        ps.setString(2, fechaHora);
        ps.setInt(3, importe);
        ps.setInt(4, numero);
        String nif = multa.getNifinfractor();
        ps.setString(5, nif);
        ps.setInt(6, idmulta);
        seleccion = ps.executeUpdate();
        if(seleccion>=1){
            JOptionPane.showMessageDialog(null,"Datos introducidos correctamente","Mensaje de confirmacion",JOptionPane.INFORMATION_MESSAGE);
        }
        return seleccion;
    }

    public int insertarPolicia(Policia policia) throws SQLException {
        String insertar = "INSERT policia VALUE (default, ?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(insertar);
        ps.setString(1, policia.getNombre());
        ps.setString(2, policia.getNumPlaca());
        ps.setInt(3, policia.getEdad());
        ps.setString(4, policia.getDepartamento());
        ps.setString(5, policia.getPathFoto());
        int insertado = ps.executeUpdate();
        ps.clearParameters();
        return insertado;
    }

    public int borrarPolicia(Policia policia) throws SQLException {
        int lineasBorradas = 0;
        String borrar = "DELETE FROM policia WHERE idPolicia = ?";
        ps = conexion.prepareStatement(borrar);
        ps.setInt(1, policia.getIdPolicia());
        lineasBorradas = ps.executeUpdate();
        return lineasBorradas;
    }
    
    public boolean comprobarPolicia(Policia policia) throws SQLException{
        boolean existePolicia = false;
        String consulta = "SELECT * FROM policia WHERE idPolicia = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1, policia.getIdPolicia());
        rs = ps.executeQuery();
        if(rs.next()){
           existePolicia = true;
        }
        ps.clearParameters();
        return existePolicia;
    }
    
    public String mostrarDatosPolicia(Policia policia) throws SQLException {
        String datos = "";
        if(comprobarPolicia(policia)){
            datos = "Id Policia:\t"+Integer.toString(rs.getInt("idPolicia"))+
                    "\nNombre:\t"+rs.getString("nombre")+
                    "\nNº de placa:\t"+rs.getString("numplaca")+
                    "\nEdad:\t"+Integer.toString(rs.getInt("edad"))+
                    "\nDepartamento\t:"+rs.getString("departamento");
        }else{
            datos = "No existe ningun policia con el idPolicia "+policia.getIdPolicia();
        }
        return datos;
    }
    
    public int modificarPolicia(Policia policiaExistente, Policia policiaModificado)throws SQLException {
        int lineasModificadas = 0;
        if(comprobarPolicia(policiaExistente)){
            String modificado = "UPDATE policia SET nombre = ?, numPlaca = ?,"
                                +"edad = ?, departamento = ?, foto = ?"
                                +"WHERE idPolicia = ? "; 
            ps = conexion.prepareStatement(modificado);
            if(policiaModificado.getNombre() == null){
                ps.setString(1, rs.getString("nombre"));
            }else{
                ps.setString(1, policiaModificado.getNombre());
            }
            if(policiaModificado.getNumPlaca() == null){
                ps.setString(2, rs.getString("numPlaca"));
            }else{
                ps.setString(2, policiaModificado.getNumPlaca());
            }
            if(policiaModificado.getEdad() == 0){
                ps.setInt(3, rs.getInt("edad"));
            }else{
                ps.setInt(3, policiaModificado.getEdad());
            }
            if(policiaModificado.getDepartamento() == null){
                ps.setString(4, rs.getString("departamento"));
            }else{
                ps.setString(4, policiaModificado.getDepartamento());
            }
            if(policiaModificado.getPathFoto() == null){
                ps.setString(5, rs.getString("foto"));
            }else{
                ps.setString(5, policiaModificado.getPathFoto());
            }
            ps.setInt(6, policiaExistente.getIdPolicia());
        }
        lineasModificadas = ps.executeUpdate();
        return lineasModificadas;
    }
    public List<Multa> MultasListado(Policia policia) throws SQLException{
        
        String consulta="select id,descripcion,fecha,importe,nifinfractor from multas where idpolicia=? ";
        String consulta2="select idPolicia from policia where nombre=? or numplaca=?";
        
        PreparedStatement psconsulta2=conexion.prepareStatement(consulta2);
        String nombre=policia.getNombre();
        psconsulta2.setString(1,nombre);
        String numPlaca=policia.getNumPlaca();
        psconsulta2.setString(2,numPlaca);
        ResultSet rsconsulta2=psconsulta2.executeQuery();
        rsconsulta2.next();
        int id1=rsconsulta2.getInt(1);
//        int id2=rsconsulta2.getInt(1);
        
        PreparedStatement psconsulta1=conexion.prepareStatement(consulta);
        psconsulta1.setInt(1,id1);
//        psconsulta1.setInt(2,id2);
        ResultSet rsconsulta=psconsulta1.executeQuery();
        List<Multa> multas = new ArrayList<>();
        
        while(rsconsulta.next()){
            Multa multa = new Multa();
            multa.setId(Integer.parseInt(rsconsulta.getString(1)));
            multa.setDescripcion(rsconsulta.getString(2));
            multa.setFecha(rsconsulta.getDate(3));
            multa.setImporte(Integer.parseInt(rsconsulta.getString(4)));
            multa.setNifinfractor(rsconsulta.getString(5));
            multas.add(multa);
//                filas[1]=;
//                filas[2]=rsconsulta.getString(3);
//                filas[3]=rsconsulta.getString(4);
//                filas[4]=rsconsulta.getString(5);
//                modelo.addRow(filas);
        }
        return multas;
    }
  
}
