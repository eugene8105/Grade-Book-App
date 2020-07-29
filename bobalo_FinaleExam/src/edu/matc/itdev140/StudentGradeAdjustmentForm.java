

package edu.matc.itdev140;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eugene
 */
public class StudentGradeAdjustmentForm extends javax.swing.JFrame
{
    String[] assignment = new String[10];
    int assignmentNumber = 0;
    int assignmentGrade = 0;
    int exam = 0;
    int individualProject = 0;
    int id = 0;
    String examName = "Exam";
    String indProjectName = "IndProj";
    String finalLetter = "";
    
    int sum = 0;

    public int getSum()
    { return sum; }

    public void setSum(int sum)
    { this.sum = sum; }

    public int getId()
    { return id; }

    public void setId(int id)
    { this.id = id; }

    public int getAssignmentNumber()
    { return assignmentNumber;}

    public void setAssignmentNumber(int assignmentNumber)
    { this.assignmentNumber = assignmentNumber; }
    
    public String[] getAssignment()
    { return assignment; }

    public void setAssignment(String[] assignment)
    { this.assignment = assignment; }

    public int getExam()
    { return exam; }

    public void setExam(int exam)
    { this.exam = exam; }

    public int getIndividualProject()
    { return individualProject; }

    public void setIndividualProject(int individualProject)
    { this.individualProject = individualProject; }
    
    String TABLE_NAME_02 = "ASSESSMENTS"; // table 2 name
    
      public String getTABLE_NAME_02()
    { return TABLE_NAME_02; }

    public void setTABLE_NAME_02(String TABLE_NAME_02)
    { this.TABLE_NAME_02 = TABLE_NAME_02; }
    
    String TABLE_NAME_01 = "STUDENTS"; // table 1 name

    public String getTABLE_NAME_01()
    { return TABLE_NAME_01; }

    public void setTABLE_NAME_01(String TABLE_NAME_01)
    { this.TABLE_NAME_01 = TABLE_NAME_01; }

    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; // driver location for Derby DB
    public static final String JDBC_URL = "jdbc:derby:GradeBook;create=true"; // URL and name of DB must to be created - Relativity
    public static Connection conn;
    private static Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement st = null;
   
    
    /**
     * Creates new form StudentGradebookForm
     */
    public StudentGradeAdjustmentForm()
    {
        initComponents();
    }
    
