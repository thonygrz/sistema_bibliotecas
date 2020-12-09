package ventanas;

import Main.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thony
 */
public class UI_B extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    public UI_B() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valorTextField = new javax.swing.JTextField();
        buscarLibroButton = new javax.swing.JButton();
        bibliotecaComboBox = new javax.swing.JComboBox<>();
        buscarAutorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoTextArea = new javax.swing.JTextArea();
        cerrarButton = new javax.swing.JButton();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        libroLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valorTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        valorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(valorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, 30));

        buscarLibroButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscarLibroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N
        buscarLibroButton.setText("Buscar libro");
        buscarLibroButton.setActionCommand("");
        buscarLibroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLibroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarLibroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 150, -1));
        buscarLibroButton.getAccessibleContext().setAccessibleName("buscarButton");

        bibliotecaComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bibliotecaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biblioteca A", "Biblioteca B", "Biblioteca C" }));
        getContentPane().add(bibliotecaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, 30));

        buscarAutorButton.setBackground(new java.awt.Color(204, 204, 204));
        buscarAutorButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscarAutorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario (2).png"))); // NOI18N
        buscarAutorButton.setText("Buscar autor");
        buscarAutorButton.setActionCommand("");
        buscarAutorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAutorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarAutorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 160, -1));

        resultadoTextArea.setColumns(20);
        resultadoTextArea.setRows(5);
        jScrollPane1.setViewportView(resultadoTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 260, 130));

        cerrarButton.setBackground(new java.awt.Color(204, 204, 204));
        cerrarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cerrarButton.setForeground(new java.awt.Color(255, 0, 0));
        cerrarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        cerrarButton.setText("Salir");
        cerrarButton.setActionCommand("");
        cerrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cerrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 90, -1));

        tituloPanel.setBackground(new java.awt.Color(0, 0, 0));

        tituloLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Biblioteca B");
        tituloPanel.add(tituloLabel);

        getContentPane().add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        libroLabel.setBackground(new java.awt.Color(255, 255, 255));
        libroLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        libroLabel.setForeground(new java.awt.Color(255, 51, 51));
        libroLabel.setText("Libro o autor");
        jPanel1.add(libroLabel);
        libroLabel.getAccessibleContext().setAccessibleName("labelLibro");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleName("labelFondo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTextFieldActionPerformed

    private void buscarLibroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLibroButtonActionPerformed
        // TODO add your handling code here:
        Cliente cliente = new Cliente();
        String biblio = this.bibliotecaComboBox.getSelectedItem().toString();
        
        switch (biblio) {
            case "Biblioteca A": 
                    biblio = "A";
                    break;
            case "Biblioteca B": 
                    biblio = "B";
                    break;
            case "Biblioteca C": 
                    biblio = "C";
                    break;
            default: 
                    biblio = "A";
                    break;
        }
        
        String res = cliente.connectServer(this.valorTextField.getText(),biblio,"libro");
        resultadoTextArea.setText(res);
    }//GEN-LAST:event_buscarLibroButtonActionPerformed

    private void buscarAutorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAutorButtonActionPerformed
        // TODO add your handling code here:
        Cliente cliente = new Cliente();
        String biblio = this.bibliotecaComboBox.getSelectedItem().toString();
        
        switch (biblio) {
            case "Biblioteca A": 
                    biblio = "A";
                    break;
            case "Biblioteca B": 
                    biblio = "B";
                    break;
            case "Biblioteca C": 
                    biblio = "C";
                    break;
            default: 
                    biblio = "A";
                    break;
        }
        
        String res = cliente.connectServer(this.valorTextField.getText(),biblio,"autor");
        resultadoTextArea.setText(res);
    }//GEN-LAST:event_buscarAutorButtonActionPerformed

    private void cerrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UI_B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_B().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bibliotecaComboBox;
    private javax.swing.JButton buscarAutorButton;
    private javax.swing.JButton buscarLibroButton;
    private javax.swing.JButton cerrarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel libroLabel;
    private javax.swing.JTextArea resultadoTextArea;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JPanel tituloPanel;
    private javax.swing.JTextField valorTextField;
    // End of variables declaration//GEN-END:variables
}