package ventanas;
import Main.Cliente;
/**
 *
 * @author Thony
 */
public class UI_A extends javax.swing.JFrame {

    /**
     * Creates new form UI_A
     */
    public UI_A() {
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

        valorTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        valorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTextFieldActionPerformed(evt);
            }
        });

        buscarLibroButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscarLibroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N
        buscarLibroButton.setText("Buscar libro");
        buscarLibroButton.setActionCommand("");
        buscarLibroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLibroButtonActionPerformed(evt);
            }
        });

        bibliotecaComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bibliotecaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biblioteca A", "Biblioteca B", "Biblioteca C" }));

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

        resultadoTextArea.setColumns(20);
        resultadoTextArea.setRows(5);
        jScrollPane1.setViewportView(resultadoTextArea);

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

        tituloPanel.setBackground(new java.awt.Color(0, 0, 0));

        tituloLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Biblioteca A");
        tituloPanel.add(tituloLabel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        libroLabel.setBackground(new java.awt.Color(255, 255, 255));
        libroLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        libroLabel.setForeground(new java.awt.Color(255, 51, 51));
        libroLabel.setText("Libro o autor");
        jPanel1.add(libroLabel);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(bibliotecaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(buscarLibroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(buscarAutorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(270, 270, 270)
                            .addComponent(cerrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(bibliotecaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buscarLibroButton)
                                .addComponent(buscarAutorButton))
                            .addGap(9, 9, 9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(cerrarButton))
                        .addComponent(jLabel1))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTextFieldActionPerformed

    // se ejecuta este metodo al presionar 'Buscar Libro'
    private void buscarLibroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLibroButtonActionPerformed
        // se instancia un objeto cliente
        Cliente cliente = new Cliente();
        
        // se obtiene la biblioteca seleccionada del Combo Box
        String biblio = this.bibliotecaComboBox.getSelectedItem().toString();

        // se cambia el mensaje a enviar al cliente
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

        // se ejecuta el cliente enviando el valor escrito, biblioteca seleccionada y tipo de peticion
        String res = cliente.connectServer(this.valorTextField.getText(),biblio,"libro");
        
        // se muestra el resultado en un 'Text Area'
        resultadoTextArea.setText(res);
    }//GEN-LAST:event_buscarLibroButtonActionPerformed

    private void buscarAutorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAutorButtonActionPerformed
        // se instancia un objeto cliente
        Cliente cliente = new Cliente();
        
        // se obtiene la biblioteca seleccionada del Combo Box
        String biblio = this.bibliotecaComboBox.getSelectedItem().toString();

        // se cambia el mensaje a enviar al cliente
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

        // se ejecuta el cliente enviando el valor escrito, biblioteca seleccionada y tipo de peticion
        String res = cliente.connectServer(this.valorTextField.getText(),biblio,"autor");
        
        // se muestra el resultado en un 'Text Area'
        resultadoTextArea.setText(res);
    }//GEN-LAST:event_buscarAutorButtonActionPerformed

    // se ejecuta este metodo al presionar el botón 'Salir'
    private void cerrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarButtonActionPerformed
        // se cierra la ventana
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
            java.util.logging.Logger.getLogger(UI_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // se crea y se muestra el form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_A().setVisible(true);
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