    /**
     *  will print all students from DB
     */
    public void printAll()
    {   try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sq = "SELECT * FROM " + TABLE_NAME_02;
            st = conn.prepareStatement(sq);
            rs = st.executeQuery();
            jTStudentGrade.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     *  updateGradeLetter method updating DB for grade letter
     */
     public void updateGradeLetter()
     {
         try
        {
            String sq5 = "UPDATE " + TABLE_NAME_01 + " SET Grade = '" + finalLetter + "' WHERE ID = " + id + "";
            
            stmt = conn.createStatement();
            stmt.execute(sq5);
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
     } // end of updateGradeLetter method
    
    /**
     *  This method is searching for students
     */
    public void studentSearch()
    {
        try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sq4 = "SELECT * FROM " + TABLE_NAME_01 + " WHERE ID = " + id;
            st = conn.prepareStatement(sq4);
            rs = st.executeQuery();
            jtStudentName.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(sq4); // testing output of query 4 - for my check
            
            updateGradeTable();
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of studentSearch method
    
    /**
     *  updateAssessmentsTable method for updating all student assinments 
     */
    public void updateGradeTable()
    {
         try
        {
            String sq4 = "SELECT * FROM " + TABLE_NAME_02 + " WHERE ID = " + id;
            
            st = conn.prepareStatement(sq4);
            rs = st.executeQuery();
            jTStudentGrade.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of updateAssessmentsTable
    
    
    /**
     *  updateAssignmentsScore method for assign letter 
     */
    public void updateAssignmentsScore()
    {
        if (assignmentNumber == 0)
        { assignment[assignmentNumber] = "As01"; }
        if (assignmentNumber == 1)
        { assignment[assignmentNumber] = "As02"; }
        if (assignmentNumber == 2)
        { assignment[assignmentNumber] = "As03"; }
        if (assignmentNumber == 3)
        { assignment[assignmentNumber] = "As04"; }
        if (assignmentNumber == 4)
        { assignment[assignmentNumber] = "As05"; }
        if (assignmentNumber == 5)
        { assignment[assignmentNumber] = "As06"; }
        if (assignmentNumber == 6)
        { assignment[assignmentNumber] = "As07"; }
        if (assignmentNumber == 7)
        { assignment[assignmentNumber] = "As08"; }
        if (assignmentNumber == 8)
        { assignment[assignmentNumber] = "As09"; }
        if (assignmentNumber == 9)
        { assignment[assignmentNumber] = "As10"; }
         try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sq5 = "UPDATE " + TABLE_NAME_02 + " SET " + assignment[assignmentNumber] + " = " + Integer.toString(assignmentGrade) + " WHERE ID = " + id + "";
            
            stmt = conn.createStatement();
            stmt.execute(sq5);
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of updateAssignmentLetter method
    
    /**
     *  updateExam method is updating exam score
     */
    public void updateExam()
    {
        
         try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sq5 = "UPDATE " + TABLE_NAME_02 + " SET " + examName + " = " + Integer.toString(exam) + " WHERE ID = " + id + "";
            
            stmt = conn.createStatement();
            stmt.execute(sq5);
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of updateExam method
    
    
    /**
     *  updateIndProj method updates Individual Project score
     */
    public void updateIndProj()
    {
         try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try
        {
            String sq5 = "UPDATE " + TABLE_NAME_02 + " SET " + indProjectName + " = " + Integer.toString(individualProject) + " WHERE ID = " + id + "";
            
            stmt = conn.createStatement();
            stmt.execute(sq5);
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of updateIndProj method
    
    /**
     *  calculateGrade method - calculating final total score
     */
    public void calculateGrade()
    {
        try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        ResultSet result = null;
        try
        {
            String sq6 = "SELECT SUM (As01 + As02 + As03 + As04 + As05 + As06 + As07 + As08 + As09 + As10 + Exam + IndProj) FROM " + TABLE_NAME_02 + " WHERE ID = " + id + "";
            System.out.println(sq6);
            stmt = conn.createStatement();
            result = stmt.executeQuery(sq6);
            while(result.next())
            {
                int c = result.getInt(1);
                sum = sum + c;
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of Calculate method
    
    
    /**
     *  assingFinalLetter method is assigning determine final letter
     */
    public void assingFinalLetter()
    {
        
        if (sum >= 950 && sum <= 1000)
        { finalLetter = "A"; }
        else if (sum >= 900 && sum <= 945)
        { finalLetter = "-A"; }
        else if (sum >= 850 && sum <= 899)
        { finalLetter = "B+"; }
        else if (sum >= 800 && sum <= 849)
        { finalLetter = "B"; }
        else if (sum >= 750 && sum <= 799)
        { finalLetter = "-B"; }
        else if (sum >= 700 && sum <= 749)
        { finalLetter = "C+"; }
        else if (sum >= 650 && sum <= 699)
        { finalLetter = "C"; }
        else if (sum >= 600 && sum <= 649)
        { finalLetter = "D"; }
        else if (sum < 600)
        { finalLetter = "F"; }
        
    } // end of assignFinalLetter method
    
    /**
     *  Starts frame design 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTStudentGrade = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtStudentName = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStudentAssignmentGrade = new javax.swing.JTextField();
        txtAssignNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtExamScore = new javax.swing.JTextField();
        btnSubmitExamScore = new javax.swing.JButton();
        btnSubmitAssGrade1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtProjectScore = new javax.swing.JTextField();
        btnSubmitProjectScore = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserNumber = new javax.swing.JTextField();
        btnDisplayGrades = new javax.swing.JButton();
        btnSubmitUserNamber1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnShowFinalLetter = new javax.swing.JButton();
        txtFinalLetter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Gradebook Form");
        setName("StudentGradebookForm"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Student Grade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 10, 190, 29);

        jTStudentGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTStudentGrade);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 850, 70);

        jtStudentName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane2.setViewportView(jtStudentName);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 430, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter Grade:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 250, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Assignment number:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 210, 180, 30);

        txtStudentAssignmentGrade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtStudentAssignmentGradeActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentAssignmentGrade);
        txtStudentAssignmentGrade.setBounds(210, 250, 100, 30);

        txtAssignNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtAssignNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtAssignNumber);
        txtAssignNumber.setBounds(210, 210, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Enter Exam score:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 310, 130, 30);

        txtExamScore.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtExamScoreActionPerformed(evt);
            }
        });
        getContentPane().add(txtExamScore);
        txtExamScore.setBounds(210, 310, 100, 30);

        btnSubmitExamScore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmitExamScore.setText("Submit Exam");
        btnSubmitExamScore.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSubmitExamScoreActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmitExamScore);
        btnSubmitExamScore.setBounds(360, 310, 190, 30);

        btnSubmitAssGrade1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmitAssGrade1.setText("Submit Assignment");
        btnSubmitAssGrade1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSubmitAssGrade1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmitAssGrade1);
        btnSubmitAssGrade1.setBounds(360, 230, 190, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Enter Project score:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 370, 130, 30);

        txtProjectScore.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtProjectScoreActionPerformed(evt);
            }
        });
        getContentPane().add(txtProjectScore);
        txtProjectScore.setBounds(210, 370, 100, 30);

        btnSubmitProjectScore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmitProjectScore.setText("Submit Project");
        btnSubmitProjectScore.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSubmitProjectScoreActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmitProjectScore);
        btnSubmitProjectScore.setBounds(360, 370, 190, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/matc/itdev140/icon-128x128.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(660, 230, 130, 128);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Enter student number");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 60, 150, 30);

        txtUserNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtUserNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtUserNumber);
        txtUserNumber.setBounds(630, 60, 100, 30);

        btnDisplayGrades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDisplayGrades.setText("Display All Students");
        btnDisplayGrades.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDisplayGradesActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisplayGrades);
        btnDisplayGrades.setBounds(630, 380, 190, 40);

        btnSubmitUserNamber1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmitUserNamber1.setText("Submit");
        btnSubmitUserNamber1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSubmitUserNamber1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmitUserNamber1);
        btnSubmitUserNamber1.setBounds(750, 60, 100, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("To display student Final Letter Grade push display button");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 440, 370, 30);

        btnShowFinalLetter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShowFinalLetter.setText("Display Final");
        btnShowFinalLetter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnShowFinalLetterActionPerformed(evt);
            }
        });
        getContentPane().add(btnShowFinalLetter);
        btnShowFinalLetter.setBounds(60, 480, 190, 30);

        txtFinalLetter.setEditable(false);
        txtFinalLetter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFinalLetter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtFinalLetterActionPerformed(evt);
            }
        });
        getContentPane().add(txtFinalLetter);
        txtFinalLetter.setBounds(550, 460, 270, 40);

        setSize(new java.awt.Dimension(900, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentAssignmentGradeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtStudentAssignmentGradeActionPerformed
    {//GEN-HEADEREND:event_txtStudentAssignmentGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentAssignmentGradeActionPerformed

    private void txtAssignNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtAssignNumberActionPerformed
    {//GEN-HEADEREND:event_txtAssignNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAssignNumberActionPerformed

    private void txtExamScoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtExamScoreActionPerformed
    {//GEN-HEADEREND:event_txtExamScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExamScoreActionPerformed

    private void txtProjectScoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtProjectScoreActionPerformed
    {//GEN-HEADEREND:event_txtProjectScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjectScoreActionPerformed

    private void btnSubmitAssGrade1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSubmitAssGrade1ActionPerformed
    {//GEN-HEADEREND:event_btnSubmitAssGrade1ActionPerformed
        if (txtAssignNumber.getText().equals("") || txtStudentAssignmentGrade.getText().equals("")) // checking if any empty fealds
        {
            JOptionPane.showMessageDialog(null, "Please enter assignment number and grade.", "Empty", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            assignmentNumber = Integer.parseInt(txtAssignNumber.getText());
            assignmentNumber = assignmentNumber - 1;
            assignmentGrade = Integer.parseInt(txtStudentAssignmentGrade.getText());
            updateAssignmentsScore();
            updateGradeTable();
            txtAssignNumber.setText("");
            txtStudentAssignmentGrade.setText("");
        }
    }//GEN-LAST:event_btnSubmitAssGrade1ActionPerformed

    private void btnSubmitExamScoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSubmitExamScoreActionPerformed
    {//GEN-HEADEREND:event_btnSubmitExamScoreActionPerformed
        if (txtExamScore.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please exam grade.", "Empty", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            exam = Integer.parseInt(txtExamScore.getText());
            updateExam();
            updateGradeTable();
            txtExamScore.setText("");
        }
    }//GEN-LAST:event_btnSubmitExamScoreActionPerformed

    private void btnSubmitProjectScoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSubmitProjectScoreActionPerformed
    {//GEN-HEADEREND:event_btnSubmitProjectScoreActionPerformed
        if (txtProjectScore.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please input project grade.", "Empty", JOptionPane.INFORMATION_MESSAGE);
        }else
        {
            individualProject = Integer.parseInt(txtProjectScore.getText());
            updateIndProj();
            updateGradeTable();
            txtProjectScore.setText("");
        }
    }//GEN-LAST:event_btnSubmitProjectScoreActionPerformed

    private void txtUserNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtUserNumberActionPerformed
    {//GEN-HEADEREND:event_txtUserNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNumberActionPerformed

    private void btnDisplayGradesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDisplayGradesActionPerformed
    {//GEN-HEADEREND:event_btnDisplayGradesActionPerformed
        printAll();
    }//GEN-LAST:event_btnDisplayGradesActionPerformed

    private void btnSubmitUserNamber1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSubmitUserNamber1ActionPerformed
    {//GEN-HEADEREND:event_btnSubmitUserNamber1ActionPerformed
        
        if (txtUserNumber.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill all fields.", "Empty", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                if(checkInput() == true) // checking if user enter integer
                {
                    studentSearch();
                }else
                {
                    JOptionPane.showMessageDialog(null, "Pleas enter integer number for user ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
    }//GEN-LAST:event_btnSubmitUserNamber1ActionPerformed

    private void btnShowFinalLetterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnShowFinalLetterActionPerformed
    {//GEN-HEADEREND:event_btnShowFinalLetterActionPerformed
        txtFinalLetter.setText("");
        id = Integer.parseInt(txtUserNumber.getText());
        
        calculateGrade();
        assingFinalLetter();
        
        updateGradeLetter();
        
        txtFinalLetter.setText("Final letter is " + finalLetter);
    }//GEN-LAST:event_btnShowFinalLetterActionPerformed

    private void txtFinalLetterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtFinalLetterActionPerformed
    {//GEN-HEADEREND:event_txtFinalLetterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalLetterActionPerformed

    boolean isNumber = false;
    private boolean checkInput()
    {
        try
        {
            id = Integer.parseInt(txtUserNumber.getText());
            return true;
            
        } catch (NumberFormatException e)
        {
            return false;
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(StudentGradeAdjustmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(StudentGradeAdjustmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(StudentGradeAdjustmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(StudentGradeAdjustmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new StudentGradeAdjustmentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplayGrades;
    private javax.swing.JButton btnShowFinalLetter;
    private javax.swing.JButton btnSubmitAssGrade1;
    private javax.swing.JButton btnSubmitExamScore;
    private javax.swing.JButton btnSubmitProjectScore;
    private javax.swing.JButton btnSubmitUserNamber1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTStudentGrade;
    private javax.swing.JTable jtStudentName;
    private javax.swing.JTextField txtAssignNumber;
    private javax.swing.JTextField txtExamScore;
    private javax.swing.JTextField txtFinalLetter;
    private javax.swing.JTextField txtProjectScore;
    private javax.swing.JTextField txtStudentAssignmentGrade;
    private javax.swing.JTextField txtUserNumber;
    // End of variables declaration//GEN-END:variables
}
