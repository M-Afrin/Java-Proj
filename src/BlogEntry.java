package src;
/*This class take date, title, content from the user. */
public class BlogEntry
 {
    private String date; 
    private String title;
    private String content;

public BlogEntry(String date, String title, String content) 
{
        this.date = date;
        this.title = title;
        this.content = content;
    }
    //Encapsulation 
public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nTitle: " + title + "\nContent: " + content;
    }
}

