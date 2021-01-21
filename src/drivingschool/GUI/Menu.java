/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import drivingschool.repo.AgreementRepo;
import drivingschool.repo.LessonRepo;
import drivingschool.repo.PackageRepo;
import drivingschool.repo.PaymentRepo;
import drivingschool.repo.StudentRepo;
import java.sql.SQLException;

/**
 *
 * @author btyo
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        systemMenu = new javax.swing.JMenu();
        backupBtn = new javax.swing.JMenuItem();
        restoreBtn = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        quitBtn = new javax.swing.JMenuItem();
        studentsMenu = new javax.swing.JMenu();
        addStudentBtn = new javax.swing.JMenuItem();
        listStudentsBtn = new javax.swing.JMenuItem();
        lessonsMenu = new javax.swing.JMenu();
        addLessonBtn = new javax.swing.JMenuItem();
        listLessonsBtn = new javax.swing.JMenuItem();
        packagesMenu = new javax.swing.JMenu();
        addPackagesBtn = new javax.swing.JMenuItem();
        listPackagesBtn = new javax.swing.JMenuItem();
        paymentsMenu = new javax.swing.JMenu();
        addPaymentBtn = new javax.swing.JMenuItem();
        listPaymentsBtn = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        addAgmtBtn = new javax.swing.JMenuItem();
        listAgmtBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        systemMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Computer_16x16_132637.png"))); // NOI18N
        systemMenu.setText("System");

        backupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Upload_132671.png"))); // NOI18N
        backupBtn.setText("Backup");
        backupBtn.setName("jMenuItem_backup"); // NOI18N
        backupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupBtnActionPerformed(evt);
            }
        });
        systemMenu.add(backupBtn);

        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Download_132678.png"))); // NOI18N
        restoreBtn.setText("Restore");
        restoreBtn.setName("jMenuItem_Restore"); // NOI18N
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });
        systemMenu.add(restoreBtn);
        systemMenu.add(jSeparator1);

        quitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Exit_132751.png"))); // NOI18N
        quitBtn.setText("Quit");
        quitBtn.setName("jMenuItem_Quit"); // NOI18N
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });
        systemMenu.add(quitBtn);

        jMenuBar1.add(systemMenu);

        studentsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Male_132787.png"))); // NOI18N
        studentsMenu.setText("Students");

        addStudentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Create_132699.png"))); // NOI18N
        addStudentBtn.setText("Add Student");
        addStudentBtn.setName("jMenuItem_AddStudent"); // NOI18N
        addStudentBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });
        studentsMenu.add(addStudentBtn);

        listStudentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        listStudentsBtn.setText("List Students");
        listStudentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listStudentsBtnActionPerformed(evt);
            }
        });
        studentsMenu.add(listStudentsBtn);

        jMenuBar1.add(studentsMenu);

        lessonsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Calendar_132582.png"))); // NOI18N
        lessonsMenu.setText("Lessons");
        lessonsMenu.setMaximumSize(new java.awt.Dimension(91, 50));

        addLessonBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Create_132699.png"))); // NOI18N
        addLessonBtn.setText("New Lesson");
        addLessonBtn.setName("jMenuItem_AddDepartment"); // NOI18N
        addLessonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLessonBtnActionPerformed(evt);
            }
        });
        lessonsMenu.add(addLessonBtn);

        listLessonsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        listLessonsBtn.setText("View Lessons");
        listLessonsBtn.setName(""); // NOI18N
        listLessonsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listLessonsBtnActionPerformed(evt);
            }
        });
        lessonsMenu.add(listLessonsBtn);

        jMenuBar1.add(lessonsMenu);

        packagesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/folder.png"))); // NOI18N
        packagesMenu.setText("Packages");
        packagesMenu.setMaximumSize(new java.awt.Dimension(117, 50));

        addPackagesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Create_132699.png"))); // NOI18N
        addPackagesBtn.setText("Add Package");
        addPackagesBtn.setName("jMenuItem_AddDepartment"); // NOI18N
        addPackagesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPackagesBtnActionPerformed(evt);
            }
        });
        packagesMenu.add(addPackagesBtn);

        listPackagesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        listPackagesBtn.setText("List Packages");
        listPackagesBtn.setName(""); // NOI18N
        listPackagesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPackagesBtnActionPerformed(evt);
            }
        });
        packagesMenu.add(listPackagesBtn);

        jMenuBar1.add(packagesMenu);

        paymentsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        paymentsMenu.setText("Payment");
        paymentsMenu.setMaximumSize(new java.awt.Dimension(100, 50));
        paymentsMenu.setName("jMenu_Grades"); // NOI18N
        paymentsMenu.setPreferredSize(new java.awt.Dimension(150, 50));

        addPaymentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Create_132699.png"))); // NOI18N
        addPaymentBtn.setText("New Payment");
        addPaymentBtn.setName("jMenuItem_AddDepartment"); // NOI18N
        addPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentBtnActionPerformed(evt);
            }
        });
        paymentsMenu.add(addPaymentBtn);

        listPaymentsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        listPaymentsBtn.setText("List Payments");
        listPaymentsBtn.setName(""); // NOI18N
        listPaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPaymentsBtnActionPerformed(evt);
            }
        });
        paymentsMenu.add(listPaymentsBtn);

        jMenuBar1.add(paymentsMenu);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Paste_132732.png"))); // NOI18N
        jMenu6.setText("Agreements");
        jMenu6.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jMenu6.setMaximumSize(new java.awt.Dimension(121, 50));
        jMenu6.setName("JMenu_Attendance"); // NOI18N

        addAgmtBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Create_132699.png"))); // NOI18N
        addAgmtBtn.setText("Add Agreement");
        addAgmtBtn.setName("jMenuItem_AddDepartment"); // NOI18N
        addAgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAgmtBtnActionPerformed(evt);
            }
        });
        jMenu6.add(addAgmtBtn);

        listAgmtBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drivingschool/assets/iconfinder_Table_132735.png"))); // NOI18N
        listAgmtBtn.setText("List Agreements");
        listAgmtBtn.setName(""); // NOI18N
        listAgmtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAgmtBtnActionPerformed(evt);
            }
        });
        jMenu6.add(listAgmtBtn);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtnActionPerformed
        try {
            StudentRepo.retrieveStudent();
            LessonRepo.retrieveLessons();
            PackageRepo.retrievePackages();
            PaymentRepo.retrievePayments();
//            AgreementRepo.retrieveAgreements();

            JOptionPane.showMessageDialog(null, "Data Successfully Retrieved");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_restoreBtnActionPerformed

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        try {
            new JFrame_StudentAdd().show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void listStudentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listStudentsBtnActionPerformed
        try {
            new JFrame_StudentList().show();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listStudentsBtnActionPerformed

    private void listLessonsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listLessonsBtnActionPerformed
        new JFrame_LessonList().show();
    }//GEN-LAST:event_listLessonsBtnActionPerformed

    private void addLessonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLessonBtnActionPerformed
        new JFrame_LessonAdd().show();
    }//GEN-LAST:event_addLessonBtnActionPerformed

    private void listPackagesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPackagesBtnActionPerformed
        new JFrame_PackageList().show();
    }//GEN-LAST:event_listPackagesBtnActionPerformed

    private void addPackagesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPackagesBtnActionPerformed
        new JFrame_PackageAdd().show();

    }//GEN-LAST:event_addPackagesBtnActionPerformed

    private void listPaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPaymentsBtnActionPerformed
        new JFrame_PaymentList().show();
    }//GEN-LAST:event_listPaymentsBtnActionPerformed

    private void addPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentBtnActionPerformed
        new JFrame_PaymentAdd().show();
    }//GEN-LAST:event_addPaymentBtnActionPerformed

    private void listAgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAgmtBtnActionPerformed
        new JFrame_AgreementList().show();
    }//GEN-LAST:event_listAgmtBtnActionPerformed

    private void addAgmtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAgmtBtnActionPerformed
        new JFrame_AgreementAdd().show();
    }//GEN-LAST:event_addAgmtBtnActionPerformed

    private void backupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupBtnActionPerformed
        try {
            StudentRepo.backupStudent();
            LessonRepo.backupLessons();
            PackageRepo.backupPackages();
            PaymentRepo.backupPayments();
//            AgreementRepo.backupAgreements();
            JOptionPane.showMessageDialog(null, "Data Successfully Backed up");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backupBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addAgmtBtn;
    private javax.swing.JMenuItem addLessonBtn;
    private javax.swing.JMenuItem addPackagesBtn;
    private javax.swing.JMenuItem addPaymentBtn;
    private javax.swing.JMenuItem addStudentBtn;
    private javax.swing.JMenuItem backupBtn;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu lessonsMenu;
    private javax.swing.JMenuItem listAgmtBtn;
    private javax.swing.JMenuItem listLessonsBtn;
    private javax.swing.JMenuItem listPackagesBtn;
    private javax.swing.JMenuItem listPaymentsBtn;
    private javax.swing.JMenuItem listStudentsBtn;
    private javax.swing.JMenu packagesMenu;
    private javax.swing.JMenu paymentsMenu;
    private javax.swing.JMenuItem quitBtn;
    private javax.swing.JMenuItem restoreBtn;
    private javax.swing.JMenu studentsMenu;
    private javax.swing.JMenu systemMenu;
    // End of variables declaration//GEN-END:variables
}
