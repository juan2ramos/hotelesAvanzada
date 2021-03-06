/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Controlador.ReservaMgr;
import Negocio.Reserva;
import java.util.ArrayList;

/**
 *
 * @author juan2ramos
 */
public class Reporte extends javax.swing.JInternalFrame {

    /**
     * Creates new form Reporte
     */
    public Reporte() {
        initComponents();
        llenarReporte();
    }
    private void llenarReporte(){
        ArrayList<Reserva> reservas = ReservaMgr.getInstance().reporte();
        String text = "";
        for (int i = 0; i < reservas.size(); i++) {

             text += "Reseva = " + reservas.get(i).getId()
                    + " Documento usuario : " + reservas.get(i).getUsuario().getDocumento()
                    + " Nombre usuario : " + reservas.get(i).getUsuario().getNombre()
                    + " Hotel " + reservas.get(i).getHotel().toString()
                    + " Habitacion  " + reservas.get(i).getHabitacion().toString()
                    + " Fecha Entrada : " + " Hotel " + reservas.get(i).getFechaLLegada()
                    + " Fecha salida : " + reservas.get(i).getFechaSalida()
                    + "\n\n";

        }
        texto.setText(text);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel1.setText("REPORTES");

        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane texto;
    // End of variables declaration//GEN-END:variables
}
