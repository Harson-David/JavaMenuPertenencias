package editPertenenciaUsers;

import Login.AdminLogin;
import Login.AprendizLogin;
import Login.ExternoLogin;
import Login.FuncionarioLogin;
import Login.InstructorLogin;
import Login.LoginEntradaUsers;
import Models.Pertenencias;
import Models.PertenenciasDAO;
import Views.BitacoraPanelTest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.UUID;

public class TablaPertenencias extends JFrame {

    private final String rol = LoginEntradaUsers.tipoUsuario;
    private final int userId = LoginEntradaUsers.userId;
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
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();

        JButton verBitacoraButton = new JButton("Agregar Horas y Fechas Ingreso-Salida");
        buttonPanel.add(verBitacoraButton);
        verBitacoraButton.addActionListener(e -> showBitacoraTable());

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        scrollPane.setViewportView(table);

        JButton addButton = new JButton("Agregar");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Eliminar");
        JButton backButton = new JButton("Volver al Menú Principal");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addPertenencia());
        editButton.addActionListener(e -> editPertenencia());
        deleteButton.addActionListener(e -> deletePertenencia());
        backButton.addActionListener(e -> goBackToMainMenu());
    }

    public void loadPertenenciasByUser(int userId) {
        model.setRowCount(0);
        List<Pertenencias> pertenencias = PertenenciasDAO.findByUserAndType(userId, rol);
        populateTable(pertenencias);
    }

    private void populateTable(List<Pertenencias> pertenencias) {
        model.setRowCount(0);
        for (Pertenencias pertenencia : pertenencias) {
            model.addRow(new Object[]{
                pertenencia.getPertenencia_id(),
                pertenencia.getTipo(),
                pertenencia.getDescripcion(),
                pertenencia.getUserId()
            });
        }
    }

    private void addPertenencia() {
        String tipo = JOptionPane.showInputDialog("Tipo:");
        String descripcion = JOptionPane.showInputDialog("Descripción:");
        int userId = Integer.parseInt(JOptionPane.showInputDialog("ID de usuario:"));

        UUID uuid = UUID.randomUUID();
        String pertenenciaId = uuid.toString();

        Pertenencias pertenencia = new Pertenencias(pertenenciaId, tipo, descripcion, userId);
        PertenenciasDAO.create(pertenencia);
        loadPertenencias();
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
        table.setModel(model);
    }

    private void loadPertenencias() {
        model.setRowCount(0);
        List<Pertenencias> pertenencias = PertenenciasDAO.findAll();
        populateTable(pertenencias);
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
