/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PararReanudar;


/**
 *
 * @author Pedro
 */
public class Interfaz extends javax.swing.JFrame 
{
    private Hilo hilo1;
    private Hilo hilo2;
    
    public Interfaz()
    {
        setTitle("Ejecutar, suspender y reanudar hilos PJRG");
	    setLocationRelativeTo(null);
	    setResizable(false);
        
        initComponents();

        hilo1 = new Hilo(mostrarHilo1, "Hilo1");
        hilo2 = new Hilo(mostrarHilo2, "Hilo2");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonInicio = new javax.swing.JButton();
        botonFinalizar = new javax.swing.JButton();
        infoHilo1 = new javax.swing.JLabel();
        infoHilo2 = new javax.swing.JLabel();
        mostrarHilo1 = new javax.swing.JTextField();
        mostrarHilo2 = new javax.swing.JTextField();
        reanudarHilo1 = new javax.swing.JButton();
        suspenderHilo1 = new javax.swing.JButton();
        reanudarHilo2 = new javax.swing.JButton();
        suspenderHilo2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonInicio.setText("Comenzar proceso");
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarProcesoActionPerformed(evt);
            }
        });

        botonFinalizar.setText("Finalizar proceso");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        infoHilo1.setText("Hilo 1");

        infoHilo2.setText("Hilo 2");

        mostrarHilo1.setEditable(false);

        mostrarHilo2.setEditable(false);

        reanudarHilo1.setText("Reanudar");
        reanudarHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarHilo1ActionPerformed(evt);
            }
        });

        suspenderHilo1.setText("Suspender");
        suspenderHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspenderHilo1ActionPerformed(evt);
            }
        });

        reanudarHilo2.setText("Reanudar");
        reanudarHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarHilo2ActionPerformed(evt);
            }
        });

        suspenderHilo2.setText("Suspender");
        suspenderHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspenderHilo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(reanudarHilo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reanudarHilo2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(infoHilo1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(infoHilo2)
                                .addGap(16, 16, 16)))))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(suspenderHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(suspenderHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonInicio)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reanudarHilo1)
                    .addComponent(reanudarHilo2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suspenderHilo1)
                    .addComponent(suspenderHilo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrarHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrarHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoHilo1)
                    .addComponent(infoHilo2))
                .addGap(46, 46, 46)
                .addComponent(botonFinalizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comenzarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarProcesoActionPerformed
        hilo1.start();
        hilo2.start();
        infoHilo1.setText("Hilo 1 corriendo");
        infoHilo2.setText("Hilo 2 corriendo");
        botonInicio.setEnabled(false);
    }//GEN-LAST:event_comenzarProcesoActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        hilo1.pararHilo();
        hilo2.pararHilo();
        infoHilo1.setText("Hilo 1 finalizado");
        infoHilo2.setText("Hilo 2 finalizado");
        System.out.println(hilo1.getName() + " : " + hilo1.getContador() );
        System.out.println(hilo2.getName() + " : " + hilo2.getContador() );
    }//GEN-LAST:event_botonFinalizarActionPerformed

    private void reanudarHilo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarHilo1ActionPerformed
        hilo1.Reanuda();
        infoHilo1.setText("Hilo 1 corriendo");
    }//GEN-LAST:event_reanudarHilo1ActionPerformed

    private void suspenderHilo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspenderHilo1ActionPerformed
        hilo1.Suspende();
        infoHilo1.setText("Hilo 1 suspendido");
    }//GEN-LAST:event_suspenderHilo1ActionPerformed

    private void reanudarHilo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarHilo2ActionPerformed
        hilo2.Reanuda();
        infoHilo2.setText("Hilo 1 corriendo");
    }//GEN-LAST:event_reanudarHilo2ActionPerformed

    private void suspenderHilo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspenderHilo2ActionPerformed
        hilo2.Suspende();
        infoHilo2.setText("Hilo 2 suspendido");
    }//GEN-LAST:event_suspenderHilo2ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JButton botonInicio;
    private javax.swing.JLabel infoHilo1;
    private javax.swing.JLabel infoHilo2;
    public javax.swing.JTextField mostrarHilo1;
    public javax.swing.JTextField mostrarHilo2;
    private javax.swing.JButton reanudarHilo1;
    private javax.swing.JButton reanudarHilo2;
    private javax.swing.JButton suspenderHilo1;
    private javax.swing.JButton suspenderHilo2;
    // End of variables declaration//GEN-END:variables
}
