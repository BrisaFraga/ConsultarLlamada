/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.GestorConsultarLlamada;
import entidades.Llamada;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Brisa
 */
public class ConsultarEncuesta extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarEncuesta
     */
    GestorConsultarLlamada gestorConsultarLlamada = new GestorConsultarLlamada();
    public ConsultarEncuesta() throws ParseException {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        lvlFechaDesde = new javax.swing.JLabel();
        lvlFechaHasta = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLlamadas = new javax.swing.JList<>();
        btnSeleccionarLlamada = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lvlSeleccioneUnaLlamada = new javax.swing.JLabel();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lvlFechaDesde.setText("Fecha desde:");

        lvlFechaHasta.setText("Fecha hasta:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listLlamadas);

        btnSeleccionarLlamada.setText("Selecionar Llamada");
        btnSeleccionarLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarLlamadaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lvlSeleccioneUnaLlamada.setText("Llamadas Encontradas, seleccione una:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionarLlamada, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lvlFechaDesde))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lvlFechaHasta)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(lvlSeleccioneUnaLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvlFechaDesde)
                    .addComponent(lvlFechaHasta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnCancelar))
                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lvlSeleccioneUnaLlamada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarLlamada)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Date fechaInicio = fechaDesde.getDate();
        Date fechaFin = fechaHasta.getDate();

        if (fechaInicio == null || fechaFin == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        gestorConsultarLlamada.buscarLlamadasPorFechas(fechaInicio, fechaFin); 
        
        if (gestorConsultarLlamada.getLlamadasConEncuesta().isEmpty()) {
    JOptionPane.showMessageDialog(this, "No hay Llamadas con encuesta respondida en el periodo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
}else {
        
        DefaultListModel<String> model = new DefaultListModel<>();
    List<Llamada> llamadasFiltradas = gestorConsultarLlamada.getLlamadasConEncuesta();

    for (Llamada llamada : llamadasFiltradas) {
        model.addElement(gestorConsultarLlamada.mostrarLlamadasString(llamada)); // Asumiendo que tienes un método toString en la clase Llamada para obtener una representación en texto.
    }

    listLlamadas.setModel(model);}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarLlamadaActionPerformed
// Obtener el índice seleccionado en la lista
    int selectedIndex = listLlamadas.getSelectedIndex();
    
    // Verificar si se seleccionó una llamada
    if (selectedIndex != -1) {
        // Obtener la llamada seleccionada
        
        gestorConsultarLlamada.setLlamadaSeleccionada(gestorConsultarLlamada.getLlamadasConEncuesta().get(selectedIndex)); 

        String mensaje = gestorConsultarLlamada.formatearLlamadaSelecionada(gestorConsultarLlamada.getLlamadaSeleccionada());
       
        // Mostrar el mensaje en una ventana emergente con botones
        int option = JOptionPane.showOptionDialog(this, mensaje, "Detalles de la llamada", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[]{"Generar CSV", "Imprimir Archivo", "Cancelar"}, null);

        // Verificar la opción seleccionada
        if (option == 0) {
            // Opción "Generar CSV" seleccionada
            gestorConsultarLlamada.generarCSV();
               // Después de generar el CSV exitosamente
            JOptionPane.showOptionDialog(
                this,
                "CSV generado con éxito.",
                "Éxito",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Continuar"},
                null
            );
            


        } else if (option == 1) {
            // Opción "Imprimir Archivo" seleccionada
            // Agrega aquí la lógica para imprimir el archivo
        } else if (option == 2) {
    // Opción "Cancelar" seleccionada
    System.exit(0); // Cierra la aplicación
}  

    } else {
        // No se seleccionó ninguna llamada
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una llamada.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSeleccionarLlamadaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed
    


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
            java.util.logging.Logger.getLogger(ConsultarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultarEncuesta().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarEncuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionarLlamada;
    private java.awt.Button button1;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listLlamadas;
    private javax.swing.JLabel lvlFechaDesde;
    private javax.swing.JLabel lvlFechaHasta;
    private javax.swing.JLabel lvlSeleccioneUnaLlamada;
    // End of variables declaration//GEN-END:variables
}
