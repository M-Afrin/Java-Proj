package src;

/*This class implements and overrides the methods of UserInteraction interface */

import javax.swing.JOptionPane;

public class MessageUtil implements UserInteraction {
    @Override
    /* This method is intended to obtain a string input from the user.It throws an 
    UnsupportedOperationException with the message "Not supported for showMessage." This signals that obtaining
     string input is not supported by this particular implementation. */
    public String getStringInput(String prompt) {
        throw new UnsupportedOperationException("Not supported for showMessage");
    }

    @Override
    /*This method is designed to show a dialog box with a set of options and receive the user's choice. 
    Similar to getStringInput, it throws an UnsupportedOperationException with the message "Not supported 
    for showMessage." This indicates that showing option dialogs is not supported by this implementation. */
    public int showOptionDialog(String title, String message, String[] options) {
        throw new UnsupportedOperationException("Not supported for showMessage");
    }

    @Override
    /*This method is intended to display a message to the user.It uses 
    JOptionPane.showMessageDialog(null, message) to show a dialog box with the specified message. 
    This is the only method that has a concrete implementation in this class. */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
