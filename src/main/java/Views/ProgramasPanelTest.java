package Views;

import Models.MenuTest;
import Models.ProgramasDAO;
import Models.Programas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProgramasPanelTest extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public ProgramasPanelTest() {
        initComponents();
        createTable();
        loadProgramas();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tabla de Programas");
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

        addButton.addActionListener(e -> addPrograma());
        editButton.addActionListener(e -> editPrograma());
        deleteButton.addActionListener(e -> deletePrograma());
        backButton.addActionListener(e -> goBackToMainMenu());
    }

    public void populateTable(List<Programas> programas) {
        model.setRowCount(0);
        for (Programas programa : programas) {
            model.addRow(new Object[]{
                programa.getid_Programa(),
                programa.getNomPrograma(),
                programa.getCentroFormacion(),
                programa.getCoordinacion()
            });
        }
    }

    private void addPrograma() {
        String nombre = JOptionPane.showInputDialog("Nombre del programa:");
        String centroFormacion = JOptionPane.showInputDialog("Centro de formación:");
        String coordinacion = JOptionPane.showInputDialog("Coordinación:");

        Programas programa = new Programas(0, nombre, centroFormacion, coordinacion);
        ProgramasDAO.create(programa);
        loadProgramas();
    }

    private void editPrograma() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) table.getValueAt(selectedRow, 0);
            String nombre = JOptionPane.showInputDialog("Nuevo nombre del programa:");
            String centroFormacion = JOptionPane.showInputDialog("Nuevo centro de formación:");
            String coordinacion = JOptionPane.showInputDialog("Nueva coordinación:");

            Programas programa = new Programas(id, nombre, centroFormacion, coordinacion);
            ProgramasDAO.update(programa);
            loadProgramas();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un programa para editar.");
        }
    }

    private void deletePrograma() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) table.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este programa?", "Eliminar Programa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ProgramasDAO.delete(id);
                loadProgramas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un programa para eliminar.");
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
        model.addColumn("Nombre del Programa");
        model.addColumn("Centro de Formación");
        model.addColumn("Coordinación");
        table.setModel(model);
    }

    private void loadProgramas() {
        model.setRowCount(0);
        List<Programas> programas = ProgramasDAO.findAll();
        populateTable(programas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgramasPanelTest programasPanel = new ProgramasPanelTest();
            programasPanel.setVisible(true);
        });
    }

    public JTable getTable() {
        return table;
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public JButton getAddButton() {
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> addPrograma());
        return addButton;
    }

    public JButton getEditButton() {
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(e -> editPrograma());
        return editButton;
    }

    public JButton getDeleteButton() {
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deletePrograma());
        return deleteButton;
    }
    
}
