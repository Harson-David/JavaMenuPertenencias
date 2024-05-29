
package com.mycompany.proyectofinaldetrimestreharsondelahoztps36;


import Login.LoginInicio;

import javax.swing.SwingUtilities;


public class ProyectoFinalAPP {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginInicio mainMenu = new LoginInicio();
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        });
    }
    
    
}
