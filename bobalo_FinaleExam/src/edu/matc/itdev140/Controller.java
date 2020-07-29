

package edu.matc.itdev140;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eugene
 */
public class Controller
{
    StudentRecordForm gradeBook = new StudentRecordForm();
    StudentGradeAdjustmentForm gradeAdj = new StudentGradeAdjustmentForm();
    StudentRecordForm stRecord = new StudentRecordForm();
    CreateStudentRecord stCrate = new CreateStudentRecord();
    
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; // driver location for Derby DB
    public static final String JDBC_URL = "jdbc:derby:GradeBook;create=true"; // URL and name of DB must to be created - GradeBook
    public static Connection conn = null;
    public static Statement stmt = null;

    public ResultSet rs = null;
    PreparedStatement st = null;

    public Controller()
    {
        runApp();
    }
    
    public void runApp()
    {
        gradeAdj.assignment.equals(0);
        gradeBook.setVisible(true); // running main form - StudentRecordForm
        createConnection();  // creating connection
        setupTable();  // creating tables
        stCrate.grade = gradeAdj.finalLetter;
    }
    
    /**
     * Creating connection to database
     */
    public void createConnection()
    {
        try
        {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(JDBC_URL);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     *  Creating tables and columns inside of created database
     */
    public void setupTable()
    {
        String TABLE_NAME_01 = "STUDENTS";
        String TABLE_NAME_02 = "ASSESSMENTS";
        
        try
        {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet table_01 = dbm.getTables(null, null, TABLE_NAME_01.toUpperCase(), null);
            ResultSet table_02 = dbm.getTables(null, null, TABLE_NAME_02.toUpperCase(), null);
            
            if(table_01.next() && table_02.next())
            {
                JOptionPane.showMessageDialog(null, "Table " + TABLE_NAME_01 + " or table " + TABLE_NAME_02 + " already exist.", "", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                // first table
                stmt.execute("CREATE TABLE " + TABLE_NAME_01 + " (ID INTEGER PRIMARY KEY, FirstName VARCHAR(40), LastName VARCHAR(40), Grade VARCHAR(10))");
                // second table
                stmt.execute("CREATE TABLE " + TABLE_NAME_02 + " (ID INTEGER PRIMARY KEY, As01 INTEGER, As02 INTEGER, As03 INTEGER, "
                        + "As04 INTEGER, As05 INTEGER, As06 INTEGER, As07 INTEGER, As08 INTEGER, As09 INTEGER, As10 INTEGER, "
                        + "Exam INTEGER, IndProj INTEGER)");
                
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Problem create table/columns - " + e, "", JOptionPane.INFORMATION_MESSAGE);
        }finally
        {
            
        }
        
    } // end of setupTable method
    
        public ResultSet execQuery(String query)
        {
                        
            ResultSet result = null;
            
            try
            {
                stmt = conn.createStatement();
                result = stmt.executeQuery(query);
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            } 
           
            return result;
        } // end of execQuery method
    
        
        /**
         *  method execAction execute query which you passing ass a string.
         *  I did not use this method but nice to have one. 
         * @param qu 
         */
    public void execAction(String qu)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute(qu);
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    } // end of execAction method
    
    
    public void closeDB()
    {
        try
        {
            conn.close();

        } catch (SQLException ex)
        {
            Logger.getLogger(Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
} // end of Controller
