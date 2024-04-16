package AgregarPertenencias;

import Controllers.ControllerBitacora;
import Login.AdminLogin;
import Login.AprendizLogin;
import Login.ExternoLogin;
import Login.FuncionarioLogin;
import Login.InstructorLogin;
import Login.LoginEntradaUsers;
import javax.swing.JOptionPane;
import Controllers.ControllerPertenencias;
import Models.Bitacora;
import Models.Pertenencias;
import Models.PertenenciasDAO;
import editPertenenciaUsers.TablaPertenencias;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class RegistrarPertenencia extends javax.swing.JFrame {

    ControllerPertenencias control;
    ControllerBitacora bita;

    private final String rol = LoginEntradaUsers.tipoUsuario;

    public RegistrarPertenencia() {
        initComponents();
        control = new ControllerPertenencias();
        bita = new ControllerBitacora();

        fecha.setText(Date.valueOf(LocalDate.now()).toString());
        hEntrada.setText(Time.valueOf(LocalTime.now()).toString());
        LocalTime horaActual = LocalTime.now(); // Línea 8
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Línea 9
        String horaActualString = horaActual.format(formatter); // Línea 10
        hEntrada.setText(horaActualString);

        hSalida.setVisible(false);
        fecha.setVisible(false);
        bitid.setVisible(false);
        hEntrada.setVisible(false);
        idpertenencia.setVisible(false);
        bitacoratipo.setVisible(false);
        idbitacora.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        label27 = new java.awt.Label();
        button2 = new java.awt.Button();
        registroPertenencia = new java.awt.Button();
        tipoPertenencia = new javax.swing.JTextField();
        label31 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionPertenencia = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        label3 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();
        label36 = new java.awt.Label();
        fecha = new javax.swing.JTextField();
        hEntrada = new javax.swing.JTextField();
        hSalida = new javax.swing.JTextField();
        bitid = new javax.swing.JTextField();
        documento = new javax.swing.JTextField();
        idpertenencia = new javax.swing.JTextField();
        bitacoratipo = new javax.swing.JTextField();
        idbitacora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        label27.setAlignment(java.awt.Label.CENTER);
        label27.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label27.setForeground(new java.awt.Color(255, 255, 255));
        label27.setText("TIPO DE USUARIO");

        button2.setBackground(new java.awt.Color(204, 0, 0));
        button2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        button2.setLabel("Salir");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        registroPertenencia.setBackground(new java.awt.Color(0, 255, 0));
        registroPertenencia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        registroPertenencia.setLabel("Registrar");
        registroPertenencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroPertenenciaActionPerformed(evt);
            }
        });

        tipoPertenencia.setBackground(new java.awt.Color(255, 255, 255));
        tipoPertenencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tipoPertenencia.setForeground(new java.awt.Color(0, 0, 0));
        tipoPertenencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipoPertenencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPertenenciaActionPerformed(evt);
            }
        });

        label31.setAlignment(java.awt.Label.CENTER);
        label31.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label31.setForeground(new java.awt.Color(255, 255, 255));
        label31.setText("DESCRIPCION");

        descripcionPertenencia.setBackground(new java.awt.Color(255, 255, 255));
        descripcionPertenencia.setColumns(20);
        descripcionPertenencia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        descripcionPertenencia.setForeground(new java.awt.Color(0, 0, 0));
        descripcionPertenencia.setRows(5);
        descripcionPertenencia.setTabSize(5);
        jScrollPane1.setViewportView(descripcionPertenencia);

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "APRENDIZ", "INSTRUCTOR", "FUNCIONARIO", "EXTERNO", "ADMINISTRADOR" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("REGISTRAR PERTENENCIA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NUMERO DE DOCUMENTO");

        label36.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label36.setForeground(new java.awt.Color(255, 255, 255));
        label36.setText("TIPO DE PERTENENCIA");

        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 0, 0));
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        hEntrada.setBackground(new java.awt.Color(255, 255, 255));
        hEntrada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hEntrada.setForeground(new java.awt.Color(0, 0, 0));
        hEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hEntradaActionPerformed(evt);
            }
        });

        hSalida.setBackground(new java.awt.Color(255, 255, 255));
        hSalida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hSalida.setForeground(new java.awt.Color(0, 0, 0));
        hSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hSalidaActionPerformed(evt);
            }
        });

        bitid.setBackground(new java.awt.Color(255, 255, 255));
        bitid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bitid.setForeground(new java.awt.Color(0, 0, 0));
        bitid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitidActionPerformed(evt);
            }
        });

        documento.setBackground(new java.awt.Color(255, 255, 255));
        documento.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        documento.setForeground(new java.awt.Color(0, 0, 0));
        documento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentoActionPerformed(evt);
            }
        });

        idpertenencia.setBackground(new java.awt.Color(255, 255, 255));
        idpertenencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idpertenencia.setForeground(new java.awt.Color(0, 0, 0));
        idpertenencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpertenenciaActionPerformed(evt);
            }
        });

        bitacoratipo.setBackground(new java.awt.Color(255, 255, 255));
        bitacoratipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bitacoratipo.setForeground(new java.awt.Color(0, 0, 0));
        bitacoratipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoratipoActionPerformed(evt);
            }
        });

        idbitacora.setBackground(new java.awt.Color(255, 255, 255));
        idbitacora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idbitacora.setForeground(new java.awt.Color(0, 0, 0));
        idbitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbitacoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 277, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bitid, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idpertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tipoPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idbitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bitacoratipo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(registroPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idpertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(tipoPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bitacoratipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idbitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registroPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registroPertenenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroPertenenciaActionPerformed
        String tipoPerte = tipoPertenencia.getText();
        String des = descripcionPertenencia.getText();
        String perteid = idpertenencia.getText();

        int num;
        try {
            num = Integer.parseInt(documento.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El documento ingresado no es valido.");
            return;
        }

       
        Time horaEntrada = Time.valueOf(LocalTime.now());

        String horaSalidaStr = hSalida.getText().trim(); // Quitamos los espacios en blanco al inicio y al final

        // Verificar si la cadena de hora de salida está vacía
        Time horaSalida = null;
        if (!horaSalidaStr.isEmpty()) {
            try {
       
                horaSalida = Time.valueOf(horaSalidaStr);
            } catch (IllegalArgumentException e) {
                
                JOptionPane.showMessageDialog(null, "El formato de la hora de salida es incorrecto. Por favor, ingresa la hora en formato HH:mm:ss.");
                return; 
            }
        }

        bitacoratipo.setText("ENTRADA");
        String bitTipo = bitacoratipo.getText();


        Bitacora bit = new Bitacora(Date.valueOf(LocalDate.now()), horaEntrada, horaSalida, bitTipo);
        Pertenencias per = new Pertenencias(perteid, tipoPerte, des, num);


        control.create(per);
        bita.createBitaco(bit);

        System.out.println("Información de la pertenencia:");
        System.out.println(per.toString());

        System.out.println("Información de la bitácora:");
        System.out.println(bit.toString());

        //System.out.println("ID de pertenencia obtenido: " + perId);
        //System.out.println("ID de bitácora obtenido: " + bitacoraId);
        // Crear la relación entre la pertenencia y la bitácora en la tabla intermedia
        control.relacionPerBit(per.getPertenencia_id(), bit.getBitacoraId());

        // Mostrar mensaje de éxito y actualizar la tabla
        TablaPertenencias tabla = new TablaPertenencias();
        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "Pertenencia agregada con éxito.");
    }//GEN-LAST:event_registroPertenenciaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
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
    }//GEN-LAST:event_button2ActionPerformed

    private void tipoPertenenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPertenenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoPertenenciaActionPerformed

    private void documento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documento1ActionPerformed

    private void documento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documento3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documento3ActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void hEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hEntradaActionPerformed

    private void hSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hSalidaActionPerformed

    private void bitidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bitidActionPerformed

    private void documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documentoActionPerformed

    private void idpertenenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpertenenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpertenenciaActionPerformed

    private void bitacoratipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitacoratipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bitacoratipoActionPerformed

    private void idbitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbitacoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbitacoraActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegistrarPertenencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPertenencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPertenencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPertenencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistrarPertenencia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bitacoratipo;
    private javax.swing.JTextField bitid;
    private java.awt.Button button2;
    private javax.swing.JTextArea descripcionPertenencia;
    private javax.swing.JTextField documento;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField hEntrada;
    private javax.swing.JTextField hSalida;
    private javax.swing.JTextField idbitacora;
    private javax.swing.JTextField idpertenencia;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label27;
    private java.awt.Label label3;
    private java.awt.Label label31;
    private java.awt.Label label36;
    private java.awt.Button registroPertenencia;
    private javax.swing.JTextField tipoPertenencia;
    // End of variables declaration//GEN-END:variables
}
