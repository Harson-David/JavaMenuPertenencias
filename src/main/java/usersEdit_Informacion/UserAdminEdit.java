/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usersEdit_Informacion;

import Controllers.ControllerUsers;
import Login.AdminLogin;
import Login.LoginEntradaUsers;
import Models.Users;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public final class UserAdminEdit extends javax.swing.JFrame {

    ControllerUsers user;

    private int userId = LoginEntradaUsers.userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserAdminEdit(int userId) {
        initComponents();
        user = new ControllerUsers();
        userID.setVisible(false);
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
        label34 = new java.awt.Label();
        label35 = new java.awt.Label();
        label37 = new java.awt.Label();
        label38 = new java.awt.Label();
        label39 = new java.awt.Label();
        button2 = new java.awt.Button();
        actualizar = new java.awt.Button();
        nom = new javax.swing.JTextField();
        coodinacion = new javax.swing.JTextField();
        cenFormacion = new javax.swing.JTextField();
        numCont = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        contra = new javax.swing.JTextField();
        ape = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        tipoDoc = new javax.swing.JComboBox<>();
        userID = new javax.swing.JTextField();
        label40 = new java.awt.Label();
        jornada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        label27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label27.setText("Tipo de Documento de Identidad");

        label29.setText("CONTRASEÑA");

        label30.setText("NOMBRES");

        label31.setText("APELLIDOS");

        label34.setText("COORDINACION");

        label35.setText("CENTRO DE FORMACION ASIGNADO");

        label37.setText("NUMERO DE CONTACTO");

        label38.setText("DIRECCION");

        label39.setText("EMAIL");

        button2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button2.setLabel("Cancelar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        actualizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        actualizar.setLabel("ACTUALIZAR");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        nom.setBackground(new java.awt.Color(204, 204, 204));
        nom.setForeground(new java.awt.Color(0, 0, 0));

        coodinacion.setBackground(new java.awt.Color(204, 204, 204));
        coodinacion.setForeground(new java.awt.Color(0, 0, 0));

        cenFormacion.setBackground(new java.awt.Color(204, 204, 204));
        cenFormacion.setForeground(new java.awt.Color(0, 0, 0));

        numCont.setBackground(new java.awt.Color(204, 204, 204));
        numCont.setForeground(new java.awt.Color(0, 0, 0));
        numCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numContActionPerformed(evt);
            }
        });

        mail.setBackground(new java.awt.Color(204, 204, 204));
        mail.setForeground(new java.awt.Color(0, 0, 0));

        dir.setBackground(new java.awt.Color(204, 204, 204));
        dir.setForeground(new java.awt.Color(0, 0, 0));

        contra.setBackground(new java.awt.Color(204, 204, 204));
        contra.setForeground(new java.awt.Color(0, 0, 0));
        contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraActionPerformed(evt);
            }
        });

        ape.setBackground(new java.awt.Color(204, 204, 204));
        ape.setForeground(new java.awt.Color(0, 0, 0));

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setText("ACTUALIZAR ADMINISTRADOR");

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

        label40.setText("DIRECCION");

        jornada.setBackground(new java.awt.Color(204, 204, 204));
        jornada.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coodinacion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cenFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numCont, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coodinacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cenFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numCont, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        AdminLogin log = new AdminLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void tipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocActionPerformed
        TipoDocumento selectedDocumentType = TipoDocumento.valueOf((String) tipoDoc.getSelectedItem());
        List<TipoDocumento> validDocumentTypes = Arrays.asList(TipoDocumento.CC, TipoDocumento.TI, TipoDocumento.CE, TipoDocumento.PASAPORTE);

        if (validDocumentTypes.contains(selectedDocumentType)) {
            System.out.println("Documento válido: " + selectedDocumentType);
        } else {
            System.out.println("Documento inválido");
        }
    }//GEN-LAST:event_tipoDocActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        try {

            int num = Integer.parseInt(userID.getText());
            String tipoDocumento = tipoDoc.getSelectedItem().toString();
            String contrasena = contra.getText();
            String nombres = nom.getText();
            String apellidos = ape.getText();
            String coordi = coodinacion.getText();
            String centroFormacion = cenFormacion.getText();
            int numContacto = Integer.parseInt(numCont.getText());
            String direccion = dir.getText();
            String email = mail.getText();
            String jor = jornada.getText();

            Users.UserRole userRole = Users.UserRole.ADMINISTRADOR;
            Users.UserTypeDocument userTypeDocument = Users.UserTypeDocument.valueOf(tipoDocumento);

            Users updateUser = new Users(num, userTypeDocument, userRole, contrasena, nombres, apellidos, numContacto, direccion, email, jor, centroFormacion, coordi);
            user.updateAdministrador(updateUser);

            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");

            AdminLogin adm = new AdminLogin();
            adm.setLocationRelativeTo(null);
            adm.setVisible(true);
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para el número de documento y número de contacto.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

    private void numContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numContActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numContActionPerformed

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
            java.util.logging.Logger.getLogger(UserAdminEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAdminEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAdminEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAdminEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserAdminEdit userAdminEdit = new UserAdminEdit(LoginEntradaUsers.userId);
                userAdminEdit.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button actualizar;
    private javax.swing.JTextField ape;
    private java.awt.Button button2;
    private javax.swing.JTextField cenFormacion;
    private javax.swing.JTextField contra;
    private javax.swing.JTextField coodinacion;
    private javax.swing.JTextField dir;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jornada;
    private java.awt.Label label27;
    private java.awt.Label label29;
    private java.awt.Label label3;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private java.awt.Label label40;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numCont;
    private javax.swing.JComboBox<String> tipoDoc;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
}
