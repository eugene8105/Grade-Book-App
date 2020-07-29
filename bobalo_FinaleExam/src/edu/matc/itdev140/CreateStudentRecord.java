
package edu.matc.itdev140;

import static edu.matc.itdev140.Controller.conn;
import static edu.matc.itdev140.Controller.stmt;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eugene
 */
public class CreateStudentRecord extends javax.swing.JFrame
{
    
    int[] assignment = new int[10];
    int id = 0;
    String firstName = "";
    String lastName = "";
    String grade = "";

    int assignmentNumber = 0;
    int assiGrade = 0;
    int exam = 0;
    int individualProject = 0;

    public String getGrade()
    { return grade; }

    public void setGrade(String grade)
    { this.grade = grade; }
    
    public int getAssignmentNumber()
    { return assignmentNumber; }

    public void setAssignmentNumber(int assignmentNumber)
    { this.assignmentNumber = assignmentNumber; }

    public int getExam()
    { return exam; }

    public void setExam(int exam)
    { this.exam = exam; }

    public int getIndividualProject()
    { return individualProject; }

    public void setIndividualProject(int individualProject)
    { this.individualProject = individualProject; }

    public int[] getAssignment()
    { return assignment; }

    public void setAssignment(int[] assignment)
    { this.assignment = assignment; }
    
    public int getId()
    { return id; }

    public void setId(int id)
    { this.id = id; }

    public String getFirstName()
    { return firstName; }

    public void setFirstName(String firstName)
    { this.firstName = firstName; }

    public String getLastName()
    { return lastName; }

    public void setLastName(String lastName)
    { this.lastName = lastName; }

    public JTextField getTxtStudentFirstName()
    { return txtStudentFirstName; }

    public void setTxtStudentFirstName(JTextField txtStudentFirstName)
    { this.txtStudentFirstName = txtStudentFirstName; }

    public JTextField getTxtStudentLastName()
    { return txtStudentLastName; }

    public void setTxtStudentLastName(JTextField txtStudentLastName)
    { this.txtStudentLastName = txtStudentLastName; }
   
    String TABLE_NAME_01 = "STUDENTS"; // table 1 name

    public String getTABLE_NAME_01()
    { return TABLE_NAME_01; }

    public void setTABLE_NAME_01(String TABLE_NAME_01)
    { this.TABLE_NAME_01 = TABLE_NAME_01; }
    
    String TABLE_NAME_02 = "ASSESSMENTS"; // table 2 name

    public String getTABLE_NAME_02()
    { return TABLE_NAME_02; }

    public void setTABLE_NAME_02(String TABLE_NAME_02)
    { this.TABLE_NAME_02 = TABLE_NAME_02; }


    /**
     * Creates new form CreateStudentRecord
     */
    public CreateStudentRecord()
    {
        initComponents();
    }

     public void addStudentsInfoTables()
    {
        for (int i = 0; i < assignment.length; i++)
        {
            assignment[i] = 0;
        }
        
        try
        {
            String qu1 = "INSERT INTO " + TABLE_NAME_01 + " VALUES (" + id + ",'" + firstName + "','" + lastName + "','" + grade + "')";
            System.out.println(qu1);
        
            stmt = conn.createStatement();
            stmt.execute(qu1);
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        try
        {
            String qu2 = "INSERT INTO " + TABLE_NAME_02 + " VALUES (" + id + "," + assiGrade + "," + assiGrade + "," + assiGrade +
                    "," + assiGrade + "," + assiGrade + "," + assiGrade + "," + assiGrade + "," + assiGrade + "," + assiGrade + 
                    "," + assiGrade + "," + assiGrade + "," + assiGrade + ")";
            
            System.out.println(qu2); // testing output query - form my self
            
        stmt = conn.createStatement();
        stmt.execute(qu2);
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "In query 2\n" + e);
        }
    } // end of addStudentsInfo method
     
    /**
     *  Start of Frame build
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStudentFirstName = new javax.swing.JTextField();
        txtStudentLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCreateStudent = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Student Record");
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        setName("CreateStudentRecordForm"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Create Student Record");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 11, 270, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Student First Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 100, 142, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Student Last Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 140, 133, 23);

        txtStudentFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStudentFirstName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtStudentFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentFirstName);
        txtStudentFirstName.setBounds(320, 100, 140, 23);

        txtStudentLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStudentLastName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtStudentLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentLastName);
        txtStudentLastName.setBounds(320, 140, 140, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Student assessment  categories will be created");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 190, 300, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("10 Assignments worth 50 points");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(340, 180, 178, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("1 Exam worth 300 points");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(340, 210, 139, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("1 Individual Project worth 200 points");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(340, 240, 203, 23);

        btnCreateStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreateStudent.setText("Create Student");
        btnCreateStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCreateStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateStudent);
        btnCreateStudent.setBounds(80, 230, 150, 35);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Student ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 60, 77, 23);

        txtStudentId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStudentId.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtStudentIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentId);
        txtStudentId.setBounds(320, 60, 140, 23);

        setSize(new java.awt.Dimension(585, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentFirstNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtStudentFirstNameActionPerformed
    {//GEN-HEADEREND:event_txtStudentFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentFirstNameActionPerformed

    private void txtStudentLastNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtStudentLastNameActionPerformed
    {//GEN-HEADEREND:event_txtStudentLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentLastNameActionPerformed

    
    private void btnCreateStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCreateStudentActionPerformed
    {//GEN-HEADEREND:event_btnCreateStudentActionPerformed

        if (txtStudentFirstName.getText().equals("") || txtStudentLastName.getText().equals("") || txtStudentId.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill all fields.", "Empty", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                if(checkInput() == true)
                {
                    firstName = txtStudentFirstName.getText();
                    lastName = txtStudentLastName.getText();
                    addStudentsInfoTables();
                    txtStudentFirstName.setText("");
                    txtStudentLastName.setText("");
                    txtStudentId.setText("");
                }else
                {
                    JOptionPane.showMessageDialog(null, "Pleas enter integer number for user ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } // end of else
    }//GEN-LAST:event_btnCreateStudentActionPerformed

    /**
     *  This method Validate user Input for integer
     * @return 
     */
    private boolean checkInput()
    {
        try
        {
            id = Integer.parseInt(txtStudentId.getText());
            return true;
            
        } catch (NumberFormatException e)
        {
            return false;
        }
        
    }
    
    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtStudentIdActionPerformed
    {//GEN-HEADEREND:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtStudentFirstName;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentLastName;
    // End of variables declaration//GEN-END:variables
}
