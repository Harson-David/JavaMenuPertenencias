/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegistroTipoUsuario;

import Controllers.ControllerUsers;
import Login.LoginEntradaUsers;
import Login.LoginInicio;
import Models.Users;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author harso
 */
public class ExternoRegistro extends javax.swing.JFrame {

        ControllerUsers user;
    public ExternoRegistro() {
        initComponents();
        user = new ControllerUsers();
    }

    public enum TipoDocumento {
        CC,
        TI,
        CE,
        PASAPORTE
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JPanel();
        label27 = new java.awt.Label();
        label28 = new java.awt.Label();
        numDoc = new javax.swing.JTextField();
        label29 = new java.awt.Label();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        label36 = new java.awt.Label();
        label37 = new java.awt.Label();
        label38 = new java.awt.Label();
        label39 = new java.awt.Label();
        registrar = new java.awt.Button();
        button2 = new java.awt.Button();
        nombres = new javax.swing.JTextField();
        numContacto = new javax.swing.JTextField();
        lugarProcedencia = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        contrasena = new javax.swing.JTextField();
        label14 = new java.awt.Label();
        tipoDocumento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre.setBackground(new java.awt.Color(255, 255, 255));
        nombre.setForeground(new java.awt.Color(0, 0, 0));

        label27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label27.setText("Tipo de Documento de Identidad");

        label28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label28.setText("Numero de Documento");

        numDoc.setBackground(new java.awt.Color(204, 204, 204));
        numDoc.setForeground(new java.awt.Color(0, 0, 0));
        numDoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        label29.setText("CONTRASEÑA");

        label30.setText("NOMBRES");

        label31.setText("APELLIDOS");

        label36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label36.setText("Lugar de Procedencia");

        label37.setText("NUMERO DE CONTACTO");

        label38.setText("DIRECCION");

        label39.setText("EMAIL");

        registrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        registrar.setLabel("Registrar Externo");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        button2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button2.setLabel("Cancelar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        nombres.setBackground(new java.awt.Color(204, 204, 204));
        nombres.setForeground(new java.awt.Color(0, 0, 0));
        nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        numContacto.setBackground(new java.awt.Color(204, 204, 204));
        numContacto.setForeground(new java.awt.Color(0, 0, 0));

        lugarProcedencia.setBackground(new java.awt.Color(204, 204, 204));
        lugarProcedencia.setForeground(new java.awt.Color(0, 0, 0));
        lugarProcedencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugarProcedenciaActionPerformed(evt);
            }
        });

        direccion.setBackground(new java.awt.Color(204, 204, 204));
        direccion.setForeground(new java.awt.Color(0, 0, 0));

        mail.setBackground(new java.awt.Color(204, 204, 204));
        mail.setForeground(new java.awt.Color(0, 0, 0));

        apellidos.setBackground(new java.awt.Color(204, 204, 204));
        apellidos.setForeground(new java.awt.Color(0, 0, 0));
        apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        contrasena.setBackground(new java.awt.Color(204, 204, 204));
        contrasena.setForeground(new java.awt.Color(0, 0, 0));
        contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        label14.setAlignment(java.awt.Label.CENTER);
        label14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label14.setForeground(new java.awt.Color(0, 0, 0));
        label14.setText("EXTERNO REGISTRO");

        tipoDocumento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "TI", "CE", "PASAPORTE" }));
        tipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nombreLayout = new javax.swing.GroupLayout(nombre);
        nombre.setLayout(nombreLayout);
        nombreLayout.setHorizontalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addComponent(tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidos)
                            .addComponent(nombres))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nombreLayout.createSequentialGroup()
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        nombreLayout.setVerticalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nombreLayout.createSequentialGroup()
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(12, 12, 12)
                .addComponent(tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(nombreLayout.createSequentialGroup()
                        .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(116, 116, 116)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lugarProcedenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugarProcedenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugarProcedenciaActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
    LoginInicio user = new LoginInicio();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void tipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocumentoActionPerformed
        TipoDocumento selectedDocumentType = TipoDocumento.valueOf((String) tipoDocumento.getSelectedItem());
        List<TipoDocumento> validDocumentTypes = Arrays.asList(TipoDocumento.CC, TipoDocumento.TI, TipoDocumento.CE, TipoDocumento.PASAPORTE);

        if (validDocumentTypes.contains(selectedDocumentType)) {
            System.out.println("Documento válido: " + selectedDocumentType);
        } else {
            System.out.println("Documento inválido");
        }
    }//GEN-LAST:event_tipoDocumentoActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        int numeroDocumento = Integer.parseInt(numDoc.getText());
        Users.UserRole userRole = Users.UserRole.EXTERNO;
        String tipoDoc = tipoDocumento.getSelectedItem().toString();
        String contraseña = contrasena.getText();
        String nombre = nombres.getText();
        String apellido = apellidos.getText();
        int numCont = Integer.parseInt(numContacto.getText());
        String dir = direccion.getText();
        String email = mail.getText();
        String lp = lugarProcedencia.getText();
        


        Users.UserTypeDocument userTypeDocument = Users.UserTypeDocument.valueOf(tipoDoc);
        Users newUser = new Users(numeroDocumento, userRole, userTypeDocument, contraseña, nombre, apellido, numCont, dir, email, lp);

        user.create(newUser);
        LoginEntradaUsers user = new LoginEntradaUsers();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "Usuario Creado con exito.");
    }//GEN-LAST:event_registrarActionPerformed

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
            java.util.logging.Logger.getLogger(ExternoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExternoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExternoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExternoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExternoRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private java.awt.Button button2;
    private javax.swing.JTextField contrasena;
    private javax.swing.JTextField direccion;
    private java.awt.Label label14;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label36;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private javax.swing.JTextField lugarProcedencia;
    private javax.swing.JTextField mail;
    private javax.swing.JPanel nombre;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField numContacto;
    private javax.swing.JTextField numDoc;
    private java.awt.Button registrar;
    private javax.swing.JComboBox<String> tipoDocumento;
    // End of variables declaration//GEN-END:variables
}
