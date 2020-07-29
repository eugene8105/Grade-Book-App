
package edu.matc.itdev140;

import javax.swing.JOptionPane;

/**
 *
 * @author Eugene
 */
public class Info
{   
    private String aboutDeveloper;
    private String directions;
    private String version;
    private String help;
    
    /**
     * Info about developer
     */
    public void developer()
    {
        aboutDeveloper = "\tDeveloper:  \t\t\tEugene Bobalo." + 
                         "\nContact information:  \t\teugenebobalo@gmail.com" +
                                        "\n\t\tGrade Book App.";
        JOptionPane.showMessageDialog(null, aboutDeveloper, "Developer", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Info about Application
     */
    public void aboutApp()
    {
        directions =                    "#########################################################################" +
                                        "\n\tThis is a Grade Book App." +
                                        "\n\tThis application will allow an instructor to create a grade book. \n" +
                                        "\tIt will contain entries for up to thirty different students." +
                                        "\n\tAn instructor will be able to input numeric scores for different assessment categories" + 
                                        "\n\tfor a student and then determine a letter grade for the student base on the total score for all assessments." + 
                                        "#########################################################################";
        
        JOptionPane.showMessageDialog(null, directions, "About App", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    /**
     * Information about app version 
     */
    public void appVersion()
    {
        version = "#####################################" +
                                        "\n\t\tVersion 1.0\t\t" +
                                   "\n#####################################";
        
        JOptionPane.showMessageDialog(null, version, "Version", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Info if you need a help
     */
    public void forHelp()
    {
        help = "For help support contact application developer!\n"
                        + "Application developer information located under - Developer menu bar!";
        
        JOptionPane.showMessageDialog(null, help, "Sorry", JOptionPane.INFORMATION_MESSAGE);
    }
    
} // end of Info class
