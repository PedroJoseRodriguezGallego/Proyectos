package CarreraCaballos;

import java.util.Observable;
import java.util.Observer;

public class InterfazPiloto extends javax.swing.JFrame implements Observer
{
    private Thread[] hilos;
    
    public InterfazPiloto() 
    {
        setTitle("Carrera de caballos PJRG");
	setLocationRelativeTo(null);
	setResizable(false);
        
        hilos = new Thread[3];
        
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCarrera = new javax.swing.JButton();
        barraCaballo1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        infoCaballo1 = new javax.swing.JLabel();
        sliderCaballo1 = new javax.swing.JSlider();
        hiloGanador = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barraCaballo2 = new javax.swing.JProgressBar();
        infoCaballo2 = new javax.swing.JLabel();
        sliderCaballo2 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        barraCaballo3 = new javax.swing.JProgressBar();
        infoCaballo3 = new javax.swing.JLabel();
        sliderCaballo3 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonCarrera.setText("Comenzar Carrera");
        botonCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarreraActionPerformed(evt);
            }
        });

        barraCaballo1.setStringPainted(true);

        jLabel1.setText("HILO 1");

        infoCaballo1.setText("Prioridad : x");

        sliderCaballo1.setMaximum(10);
        sliderCaballo1.setMinimum(1);
        sliderCaballo1.setMinorTickSpacing(1);
        sliderCaballo1.setPaintLabels(true);
        sliderCaballo1.setPaintTicks(true);
        sliderCaballo1.setValue(5);

        hiloGanador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hiloGanador.setText("HILO GANADOR : x");

        jLabel4.setText("HILO 2");

        barraCaballo2.setStringPainted(true);

        infoCaballo2.setText("Prioridad : x");

        sliderCaballo2.setMaximum(10);
        sliderCaballo2.setMinimum(1);
        sliderCaballo2.setMinorTickSpacing(1);
        sliderCaballo2.setPaintLabels(true);
        sliderCaballo2.setPaintTicks(true);
        sliderCaballo2.setValue(5);

        jLabel2.setText("HILO 3");

        barraCaballo3.setStringPainted(true);

        infoCaballo3.setText("Prioridad : x");

        sliderCaballo3.setMaximum(10);
        sliderCaballo3.setMinimum(1);
        sliderCaballo3.setMinorTickSpacing(1);
        sliderCaballo3.setPaintTicks(true);
        sliderCaballo3.setValue(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(hiloGanador))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(botonCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sliderCaballo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(infoCaballo3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sliderCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(infoCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addComponent(barraCaballo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sliderCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(infoCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(barraCaballo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barraCaballo3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(botonCarrera)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(infoCaballo1))
                            .addComponent(sliderCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barraCaballo1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(sliderCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(infoCaballo2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(infoCaballo3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barraCaballo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderCaballo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraCaballo3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(hiloGanador)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarreraActionPerformed
        botonCarrera.setEnabled(false);
        hiloGanador.setText("HILO GANADOR : x");
        
        for (int i = 0; i < hilos.length; i++)
        {
            Hilo c = new Hilo(Integer.toString(i + 1));
            c.addObserver(this);
            hilos[i] = new Thread(c);
            hilos[i].start();
        }
        
        hilos[0].setPriority(sliderCaballo1.getValue());
        hilos[1].setPriority(sliderCaballo2.getValue());
        hilos[2].setPriority(sliderCaballo3.getValue());
        
        infoCaballo1.setText( "Prioridad : " + hilos[0].getPriority());
        infoCaballo2.setText( "Prioridad : " + hilos[1].getPriority());
        infoCaballo3.setText( "Prioridad : " + hilos[2].getPriority());
    }//GEN-LAST:event_botonCarreraActionPerformed


    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(InterfazPiloto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPiloto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPiloto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPiloto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new InterfazPiloto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraCaballo1;
    private javax.swing.JProgressBar barraCaballo2;
    private javax.swing.JProgressBar barraCaballo3;
    private javax.swing.JButton botonCarrera;
    private javax.swing.JLabel hiloGanador;
    private javax.swing.JLabel infoCaballo1;
    private javax.swing.JLabel infoCaballo2;
    private javax.swing.JLabel infoCaballo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider sliderCaballo1;
    private javax.swing.JSlider sliderCaballo2;
    private javax.swing.JSlider sliderCaballo3;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg)
    {
        Hilo caballo = (Hilo) o;
        int porcentaje = (int) arg;

        switch (caballo.nombre)
        {
            case "1" : barraCaballo1.setValue(porcentaje);
            break;

            case "2" : barraCaballo2.setValue(porcentaje);
            break;

            case "3" : barraCaballo3.setValue(porcentaje);
            break;
        }

        if(porcentaje >= 100)
        {
            for (int i = 0; i < hilos.length; i++)
            {
                hilos[i].interrupt();
            }
           
           botonCarrera.setEnabled(true);
           hiloGanador.setText("HILO GANADOR : Caballo " + caballo.nombre);
        }
    }

}