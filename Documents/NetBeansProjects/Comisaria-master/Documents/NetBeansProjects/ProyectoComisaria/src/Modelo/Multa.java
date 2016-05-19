/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Lourdes
 */
public class Multa {
    private int id,importe,idpolicia,idtipo;
    private String descripcion,nifinfractor;
    private Date fecha;

//    public Multa(int importe, int idpolicia, int idtipo, String descripcion, String nifinfractor, Date fecha) {
//        this.importe = importe;
//        this.idpolicia = idpolicia;
//        this.idtipo = idtipo;
//        this.descripcion = descripcion;
//        this.nifinfractor = nifinfractor;
//        this.fecha = fecha;
//    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getImporte() {
        return importe;
    }
    public void setImporte(int importe) {
        this.importe = importe;
    }
    public int getIdpolicia() {
        return idpolicia;
    }
    public void setIdpolicia(int idpolicia) {
        this.idpolicia = idpolicia;
    }
    public String getNifinfractor() {
        return nifinfractor;
    }
    public void setNifinfractor(String nifinfractor) {
        this.nifinfractor = nifinfractor;
    }
    public int getIdtipo() {
        return idtipo;
    }
    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
