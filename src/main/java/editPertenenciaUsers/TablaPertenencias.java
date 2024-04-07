package editPertenenciaUsers;

import AgregarPertenencias.RegistrarPertenencia;
import Login.AdminLogin;
import Login.AprendizLogin;
import Login.ExternoLogin;
import Login.FuncionarioLogin;
import Login.InstructorLogin;
import Login.LoginEntradaUsers;
import Models.Bitacora;
import Models.BitacoraDAO;
import Models.Pertenencias;
import Models.PertenenciasDAO;
import Views.BitacoraPanelTest;
import editPertenenciaUsers.EditarPertenencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

public class TablaPertenencias extends JFrame {

    private final String rol = LoginEntradaUsers.tipoUsuario;
    private int userId = LoginEntradaUsers.userId;
    private JTable table;
    private DefaultTableModel model;

    public TablaPertenencias() {
        initComponents();
        createTable();
        loadPertenencias();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tabla de Pertenencias");
        setSize(1920, 780);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();

        JButton verBitacoraButton = new JButton("Agregar Horas y Fechas Ingreso-Salida");
        buttonPanel.add(verBitacoraButton);
        verBitacoraButton.addActionListener(e -> showBitacoraTable());

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        scrollPane.setViewportView(table);

        JButton addButton = new JButton("Agregar Pertenencia");
        JButton getoutButton = new JButton("Sacar Pertenencia");
        JButton readdButton = new JButton("Reintregrar Pertenencia");
        JButton editButton = new JButton("Editar Pertenencia");
        JButton deleteButton = new JButton("Eliminar Pertenencia");
        JButton backButton = new JButton("Volver al Menú Principal");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addPertenencia());
        getoutButton.addActionListener(e -> getoutPertenencia());
        readdButton.addActionListener(e -> readdPertenencia());
        editButton.addActionListener(e -> editPertenencia());
        deleteButton.addActionListener(e -> deletePertenencia());
        backButton.addActionListener(e -> goBackToMainMenu());
    }

public void loadPertenencias() {
    model.setRowCount(0);
    // Verificar el tipo de usuario y realizar operaciones correspondientes
    switch (rol) {
        case "ADMINISTRADOR":
            // Obtener las pertenencias asociadas al ID del administrador
            List<Pertenencias> pertenenciasAdministrador = PertenenciasDAO.findByUserAndType(userId, rol);
            // Mostrar las pertenencias en la tabla
            populateTable(pertenenciasAdministrador);
            break;
        case "APRENDIZ":
        case "INSTRUCTOR":
        case "FUNCIONARIO":
        case "EXTERNO":
            // Obtener las pertenencias asociadas al ID del usuario
            List<Pertenencias> pertenenciasUsuario = PertenenciasDAO.findByUserAndType(userId, rol);
            // Mostrar las pertenencias en la tabla
            populateTable(pertenenciasUsuario);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Rol no reconocido");
            break;
    }
}

    public void setUserId(int userId) {
        this.userId = userId;
    }


    private void populateTable(List<Pertenencias> pertenencias) {
        model.setRowCount(0);
        for (Pertenencias pertenencia : pertenencias) {
            // Obtener la lista de bitácoras asociadas a esta pertenencia
            List<Bitacora> bitacoras = BitacoraDAO.findByPertenenciaId(pertenencia.getPertenencia_id());

            // Iterar sobre las bitácoras para agregar sus datos a la tabla
            for (Bitacora bitacora : bitacoras) {
                model.addRow(new Object[]{
                        pertenencia.getPertenencia_id(),
                        pertenencia.getTipo(),
                        pertenencia.getDescripcion(),
                        pertenencia.getUserId(),
                        bitacora.getBitacoraID(), // ID de la bitácora
                        bitacora.getFechaIngreso(), // Fecha de ingreso
                        bitacora.getHoraEntrada(), // Hora de entrada
                        bitacora.getHoraSalida(), // Hora de salida
                        bitacora.getTipo() // Tipo de la bitácora
                });
            }
        }
    }

    private void addPertenencia() {
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }

    private void getoutPertenencia() {
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }

    private void readdPertenencia() {
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }

    private void editPertenencia() {
        EditarPertenencia edit = new EditarPertenencia();
        edit.setLocationRelativeTo(null);
        edit.setVisible(true);
        dispose();
    }

    private void deletePertenencia() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String pertenenciaId = (String) table.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta pertenencia?", "Eliminar Pertenencia", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                PertenenciasDAO.delete(pertenenciaId);
                loadPertenencias();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pertenencia para eliminar.");
        }
    }

    private void goBackToMainMenu() {
        switch (rol) {
            case "APRENDIZ" -> {
                AprendizLogin aprendizLogin = new AprendizLogin();
                aprendizLogin.setLocationRelativeTo(null);
                aprendizLogin.setVisible(true);
                dispose();
            }
            case "INSTRUCTOR" -> {
                InstructorLogin log = new InstructorLogin();
                log.setLocationRelativeTo(null);
                log.setVisible(true);
                dispose();
            }
            case "FUNCIONARIO" -> {
                FuncionarioLogin fun = new FuncionarioLogin();
                fun.setLocationRelativeTo(null);
                fun.setVisible(true);
                dispose();
            }
            case "EXTERNO" -> {
                ExternoLogin ext = new ExternoLogin();
                ext.setLocationRelativeTo(null);
                ext.setVisible(true);
                dispose();
            }
            case "ADMINISTRADOR" -> {
                AdminLogin adm = new AdminLogin();
                adm.setLocationRelativeTo(null);
                adm.setVisible(true);
                dispose();
            }
            default ->
                    JOptionPane.showMessageDialog(null, "Rol no reconocido");
        }
    }

    private void createTable() {
        model = new DefaultTableModel();
        model.addColumn("ID de Pertenencia");
        model.addColumn("Tipo");
        model.addColumn("Descripción");
        model.addColumn("ID de Usuario");

        // Agregar las columnas de la Bitácora
        model.addColumn("ID de Bitácora");
        model.addColumn("Fecha");
        model.addColumn("Hora de Entrada");
        model.addColumn("Hora de Salida");
        model.addColumn("Tipo");

        table.setModel(model);
        // Ocultar la columna de ID de Bitácora
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(4).setWidth(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TablaPertenencias pertenenciasPanel = new TablaPertenencias();
            pertenenciasPanel.setVisible(true);
        });

    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public JButton getAddButton() {
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> addPertenencia());
        return addButton;
    }

    public JButton getEditButton() {
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(e -> editPertenencia());
        return editButton;
    }

    public JButton getDeleteButton() {
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deletePertenencia());
        return deleteButton;
    }

    public JTable getTable() {
        return table;
    }

    private void showBitacoraTable() {
        BitacoraPanelTest bitacoraPanelTest = new BitacoraPanelTest();
        bitacoraPanelTest.setLocationRelativeTo(null);
        bitacoraPanelTest.setVisible(true);
        dispose();
    }
}
