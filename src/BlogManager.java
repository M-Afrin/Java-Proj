package src;
/*This class is a basic container for holding information about a blog post, including 
its date, title, and content. It offers methods for accessing and displaying these details. In a blog 
management system, we created instances of this class to represent individual blog entries. */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BlogManager {
    private String userName;
    private ArrayList<BlogEntry> blogEntries = new ArrayList<>();
    private UserInteraction userInteraction;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

    public BlogManager(UserInteraction userInteraction) {
        this.userInteraction = userInteraction;
    }
    
    //Encapsulation (getter-setter method)
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    //Exception Handling
    public void createBlogEntry() {
        try {
            String dateStr = userInteraction.getStringInput("Enter the date (yyyy-mm-dd):");
            Date date = parseDate(dateStr);

            if (date == null) {
                throw new IllegalArgumentException("Invalid date format. Please use yyyy-mm-dd.");
            }

            String title = userInteraction.getStringInput("Enter the title:");
            if (title.isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty.");
            }

            String content = userInteraction.getStringInput("Enter the content:");
            if (content.isEmpty()) {
                throw new IllegalArgumentException("Content cannot be empty.");
            }

            BlogEntry blogEntry = new BlogEntry(DATE_FORMAT.format(date), title, content);
            blogEntries.add(blogEntry);
            userInteraction.showMessage("Blog Entry Created:\n" + blogEntry);

        } catch (IllegalArgumentException e) {
            userInteraction.showMessage("Error: " + e.getMessage());
        }
    }
    //parse a string representation of a date into a Date object
    private Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public void viewAllBlogEntries() {
        if (blogEntries.isEmpty()) {
            userInteraction.showMessage("No blog entries available.");
        } else {
            StringBuilder allEntries = new StringBuilder("All Blog Entries:\n");
            for (int i = 0; i < blogEntries.size(); i++) {
                BlogEntry entry = blogEntries.get(i);
                allEntries.append("Entry ").append(i + 1).append(":\n").append(entry).append("\n\n");
            }
            userInteraction.showMessage(allEntries.toString());
        }
    }

    public void runBlogApp() {
        userInteraction.showMessage("Welcome to Personal Blogging Platform!");
        setUserName(userInteraction.getStringInput("Please enter your name:"));
        userInteraction.showMessage("Welcome, " + getUserName() + "!");

        while (true) {
            String[] options = {"1. Create Blog Entry", "2. View All Blog Entries", "3. Exit"};
            int choice = userInteraction.showOptionDialog("Main Menu", "Choose an option:", options);

            switch (choice) {
                case 0:
                    createBlogEntry();
                    break;
                case 1:
                    viewAllBlogEntries();
                    break;
                case 2:
                    userInteraction.showMessage("Thank you for using Personal Blogging Platform!");
                    System.exit(0);
                    break;
                default:
                    userInteraction.showMessage("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
