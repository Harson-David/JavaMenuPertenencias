package Views;

import AgregarPertenencias.RegistrarPertenencia;
import Models.MenuTest;
import Models.Pertenencias;
import Models.PertenenciasDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PertenenciasPanelTest extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public PertenenciasPanelTest() {
        initComponents();
        createTable();
        loadPertenencias();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tabla de Pertenencias");
        setSize(600, 400);
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

        addButton.addActionListener(e -> addPertenencia());
        editButton.addActionListener(e -> editPertenencia());
        deleteButton.addActionListener(e -> deletePertenencia());
        backButton.addActionListener(e -> goBackToMainMenu());
    }

    public void populateTable(List<Pertenencias> pertenencias) {
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
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }

    private void editPertenencia() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String pertenenciaId = (String) table.getValueAt(selectedRow, 0);
            String tipo = JOptionPane.showInputDialog("Nuevo tipo:");
            String descripcion = JOptionPane.showInputDialog("Nueva descripción:");
            int userId = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID de usuario:"));

            Pertenencias pertenencia = new Pertenencias(pertenenciaId, tipo, descripcion, userId);
            PertenenciasDAO.update(pertenencia);
            loadPertenencias();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pertenencia para editar.");
        }
    }

    private void deletePertenencia() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String pertenenciaId = (String) table.getValueAt(selectedRow, 0);
            int bitacoraid = (int) table.getValueAt(selectedRow, 4);
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta pertenencia?", "Eliminar Pertenencia", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                PertenenciasDAO.delete(pertenenciaId, bitacoraid);
                loadPertenencias();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pertenencia para eliminar.");
        }
    }

    private void goBackToMainMenu() {
        MenuTest mainMenu = new MenuTest();
        mainMenu.setVisible(true);
        dispose();
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
            PertenenciasPanelTest pertenenciasPanel = new PertenenciasPanelTest();
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
}
