/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berkeley;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class JFrameBerkeley extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form JFrameBerkeley
     */
    String hora, minutos, segundos, ampm, segundosc1, segundosc2, segundosc3;
    int c1, c2, c3;
    Calendar calendario;
    Thread h1;
    JFrameBerkeley jfb;
    private volatile boolean running = true;
    private volatile boolean paused = false;
    private boolean flag = false;
    private final Object pauseLock = new Object();
    

    
    public JFrameBerkeley() {
       // ser = new Reloj();
        h1 = new Thread(this);
        h1.start();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelServidor = new javax.swing.JLabel();
        jLabelC1 = new javax.swing.JLabel();
        jLabelC2 = new javax.swing.JLabel();
        jLabelC3 = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAjuste = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Servidor");

        jLabel2.setText("Equipo 1");

        jLabel3.setText("Equipo 2");

        jLabel4.setText("Equipo 3");

        jLabelServidor.setText("jLabel5");

        jLabelC1.setText("00:00:00");

        jLabelC2.setText("00:00:00");

        jLabelC3.setText("00:00:00");

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        jButton1.setText("Ajustar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextAreaAjuste.setColumns(20);
        jTextAreaAjuste.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAjuste);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(Start)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelServidor)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelC1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabelC2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelC3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelServidor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelC1)
                    .addComponent(jLabelC2)
                    .addComponent(jLabelC3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
       // int seg = Integer.parseInt(segundos);
        this.c1= (int) (Math.random() * 1000); 
        this.c2= (int) (Math.random() * 1000); 
        this.c3= (int) (Math.random() * 1000); 
        flag=true;
        
    }//GEN-LAST:event_StartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a1, a2, a3, a4;
        a1=Integer.parseInt(hora+minutos+segundos);
        a2=a1+c1;
        a3=a1+c2;
        a4=a1+c3;
        int ajuste=((c1-(a1-a2)/2)+(c2-(a1-a3)/2)+(c3-(a1-a4)/2))/4;
        String aux = "TSer ="+ hora + ":" + minutos + ":" + segundos + "\n"+
                      "TC1 ="+calcularSeg(Integer.parseInt(segundos)+this.c1)+" D: "+c1+"\n"+
                       "TC2 ="+calcularSeg(Integer.parseInt(segundos)+this.c2)+" D: "+c2+"\n"+
                         "TC3 ="+calcularSeg(Integer.parseInt(segundos)+this.c3)+" D: "+c3+"\n"+
                          "D1'  "+a1+"-"+a2+"/"+2+"= "+(c1-(a1-a2)/2)+"\n"+
                          "D2'  "+a1+"-"+a3+"/"+2+"= "+(c2-(a1-a3)/2)+"\n"+
                          "D3'  "+a1+"-"+a4+"/"+2+"= "+(c3-(a1-a4)/2)+"\n"+
                          "Promedio D: "+((c1-(a1-a2)/2)+(c2-(a1-a3)/2)+(c3-(a1-a4)/2))/4+"\n"+
                           "A1: "+ajuste+" - "+(c1-(a1-a2)/2)+"= "+(ajuste-(c1-(a1-a2)/2))+"\n"+
                           "A2: "+ajuste+" - "+(c2-(a1-a3)/2)+"= "+(ajuste-(c2-(a1-a3)/2))+"\n"+
                           "A3: "+ajuste+" - "+(c3-(a1-a4)/2)+"= "+(ajuste-(c3-(a1-a4)/2))+"\n";
        //System.out.println(aux);
         this.jTextAreaAjuste.setText(aux);
         
         flag=false;
        // c3=c2=c1=Integer.parseInt(segundos); 
        //Ajuste a = new Ajuste(aux);
        //a.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(JFrameBerkeley.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameBerkeley.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameBerkeley.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameBerkeley.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameBerkeley().setVisible(true);
            }
        });
    }


    
      public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
       
      
     private String calcularSeg(int a){
         if(a>59){
          return hora + ":" + ((Integer.parseInt(minutos))+1) + ":" + (a-60);
         }      
         else
         return hora + ":" + minutos + ":" + a;
     } 
         
     
//     private int calcularSeg(int a){
//         if(a>59)
//             return a-60;
//         else
//         return a;
//     } 

    @Override
    public void run () {
        while (running){
            synchronized (pauseLock) {
                if (!running) { // may have changed while waiting to
                                // synchronize on pauseLock
                    break;
                }
                if (paused) {
                    try {
                        pauseLock.wait(); 
                    } catch (InterruptedException ex) {
                        break;
                    }
                    if (!running) { // running might have changed since we paused
                        break;
                    }
                }
            }
            // Your code here
                   Thread ct = Thread.currentThread();
            while (ct == h1) {
                calcula();
                System.out.println(hora + ":" + minutos + ":" + segundos + " " + ampm);
                this.jLabelServidor.setText(hora + ":" + minutos + ":" + segundos);
                if(flag){
                    this.jLabelC1.setText(calcularSeg(Integer.parseInt(segundos)+this.c1));
                    this.jLabelC2.setText(calcularSeg(Integer.parseInt(segundos)+this.c2));
                    this.jLabelC3.setText(calcularSeg(Integer.parseInt(segundos)+this.c3));
//                    this.jLabelC1.setText(hora + ":" + minutos + ":" + calcularSeg(Integer.parseInt(segundos)+this.c1));
//                    this.jLabelC2.setText(hora + ":" + minutos + ":" + calcularSeg(Integer.parseInt(segundos)+this.c2));
//                    this.jLabelC3.setText(hora + ":" + minutos + ":" + calcularSeg(Integer.parseInt(segundos)+this.c3));
                }else{
                    this.jLabelC1.setText(hora + ":" + minutos + ":" + segundos);
                    this.jLabelC2.setText(hora + ":" + minutos + ":" + segundos);
                    this.jLabelC3.setText(hora + ":" + minutos + ":" + segundos);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    
    public void stop() {
        running = false;
        // you might also want to interrupt() the Thread that is 
        // running this Runnable, too, or perhaps call:
        resume();
        // to unblock
    }

    public void pause() {
        // you may want to throw an IllegalStateException if !running
        paused = true;
    }

    public void resume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll(); // Unblocks thread
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Start;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelC1;
    private javax.swing.JLabel jLabelC2;
    private javax.swing.JLabel jLabelC3;
    private javax.swing.JLabel jLabelServidor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAjuste;
    // End of variables declaration//GEN-END:variables

   
}
