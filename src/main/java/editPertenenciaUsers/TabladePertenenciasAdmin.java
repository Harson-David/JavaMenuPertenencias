package editPertenenciaUsers;

import AgregarPertenencias.RegistrarPertenencia;
import Controllers.ControllerBitacora;
import Login.AdminLogin;
import Login.AprendizLogin;
import Login.ExternoLogin;
import Login.FuncionarioLogin;
import Login.InstructorLogin;
import Login.LoginEntradaUsers;
import Models.Bitacora;
import Models.BitacoraDAO;
import static Models.BitacoraDAO.findOne;
import Models.Pertenencias;
import Models.PertenenciasDAO;
import Views.BitacoraPanelTest;
import editPertenenciaUsers.EditarPertenencia;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public final class TabladePertenenciasAdmin extends JFrame {

    ControllerBitacora control;
    private final String rol = LoginEntradaUsers.tipoUsuario;
    private int userId = LoginEntradaUsers.userId;
    private JTable table;
    private DefaultTableModel model;

    public TabladePertenenciasAdmin() {
        initComponents();
        control = new ControllerBitacora();
        createTable();
        loadPertenencias();

    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tabla de Pertenencias");
        setSize(1800, 900);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addButton = new JButton("Agregar");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Eliminar");
        JButton backButton = new JButton("Volver al Menú Principal");
        JButton getoutButton = new JButton("Sacar");
        JButton readdButton = new JButton("Volver a Guardar");

        styleButton(addButton);
        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(backButton);
        styleButton(getoutButton);
        styleButton(readdButton);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
        buttonPanel.add(getoutButton);
        buttonPanel.add(readdButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        scrollPane.setViewportView(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(e -> addPertenencia());
        editButton.addActionListener(e -> editPertenencia());
        deleteButton.addActionListener(e -> deletePertenencia());
        backButton.addActionListener(e -> goBackToMainMenu());
        getoutButton.addActionListener(e -> sacarPertenencia());
        readdButton.addActionListener(e -> volveraGuardarPertenencia());
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(51, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(250, 40));
    }

    public void loadPertenencias() {
        model.setRowCount(0);

        switch (rol) {
            case "ADMINISTRADOR" -> {
                // Obtener las pertenencias asociadas al ID del administrador
                List<Pertenencias> pertenenciasAdministrador = PertenenciasDAO.findAllPertenenciasBitacora();
                // Mostrar las pertenencias en la tabla
                populateTable(pertenenciasAdministrador);
            }
            default ->
                JOptionPane.showMessageDialog(null, "Rol no reconocido");
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private void populateTable(List<Pertenencias> pertenencias) {
        model.setRowCount(0);
        for (Pertenencias pertenencia : pertenencias) {

            model.addRow(new Object[]{
                pertenencia.getPertenencia_id(),
                pertenencia.getTipo(),
                pertenencia.getDescripcion(),
                pertenencia.getUserId(),
                pertenencia.getBitacoraId(),
                pertenencia.getFechaIngreso(),
                pertenencia.getHoraEntrada(),
                pertenencia.getHoraSalida(),
                pertenencia.getBitacoraTipo()
            });
        }
    }

    private void addPertenencia() {
        RegistrarPertenencia per = new RegistrarPertenencia();
        per.setLocationRelativeTo(null);
        per.setVisible(true);
        dispose();
    }

    public Bitacora obtenerBitacoraPorId(int bitacoraId) {
        return findOne(bitacoraId);
    }

    private void sacarPertenencia() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Object value = table.getValueAt(selectedRow, 4); // Obtener el valor de la columna que contiene el ID de la bitácora
            if (value instanceof Integer) {
                int bitacoraId = (int) value;
                // Obtener la bitácora por su ID
                Bitacora bitacora = obtenerBitacoraPorId(bitacoraId);
                if (bitacora != null) {
                    control.sacar(bitacora);
                    JOptionPane.showMessageDialog(null, "Pertenencia sacada exitosamente.");
                    loadPertenencias();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la bitácora asociada a esta pertenencia.");
                }
            } else if (value instanceof String string) {
                try {
                    int bitacoraId = Integer.parseInt(string);
                    Bitacora bitacora = obtenerBitacoraPorId(bitacoraId);
                    if (bitacora != null) {
                        control.sacar(bitacora);
                        JOptionPane.showMessageDialog(null, "Pertenencia sacada exitosamente.");
                        loadPertenencias();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la bitácora asociada a esta pertenencia.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El ID de la bitácora no es un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El valor de la bitácora no es ni Integer ni String.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pertenencia para sacar.");
        }
    }

    private void volveraGuardarPertenencia() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Object value = table.getValueAt(selectedRow, 4);
            if (value instanceof Integer) {
                int bitacoraId = (int) value;
                Bitacora bitacora = obtenerBitacoraPorId(bitacoraId);
                if (bitacora != null) {
                    control.volverAguardar(bitacora);
                    JOptionPane.showMessageDialog(null, "Pertenencia actualizada exitosamente.");
                    loadPertenencias();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la bitácora asociada a esta pertenencia.");
                }
            } else if (value instanceof String) {
                try {
                    int bitacoraId = Integer.parseInt((String) value);
                    Bitacora bitacora = obtenerBitacoraPorId(bitacoraId);
                    if (bitacora != null) {
                        control.volverAguardar(bitacora);
                        JOptionPane.showMessageDialog(null, "Pertenencia guardada exitosamente.");
                        loadPertenencias();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la bitácora asociada a esta pertenencia.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El ID de la bitácora no es un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El ID de la bitácora no es un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pertenencia para volver a guardar.");
        }
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
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //Agregar columnas de pertenencias
        model.addColumn("ID PERTENENCIA");
        model.addColumn("TIPO DE PERTENENCIA");
        model.addColumn("DESCRIPCION");
        model.addColumn("ID USUARIO");

        // Agregar las columnas de la Bitácora asociada
        model.addColumn("ID BITACORA");
        model.addColumn("FECHA");
        model.addColumn("HORA DE ENTRADA");
        model.addColumn("HORA DE SALIDA");
        model.addColumn("ESTADO DE PERTENENCIA");

        table.setModel(model);
        table.setRowHeight(35);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Ajustar el ancho de las columnas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(290);
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TabladePertenenciasAdmin pertenenciasPanel = new TabladePertenenciasAdmin();
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
