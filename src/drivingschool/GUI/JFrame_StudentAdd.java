/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.GUI;

import drivingschool.entity.Student;
import drivingschool.repo.StudentModel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dovud Inomov
 */
public class JFrame_StudentAdd extends javax.swing.JFrame {

    public Boolean edit_student;
    public int selected_id;
    private final StudentModel sModel;

    /**
     * Creates new form JFrame_StudentAdd
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public JFrame_StudentAdd() throws ClassNotFoundException, SQLException {
        initComponents();
        edit_student = false;
        sModel = new StudentModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        stdNoLabel = new javax.swing.JLabel();
        stdIDTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        nationalityLabel = new javax.swing.JLabel();
        nationalityTextField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        statusTextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        licenceNoTextField = new javax.swing.JTextField();
        licenceNoLabel = new javax.swing.JLabel();
        licenceExpLabel = new javax.swing.JLabel();
        licenceExpTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter The Information Of The Student");
        setName("frame_StudentAdd"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        stdNoLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stdNoLabel.setText("Std ID");

        stdIDTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stdIDTextField.setEnabled(false);
        stdIDTextField.setName("jTextFiend_StdNo"); // NOI18N
        stdIDTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stdIDTextFieldFocusLost(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLabel.setText("Name");

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameTextField.setName("jTextField_Name"); // NOI18N

        surnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        surnameLabel.setText("Surname");

        surnameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        surnameTextField.setToolTipText("");
        surnameTextField.setName("jTextField_Surname"); // NOI18N
        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        nationalityLabel.setText("Nationality");

        nationalityTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nationalityTextField.setInheritsPopupMenu(true);
        nationalityTextField.setName("jTextField_Nationality"); // NOI18N

        birthdayLabel.setText("Birthday (yyyy-mm-dd)");

        birthdayTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        birthdayTextField.setName("jTextField_Birthday"); // NOI18N
        birthdayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayTextFieldActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Save_132607.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setName("jButton_Save"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        statusTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusTextField.setName("jTextField_Birthday"); // NOI18N

        statusLabel.setText("Status");

        licenceNoTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        licenceNoTextField.setName("jTextField_Birthday"); // NOI18N
        licenceNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenceNoTextFieldActionPerformed(evt);
            }
        });

        licenceNoLabel.setText("Licence No");

        licenceExpLabel.setText("Licence expire");

        licenceExpTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        licenceExpTextField.setName("jTextField_Birthday"); // NOI18N
        licenceExpTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenceExpTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stdNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stdIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nationalityLabel)
                                    .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusLabel))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(birthdayLabel))
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel)
                                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(licenceNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(licenceNoLabel))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(licenceExpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(licenceExpLabel))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(saveButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stdNoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stdIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nationalityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addGap(3, 3, 3)
                        .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(birthdayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(licenceNoLabel)
                        .addGap(3, 3, 3)
                        .addComponent(licenceNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(licenceExpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(licenceExpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!nameTextField.getText().trim().isEmpty()
                && !surnameTextField.getText().trim().isEmpty()
                && !nationalityTextField.getText().trim().isEmpty()
                && !birthdayTextField.getText().trim().isEmpty()) {
            String name = nameTextField.getText().trim();
            String surname = surnameTextField.getText().trim();
            String nationality = nationalityTextField.getText().trim();
            String dob = birthdayTextField.getText().trim();
            String status = statusTextField.getText().trim();
            String licenceNo = licenceNoTextField.getText().trim();
            String licenceExp = licenceExpTextField.getText().trim();

            if (!edit_student) {
                sModel.addStudent(name, surname, nationality, dob, status, licenceNo, licenceExp);
            } else {
                int id = Integer.valueOf(stdIDTextField.getText());
                sModel.editStudent(id, name, surname, nationality, dob, status, licenceNo, licenceExp);
                JOptionPane.showMessageDialog(null, "The Selected Student Data is Edited Successfully");
            }
            setVisible(false);

        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (edit_student) {
            Student st = sModel.getStudentById(selected_id);

            stdIDTextField.setText(String.valueOf(st.getID()));
            nameTextField.setText(st.getName());
            surnameTextField.setText(st.getSurname());
            nationalityTextField.setText(st.getNationality());
            statusTextField.setText(st.getStatus());
            birthdayTextField.setText(st.getDOB());
            licenceExpTextField.setText(st.getLicenceExpire());
            licenceNoTextField.setText(st.getLicenceNo());
        }
    }//GEN-LAST:event_formWindowActivated

    private void birthdayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayTextFieldActionPerformed

    private void licenceExpTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenceExpTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licenceExpTextFieldActionPerformed

    private void licenceNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenceNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licenceNoTextFieldActionPerformed

    private void stdIDTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stdIDTextFieldFocusLost

    }//GEN-LAST:event_stdIDTextFieldFocusLost

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
            java.util.logging.Logger.getLogger(JFrame_StudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrame_StudentAdd().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFrame_StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JFrame_StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel licenceExpLabel;
    private javax.swing.JTextField licenceExpTextField;
    private javax.swing.JLabel licenceNoLabel;
    private javax.swing.JTextField licenceNoTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextField nationalityTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JTextField stdIDTextField;
    private javax.swing.JLabel stdNoLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
