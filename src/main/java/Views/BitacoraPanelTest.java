package Views;

import Login.AdminLogin;
import Login.AprendizLogin;
import Login.ExternoLogin;
import Login.FuncionarioLogin;
import Login.InstructorLogin;
import Login.LoginEntradaUsers;
import Models.Bitacora;
import Models.BitacoraDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
//import java.util.UUID;

public class BitacoraPanelTest extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private final String rol = LoginEntradaUsers.tipoUsuario;

    public BitacoraPanelTest() {
        initComponents();
        createTable();
        loadBitacora();
        
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bitácora");
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

        addButton.addActionListener(e -> addBitacora());
        editButton.addActionListener(e -> editBitacora());
        deleteButton.addActionListener(e -> deleteBitacora());
        backButton.addActionListener(e -> returnToLogin());
    }

    public void populateTable(List<Bitacora> bitacoras) {
        model.setRowCount(0);
        for (Bitacora bitacora : bitacoras) {
            model.addRow(new Object[]{
                bitacora.getBitacoraId(),
                bitacora.getFechaIngreso(),
                bitacora.getHoraEntrada(),
                bitacora.getHoraSalida()
            });
        }
    }

    private void addBitacora() {
        String fechaIngreso = JOptionPane.showInputDialog("Fecha de Ingreso (YYYY-MM-DD):");
        String horaEntrada = JOptionPane.showInputDialog("Hora de Entrada (HH:MM:SS):");
        String horaSalida = JOptionPane.showInputDialog("Hora de Salida (HH:MM:SS):");

        int bitacoraId = generateRandomId();

        Bitacora bitacora = new Bitacora(bitacoraId, Date.valueOf(fechaIngreso), Time.valueOf(horaEntrada), Time.valueOf(horaSalida), "", "", null, null, "", "");
        BitacoraDAO.create(bitacora);
    }

    private void editBitacora() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int bitacoraId = (int) table.getValueAt(selectedRow, 0);
            String nuevaFechaIngreso = JOptionPane.showInputDialog("Nueva Fecha de Ingreso (YYYY-MM-DD):");
            String nuevaHoraEntrada = JOptionPane.showInputDialog("Nueva Hora de Entrada (HH:MM:SS):");
            String nuevaHoraSalida = JOptionPane.showInputDialog("Nueva Hora de Salida (HH:MM:SS):");

            Bitacora bitacora = new Bitacora(bitacoraId, Date.valueOf(nuevaFechaIngreso), Time.valueOf(nuevaHoraEntrada), Time.valueOf(nuevaHoraSalida), "", "", null, null, "", "");
            BitacoraDAO.update(bitacora);
            loadBitacora();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.");
        }
    }


    private int generateRandomId() {
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return randomNum;
    }

    private void deleteBitacora() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int bitacoraId = (int) table.getValueAt(selectedRow, 0);
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta entrada de bitácora?",
                    "Eliminar Entrada de Bitácora", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                BitacoraDAO.delete(bitacoraId);
                loadBitacora();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.");
        }
    }

    private void returnToLogin() {
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
        model.addColumn("ID BITACORA");
        model.addColumn("Fecha de Ingreso");
        model.addColumn("Hora de Entrada");
        model.addColumn("Hora de Salida");
//        model.addColumn("Tipo");
//        model.addColumn("Descripción");
//        model.addColumn("Fecha de Salida");
//        model.addColumn("Hora de Salida Equipo SENA");
//        model.addColumn("Motivo de Salida");
//        model.addColumn("Motivo de Ingreso");
        table.setModel(model);
    }

    public void loadBitacora() {
        model.setRowCount(0);
        List<Bitacora> bitacoras = BitacoraDAO.findAll();
        populateTable(bitacoras);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BitacoraPanelTest bitacoraPanel = new BitacoraPanelTest();
            bitacoraPanel.setVisible(true);
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
        addButton.addActionListener(e -> addBitacora());
        return addButton;
    }

    public JButton getEditButton() {
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(e -> editBitacora());
        return editButton;
    }

    public JButton getDeleteButton() {
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deleteBitacora());
        return deleteButton;
    }

}
