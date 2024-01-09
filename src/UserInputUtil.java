package src;

/*This class implements and overrides the methods of UserInteraction interface */

import javax.swing.JOptionPane;

public class UserInputUtil implements UserInteraction {
    @Override
    /*This method uses JOptionPane.showInputDialog(prompt) to display a dialog box with 
    the specified prompt and prompt the user to enter a string input. 
    The method then returns the string input provided by the user.*/
    public String getStringInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    @Override
    /*This method uses JOptionPane.showOptionDialog() to display a dialog box with 
    the specified title, message, and a set of options. The method returns an integer 
    representing the user's choice among the options. */
    public int showOptionDialog(String title, String message, String[] options) {
        return JOptionPane.showOptionDialog(
                null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    @Override
    /*This method uses JOptionPane.showMessageDialog() to display a dialog box with the
     specified message. It is used for showing informational messages to the user. */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}

