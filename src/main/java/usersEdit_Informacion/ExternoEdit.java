/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usersEdit_Informacion;

import Controllers.ControllerUsers;
import Login.ExternoLogin;
import Login.LoginEntradaUsers;
import Models.Users;
import Views.UsersPanelTest;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ExternoEdit extends javax.swing.JFrame {

    ControllerUsers user;

    private int userId = LoginEntradaUsers.userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ExternoEdit(int userId) {
        initComponents();
        user = new ControllerUsers();
        userID.setVisible(false);
        // Asignar el ID del usuario recibido como parámetro al campo userID
        userID.setText(String.valueOf(userId));
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

        jPanel3 = new javax.swing.JPanel();
        label27 = new java.awt.Label();
        label29 = new java.awt.Label();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        label36 = new java.awt.Label();
        label37 = new java.awt.Label();
        label38 = new java.awt.Label();
        label39 = new java.awt.Label();
        actualizar = new java.awt.Button();
        button2 = new java.awt.Button();
        nom = new javax.swing.JTextField();
        lugarProc = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        numCont = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        contra = new javax.swing.JTextField();
        label14 = new java.awt.Label();
        mail = new javax.swing.JTextField();
        tipoDoc = new javax.swing.JComboBox<>();
        userID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        label27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label27.setText("Tipo de Documento de Identidad");

        label29.setText("CONTRASEÑA");

        label30.setText("NOMBRES");

        label31.setText("APELLIDOS");

        label36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label36.setText("Lugar de Procedencia");

        label37.setText("NUMERO DE CONTACTO");

        label38.setText("DIRECCION");

        label39.setText("EMAIL");

        actualizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        actualizar.setLabel("ACTUALIZAR");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        button2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button2.setLabel("Cancelar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        nom.setBackground(new java.awt.Color(204, 204, 204));
        nom.setForeground(new java.awt.Color(0, 0, 0));

        lugarProc.setBackground(new java.awt.Color(204, 204, 204));
        lugarProc.setForeground(new java.awt.Color(0, 0, 0));
        lugarProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugarProcActionPerformed(evt);
            }
        });

        dir.setBackground(new java.awt.Color(204, 204, 204));
        dir.setForeground(new java.awt.Color(0, 0, 0));

        numCont.setBackground(new java.awt.Color(204, 204, 204));
        numCont.setForeground(new java.awt.Color(0, 0, 0));
        numCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numContActionPerformed(evt);
            }
        });

        ape.setBackground(new java.awt.Color(204, 204, 204));
        ape.setForeground(new java.awt.Color(0, 0, 0));

        contra.setBackground(new java.awt.Color(204, 204, 204));
        contra.setForeground(new java.awt.Color(0, 0, 0));

        label14.setAlignment(java.awt.Label.CENTER);
        label14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label14.setForeground(new java.awt.Color(0, 0, 0));
        label14.setText("ACTUALIZAR EXTERNO");

        mail.setBackground(new java.awt.Color(204, 204, 204));
        mail.setForeground(new java.awt.Color(0, 0, 0));
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        tipoDoc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "TI", "CE", "PASAPORTE" }));
        tipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocActionPerformed(evt);
            }
        });

        userID.setBackground(new java.awt.Color(255, 255, 255));
        userID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userID.setForeground(new java.awt.Color(0, 0, 0));
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numCont, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(186, 186, 186))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(contra)
                                            .addGap(97, 97, 97)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mail)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(97, 97, 97)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lugarProc))
                                        .addComponent(dir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)
                                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lugarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(numCont, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        try {
            int num = Integer.parseInt(userID.getText());
            String tipoDocumento = tipoDoc.getSelectedItem().toString();
            String contrasena = contra.getText();
            String nombres = nom.getText();
            String apellidos = ape.getText();
            int numContacto = Integer.parseInt(numCont.getText());
            String direccion = dir.getText();
            String email = mail.getText();
            String lugar = lugarProc.getText();
            Users.UserRole userRole = Users.UserRole.EXTERNO;
            Users.UserTypeDocument userTypeDocument = Users.UserTypeDocument.valueOf(tipoDocumento);

            Users updateUser = new Users(num, userTypeDocument, userRole, contrasena, nombres, apellidos, numContacto, direccion, email, lugar);
            user.updateExterno(updateUser);

            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
            UsersPanelTest usersPanel = new UsersPanelTest();
            usersPanel.setLocationRelativeTo(null);
            usersPanel.setVisible(true);
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para el número de documento y número de contacto.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + e.getMessage());
        }

    }//GEN-LAST:event_actualizarActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        UsersPanelTest usersPanel = new UsersPanelTest();
        usersPanel.setLocationRelativeTo(null);
        usersPanel.setVisible(true);
        dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void lugarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugarProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugarProcActionPerformed

    private void numContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numContActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numContActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void tipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocActionPerformed
        TipoDocumento selectedDocumentType = TipoDocumento.valueOf((String) tipoDoc.getSelectedItem());
        List<TipoDocumento> validDocumentTypes = Arrays.asList(TipoDocumento.CC, TipoDocumento.TI, TipoDocumento.CE, TipoDocumento.PASAPORTE);

        if (validDocumentTypes.contains(selectedDocumentType)) {
            System.out.println("Documento válido: " + selectedDocumentType);
        } else {
            System.out.println("Documento inválido");
        }
    }//GEN-LAST:event_tipoDocActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

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
            java.util.logging.Logger.getLogger(ExternoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExternoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExternoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExternoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExternoEdit userextEdit = new ExternoEdit(LoginEntradaUsers.userId);
                userextEdit.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button actualizar;
    private javax.swing.JTextField ape;
    private java.awt.Button button2;
    private javax.swing.JTextField contra;
    private javax.swing.JTextField dir;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label14;
    private java.awt.Label label27;
    private java.awt.Label label29;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label36;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private javax.swing.JTextField lugarProc;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numCont;
    private javax.swing.JComboBox<String> tipoDoc;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
}
