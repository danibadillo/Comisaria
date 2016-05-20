/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.JDBCDAO;
import Modelo.Multa;
import Modelo.Policia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes
 */
public class MultasListado extends javax.swing.JDialog {

    JDBCDAO jdbcdao=new JDBCDAO();
    
    public MultasListado(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        jdbcdao.getConexion();
        this.setTitle("Listado de multas por policia");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        botonmenuprincipal = new javax.swing.JButton();
        botonbuscarMultas = new javax.swing.JButton();
        botonexportararchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Introduce nombre o placa del policia");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Descripcion", "Fecha", "Importe", "NifInfractor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        botonmenuprincipal.setBackground(new java.awt.Color(102, 102, 102));
        botonmenuprincipal.setForeground(new java.awt.Color(153, 0, 0));
        botonmenuprincipal.setText("Volver al Menu Principal");
        botonmenuprincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmenuprincipalActionPerformed(evt);
            }
        });

        botonbuscarMultas.setBackground(new java.awt.Color(102, 102, 102));
        botonbuscarMultas.setForeground(new java.awt.Color(153, 0, 0));
        botonbuscarMultas.setText("Buscar Multas");
        botonbuscarMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarMultasActionPerformed(evt);
            }
        });

        botonexportararchivo.setBackground(new java.awt.Color(102, 102, 102));
        botonexportararchivo.setForeground(new java.awt.Color(153, 0, 0));
        botonexportararchivo.setText("Exportar a un Archivo");
        botonexportararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonexportararchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(botonbuscarMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonexportararchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonmenuprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonbuscarMultas)
                    .addComponent(botonexportararchivo))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botonmenuprincipal)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonmenuprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmenuprincipalActionPerformed
        dispose();
        try {
            Principal principal=new Principal();
            principal.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonmenuprincipalActionPerformed

    private void botonbuscarMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarMultasActionPerformed
          String [] filas=new String[5];
          String [] datos={"Id","Descripcion","Fecha","Importe","NifInfractor"};
          DefaultTableModel modelo=new DefaultTableModel(null,datos);
//        String consulta="select id,descripcion,fecha,importe,nifinfractor from multas where idpolicia=? or idpolicia=?";
//        String consulta2="select idPolicia from policia where nombre=? or numplaca=?";
//        int id1 = 0,id2 = 0;
//        try {
//            PreparedStatement psconsulta2=jdbcdao.getConexion().prepareStatement(consulta2);
//            String nombre=txtnombre.getText();
//            psconsulta2.setString(1,nombre);
//            String numPlaca=txtnombre.getText();
//            psconsulta2.setString(2,numPlaca);
//            ResultSet rsconsulta2=psconsulta2.executeQuery();
//            rsconsulta2.next();
//            id1=rsconsulta2.getInt(1);
//            id2=rsconsulta2.getInt(1);
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
//        }catch(NumberFormatException e){
//            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
//        }
//        try {
//            PreparedStatement ps=jdbcdao.getConexion().prepareStatement(consulta);
//            ps.setInt(1,id1);
//            ps.setInt(2,id2);
//            ResultSet rsconsulta=ps.executeQuery();
//            rsconsulta.next();
//            while(rsconsulta.next()){
//                filas[0]=rsconsulta.getString(1);
//                filas[1]=rsconsulta.getString(2);
//                filas[2]=rsconsulta.getString(3);
//                filas[3]=rsconsulta.getString(4);
//                filas[4]=rsconsulta.getString(5);
//                modelo.addRow(filas);
//            }

        Policia policia=new Policia();
        try {            
            policia.setNombre(txtnombre.getText());
            policia.setNumPlaca(txtnombre.getText());
            List<Multa> multas = jdbcdao.MultasListado(policia);
            for(Multa multa: multas){
                filas[0] = Integer.toString(multa.getId());
                filas[1] = multa.getDescripcion();
                filas[2] = multa.getFecha().toString();
                filas[3] = Integer.toString(multa.getImporte());
                filas[4] = multa.getNifinfractor();
                modelo.addRow(filas);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
            
//            modelo.addRow(datos);
            this.tablaDatos.setModel(modelo);
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_botonbuscarMultasActionPerformed

    private void botonexportararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonexportararchivoActionPerformed
        
    }//GEN-LAST:event_botonexportararchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MultasListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultasListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultasListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultasListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MultasListado dialog = null;
                try {
                    dialog = new MultasListado(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(MultasListado.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonbuscarMultas;
    private javax.swing.JButton botonexportararchivo;
    private javax.swing.JButton botonmenuprincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
