
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
public class DisplayAllStudents extends javax.swing.JFrame
{
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; // driver location for Derby DB
    public static final String JDBC_URL = "jdbc:derby:GradeBook;create=true"; // URL and name of DB must to be created - Relativity
    public static Connection conn;
    private static Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    
    
    
    public DisplayAllStudents()
    {
        initComponents();
        printAll();
    }
    
    /**
     *  printAll method is selecting all from STUDENTS table
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
        
        String sql = "SELECT * FROM STUDENTS";
        try
        {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            jTableAll.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAll = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jTableAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTableAll);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 20, 750, 410);

        setSize(new java.awt.Dimension(863, 504));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAll;
    // End of variables declaration//GEN-END:variables
}
