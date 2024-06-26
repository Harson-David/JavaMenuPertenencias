package Login;

import AgregarPertenencias.RegistrarPertenencia;
import DevolverPertenencia.DevolverPertenencia;
import static Login.LoginEntradaUsers.userId;
import Models.MenuTest;
import editPertenenciaUsers.TablaPertenencias;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import usersEdit_Informacion.UserAdminEdit;

import Login.LoginEntradaUsers.TipoDocumento;

/**
 *
 * @author Administrador
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form userAdminLogin
     */
    public AdminLogin() {
        initComponents();
    }

    private String tipoDocumento;

    public void setTipoDocumentoSilently(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

   
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        if (isVisible()) {
            TipoDocumento.setText("Tipo de documento: " + tipoDocumento);
        }
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button3 = new java.awt.Button();
        label1 = new java.awt.Label();
        button10 = new java.awt.Button();
        button8 = new java.awt.Button();
        button11 = new java.awt.Button();
        TipoDocumento = new java.awt.Label();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        button1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button1.setLabel("Cerrar Sesion");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(102, 255, 102));
        button3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button3.setLabel("REGISTROS");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("ADMINISTRADOR SENA");

        button10.setBackground(new java.awt.Color(51, 255, 204));
        button10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        button10.setLabel("ACTUALIZAR INFORMACION");
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(0, 153, 153));
        button8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        button8.setLabel("GUARDAR PERTENENCIA");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button11.setBackground(new java.awt.Color(0, 51, 51));
        button11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button11.setForeground(new java.awt.Color(255, 255, 255));
        button11.setLabel("MIS PERTENENCIAS");
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(TipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(TipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(78, 78, 78)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }//GEN-LAST:event_button8ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        SwingUtilities.invokeLater(() -> {
            MenuTest mainMenu = new MenuTest();
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_button3ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        int userId = LoginEntradaUsers.userId;

        UserAdminEdit edit = new UserAdminEdit(userId);
        edit.setLocationRelativeTo(null);
        edit.setUserId(userId);
        edit.setVisible(true);
        dispose();
    }//GEN-LAST:event_button10ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
    
        TablaPertenencias tabla = new TablaPertenencias();
        int userId = LoginEntradaUsers.userId;
        tabla.setUserId(userId);
        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);
        dispose();
    }//GEN-LAST:event_button11ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        LoginInicio user = new LoginInicio();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "Sesion Cerrada con exito.");


    }//GEN-LAST:event_button1ActionPerformed


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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminLogin().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label TipoDocumento;
    private java.awt.Button button1;
    private java.awt.Button button10;
    private java.awt.Button button11;
    private java.awt.Button button3;
    private java.awt.Button button8;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
