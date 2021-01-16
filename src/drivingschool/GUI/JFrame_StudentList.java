/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.GUI;

import java.io.IOException;
import drivingschool.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import drivingschool.repo.StudentRepo;

/**
 *
 * @author btyo
 */
public class JFrame_StudentList extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_StudentList
     */
    public JFrame_StudentList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        studentsList = new javax.swing.JList<>();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select and Double Click The Row To Edit");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        studentsList.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        studentsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        studentsList.setName("jList_Students"); // NOI18N
        jScrollPane2.setViewportView(studentsList);

        editBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editBtn.setLabel("Edit Student");
        editBtn.setName("jButton_AddStudent"); // NOI18N
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setInheritsPopupMenu(true);
        deleteBtn.setLabel("Delete Student");
        deleteBtn.setName("jButton_DeleteStudent"); // NOI18N
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("jLabel1");
        jLabel1.setName("jLabel_Captions"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        refresh_StudentList();
    }//GEN-LAST:event_formWindowActivated

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int sel = studentsList.getSelectedIndex();
        if (sel >= 0) {
            Student st;
            st = (Student) StudentRepo.students.get(sel);
            JFrame_StudentAdd sa = new JFrame_StudentAdd();
            sa.edit_student = true;
            sa.st_row = sel;
            sa.show();
            //sa.st_row = st;
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int sel = studentsList.getSelectedIndex();
        if (sel >= 0) {
            StudentRepo.students.remove(sel);
            refresh_StudentList();
            JOptionPane.showMessageDialog(null, "Selected Student has been deleted Successfully");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_StudentList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> studentsList;
    // End of variables declaration//GEN-END:variables

    public String fixedLengthString(String str, int flength) {
        String tstr = "";
        for (int i = 0; i < (flength - str.length()); i++) {
            tstr += " ";
        }
        tstr += str;
        return tstr;
    }

    public void refresh_StudentList() {
        List students = StudentRepo.students;
        if (students == null) {
            try {
                StudentRepo.retrieveStudent();
                students = StudentRepo.students;
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JFrame_StudentList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Student st;
        String cp;
        studentsList.removeAll();

        String[] arr_students = new String[students.size()];
        cp = "";
        cp += fixedLengthString("ID", 10) + "|"
                + fixedLengthString("Name", 15) + "|"
                + fixedLengthString("Surname", 15) + "|"
                + fixedLengthString("Nationality", 15) + "|"
                + fixedLengthString("Birthday", 15) + "|"
                + fixedLengthString("Status", 15);
        jLabel1.setText(cp);

        for (int i = 0; i < students.size(); i++) {
            st = (Student) students.get(i);
            arr_students[i] = fixedLengthString(st.getID().trim(), 10) + "|"
                    + fixedLengthString(st.getName().trim(), 15) + "|"
                    + fixedLengthString(st.getSurname().trim(), 15) + "|"
                    + fixedLengthString(st.getNationality().trim(), 15) + "|"
                    + fixedLengthString(st.getDOB().toString(), 15) + "|"
                    + fixedLengthString(st.getStatus().trim(), 15);
        }
        studentsList.setListData(arr_students);
    }
}
