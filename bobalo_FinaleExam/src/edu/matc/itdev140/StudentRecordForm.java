/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.matc.itdev140;


/**
 *
 * @author Eugene
 */
public class StudentRecordForm extends javax.swing.JFrame
{

    
    Info allInfo = new Info();
    
    public StudentRecordForm()
    {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        btnDisplayAllStud = new javax.swing.JButton();
        btnCreateStudent = new javax.swing.JButton();
        btnAddAssessments = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        topMenuAddStudent = new javax.swing.JMenuItem();
        topMenuEditStudentInfo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        helpInfo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        appVersion = new javax.swing.JMenuItem();
        intro = new javax.swing.JMenuItem();
        devInfo = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Record");
        setName("StudentRecordForm"); // NOI18N
        setPreferredSize(new java.awt.Dimension(580, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Grade Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 10, 211, 44);
        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(30, -30, 5, 5);
        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(0, -10, 5, 5);

        btnDisplayAllStud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDisplayAllStud.setText("Display All Students");
        btnDisplayAllStud.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDisplayAllStudActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisplayAllStud);
        btnDisplayAllStud.setBounds(30, 230, 220, 35);

        btnCreateStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreateStudent.setText("Student Record");
        btnCreateStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCreateStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateStudent);
        btnCreateStudent.setBounds(30, 90, 220, 35);

        btnAddAssessments.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAssessments.setText("Add Assessments Score");
        btnAddAssessments.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddAssessmentsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAssessments);
        btnAddAssessments.setBounds(30, 160, 220, 35);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-210, 447, 660, 730);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/matc/itdev140/ParentsGradebook.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 60, 270, 230);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.add(jSeparator1);

        topMenuAddStudent.setText("Add Student");
        topMenuAddStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                topMenuAddStudentActionPerformed(evt);
            }
        });
        jMenu1.add(topMenuAddStudent);

        topMenuEditStudentInfo.setText("Edit Student Info");
        jMenu1.add(topMenuEditStudentInfo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        helpInfo.setText("Help Information");
        helpInfo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                helpInfoActionPerformed(evt);
            }
        });
        jMenu2.add(helpInfo);
        jMenu2.add(jSeparator2);

        appVersion.setText("Version");
        appVersion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                appVersionActionPerformed(evt);
            }
        });
        jMenu2.add(appVersion);

        intro.setText("Introduction");
        intro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                introActionPerformed(evt);
            }
        });
        jMenu2.add(intro);

        devInfo.setText("Developer");
        devInfo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                devInfoActionPerformed(evt);
            }
        });
        jMenu2.add(devInfo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(679, 403));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void introActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_introActionPerformed
    {//GEN-HEADEREND:event_introActionPerformed
        allInfo.aboutApp();
        //JOptionPane.showMessageDialog(null, allInfo.aboutApp(), "About App", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_introActionPerformed

    private void devInfoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_devInfoActionPerformed
    {//GEN-HEADEREND:event_devInfoActionPerformed
        allInfo.developer();
    }//GEN-LAST:event_devInfoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenu1ActionPerformed
    {//GEN-HEADEREND:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void helpInfoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_helpInfoActionPerformed
    {//GEN-HEADEREND:event_helpInfoActionPerformed
        allInfo.forHelp();
    }//GEN-LAST:event_helpInfoActionPerformed

    private void appVersionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_appVersionActionPerformed
    {//GEN-HEADEREND:event_appVersionActionPerformed
        allInfo.appVersion();
    }//GEN-LAST:event_appVersionActionPerformed

    /**
     *  Will open Add Student Form
     * @param evt 
     */
    private void btnCreateStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCreateStudentActionPerformed
    {//GEN-HEADEREND:event_btnCreateStudentActionPerformed
        CreateStudentRecord studRec = new CreateStudentRecord();
        studRec.setVisible(true);
    }//GEN-LAST:event_btnCreateStudentActionPerformed

    /**
     *  top menu. File/Add Student - open Add Student Form
     * @param evt 
     */
    private void topMenuAddStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_topMenuAddStudentActionPerformed
    {//GEN-HEADEREND:event_topMenuAddStudentActionPerformed
        CreateStudentRecord createStudent = new CreateStudentRecord();
        createStudent.setVisible(true);
    }//GEN-LAST:event_topMenuAddStudentActionPerformed

    /**
     * Opens a form were you can adjust students grades
     * @param evt 
     */
    private void btnAddAssessmentsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddAssessmentsActionPerformed
    {//GEN-HEADEREND:event_btnAddAssessmentsActionPerformed
        StudentGradeAdjustmentForm studentAdjustGrades = new StudentGradeAdjustmentForm();
        studentAdjustGrades.setVisible(true);
    }//GEN-LAST:event_btnAddAssessmentsActionPerformed

    private void btnDisplayAllStudActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDisplayAllStudActionPerformed
    {//GEN-HEADEREND:event_btnDisplayAllStudActionPerformed
        DisplayAllStudents displayAllForm = new DisplayAllStudents();
        
        displayAllForm.setVisible(true);
    }//GEN-LAST:event_btnDisplayAllStudActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem appVersion;
    private javax.swing.JButton btnAddAssessments;
    private javax.swing.JButton btnCreateStudent;
    private javax.swing.JButton btnDisplayAllStud;
    private javax.swing.JMenuItem devInfo;
    private javax.swing.JMenuItem helpInfo;
    private javax.swing.JMenuItem intro;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JMenuItem topMenuAddStudent;
    private javax.swing.JMenuItem topMenuEditStudentInfo;
    // End of variables declaration//GEN-END:variables
}
