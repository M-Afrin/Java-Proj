package src;

/*defines a set of methods that can be implemented by classes responsible for 
handling user interactions */

public interface UserInteraction {
    String getStringInput(String prompt);

    int showOptionDialog(String title, String message, String[] options);

    void showMessage(String message);
}
