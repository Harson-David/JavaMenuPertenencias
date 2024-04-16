package Models;

import Views.BitacoraPanelTest;
import Views.PertenenciasPanelTest;
import Views.ProgramasPanelTest;
import Views.UsersPanelTest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Controllers.ControllerBitacora;
//import Controllers.ControllerPertenencias;
//import Controllers.ControllerProgramas;
//import Controllers.ControllerUsers;
import Login.AdminLogin;
import Login.SelectRol;
import RegistroTipoUsuario.AdminRegistro;
import RegistroTipoUsuario.AprendizRegistro;
import RegistroTipoUsuario.ExternoRegistro;
import RegistroTipoUsuario.FuncionarioRegistro;
import RegistroTipoUsuario.InstructorRegistro;
import editPertenenciaUsers.TabladePertenenciasAdmin;

public class MenuTest extends JFrame implements ActionListener {

    public MenuTest() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Menú Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        JButton usersButton = new JButton("Usuarios");
        usersButton.addActionListener(this);
        panel.add(usersButton);

        JButton programasButton = new JButton("Programas");
        programasButton.addActionListener(this);
        panel.add(programasButton);

        JButton bitacoraButton = new JButton("Bitácora");
        bitacoraButton.addActionListener(this);
        panel.add(bitacoraButton);

        JButton pertenenciasButton = new JButton("Pertenencias");
        pertenenciasButton.addActionListener(this);
        panel.add(pertenenciasButton);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(this);
        panel.add(salirButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Opciones Disponibles", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(titleLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Usuarios" -> showUsersPanel();
            case "Programas" -> showProgramasPanel();
            case "Bitácora" -> showBitacoraPanel();
            case "Pertenencias" -> showPertenenciasPanel();
            case "Salir" -> {
                AdminLogin adm = new AdminLogin();
                adm.setLocationRelativeTo(null);
                adm.setVisible(true);
                dispose();
            }
        }
    }

    
    
        private void showUsersPanel() {
        UsersPanelTest usersPanel = new UsersPanelTest();
        usersPanel.setLocationRelativeTo(null);
        usersPanel.setVisible(true);
        dispose();
    }

    private void showProgramasPanel() {
        ProgramasPanelTest programasPanel = new ProgramasPanelTest();
        programasPanel.setVisible(true);
        dispose();
    }

    private void showBitacoraPanel() {
        BitacoraPanelTest bitacoraPanel = new BitacoraPanelTest();
        bitacoraPanel.setVisible(true);
        dispose();
    }

    private void showPertenenciasPanel() {
        TabladePertenenciasAdmin pertenenciasPanel = new TabladePertenenciasAdmin();
        pertenenciasPanel.setVisible(true);
        dispose();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MenuTest().setVisible(true);
        });
    }
}
