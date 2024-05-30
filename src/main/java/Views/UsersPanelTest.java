package Views;

import Login.SelectRol;
import Login.SelectUser;
import Models.MenuTest;
import Models.Users;
import Models.UsersDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;
import usersEdit_Informacion.AdminEdit;
import usersEdit_Informacion.AprendizEdit;
import usersEdit_Informacion.ExternoEdit;
import usersEdit_Informacion.FuncionarioEdit;
import usersEdit_Informacion.InstructorEdit;
import usersEdit_Informacion.UserAdminEdit;
import usersEdit_Informacion.UserAprendizEdit;
import usersEdit_Informacion.UserExternoEdit;
import usersEdit_Informacion.UserFuncionarioEdit;
import usersEdit_Informacion.UserInstructorEdit;

public class UsersPanelTest extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public UsersPanelTest() {
        initComponents();
        createTable();
        loadUsers();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        scrollPane.setViewportView(table);

        JButton addButton = new JButton("Agregar");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Eliminar");
        JButton backButton = new JButton("Volver al Menú Principal");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addUser());
        editButton.addActionListener(e -> editUser());
        deleteButton.addActionListener(e -> deleteUser());
        backButton.addActionListener(e -> goBackToMainMenu());
    }

    public void populateTable(List<Users> users) {
        model.setRowCount(0);
        for (Users user : users) {
            model.addRow(new Object[]{
                user.getUser_id(),
                user.getUserRol(),
                user.getTypeDocument(),
                user.getPassword(),
                user.getName(),
                user.getLastName(),
                user.getNumContact(),
                user.getAddress(),
                user.getEmail(),
                user.getJornada(),
                user.getTipoFormacion(),
                user.getCentroFormacion(),
                user.getCoordinacion(),
                user.getNumFicha(),
                user.getFormacion(),
                user.getCargoActual(),
                user.getLugarProcedencia()
            });
        }
    }

    private void addUser() {
        try {
            SelectUser rol = new SelectUser();
            rol.setLocationRelativeTo(null);
            rol.setVisible(true);
            dispose();
        } catch (Exception ex) {
            System.err.println("Error al abrir la ventana EleccionRol: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void editUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int userId = (int) table.getValueAt(selectedRow, 0);

            Map<String, Object> userAndRole = UsersDAO.findUserAndRole(userId);

            if (userAndRole != null) {
                Users.UserRole selectedRole = (Users.UserRole) userAndRole.get("role");

                switch (selectedRole) {
                    case APRENDIZ -> {
                        AprendizEdit aprendiz = new AprendizEdit(userId);
                        aprendiz.setLocationRelativeTo(null);
                        aprendiz.setVisible(true);
                        dispose();
                    }
                    case INSTRUCTOR -> {
                        InstructorEdit instructor = new InstructorEdit(userId);
                        instructor.setLocationRelativeTo(null);
                        instructor.setVisible(true);
                        dispose();
                    }
                    case FUNCIONARIO -> {
                        FuncionarioEdit fun = new FuncionarioEdit(userId);
                        fun.setLocationRelativeTo(null);
                        fun.setVisible(true);
                        dispose();
                    }
                    case EXTERNO -> {
                        ExternoEdit externo = new ExternoEdit(userId);
                        externo.setLocationRelativeTo(null);
                        externo.setVisible(true);
                        dispose();
                    }
                    case ADMINISTRADOR -> {
                        AdminEdit admin = new AdminEdit(userId);
                        admin.setLocationRelativeTo(null);
                        admin.setVisible(true);
                        dispose();
                    }
                    default ->
                        System.out.println("No hay una vista específica para este rol.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró información del usuario.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario para editar.");
        }
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int userId = (int) table.getValueAt(selectedRow, 0);

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este usuario?",
                    "Eliminar Usuario", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                UsersDAO.delete(userId);
                loadUsers();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario para eliminar.");
        }
    }

    private void goBackToMainMenu() {
        MenuTest mainMenu = new MenuTest();
        mainMenu.setVisible(true);
        dispose();
    }

    private void createTable() {
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Rol");
        model.addColumn("Tipo Documento");
        model.addColumn("Contraseña");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Num. Contacto");
        model.addColumn("Dirección");
        model.addColumn("Email");
        model.addColumn("Jornada");
        model.addColumn("Tipo Formación");
        model.addColumn("Centro Formación");
        model.addColumn("Coordinación");
        model.addColumn("Num. Ficha");
        model.addColumn("Formación");
        model.addColumn("Cargo Actual");
        model.addColumn("Lugar Procedencia");
        table.setModel(model);
    }

    private void loadUsers() {
        model.setRowCount(0);
        List<Users> users = UsersDAO.findAll();
        populateTable(users);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsersPanelTest usersPanel = new UsersPanelTest();
            usersPanel.setVisible(true);
        });
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public int getSelectedUserId() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            return (int) table.getValueAt(selectedRow, 0);
        } else {
            return -1;
        }
    }

    public Users getUserData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int userId = (int) table.getValueAt(selectedRow, 0);
            Users user = UsersDAO.findOne(userId);
            return user;
        } else {
            return null;
        }
    }

    public JButton getAddButton() {
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> addUser());
        return addButton;
    }

    public JButton getEditButton() {
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(e -> editUser());
        return editButton;
    }

    public JButton getDeleteButton() {
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deleteUser());
        return deleteButton;
    }

}
