package src;

/*This class contains the main method that sets up user interaction handling and initiates the execution of 
the blog management application by creating an instance of `BlogManager` and calling its 
`runBlogApp` method. */

public class BloggingPlatform {
    public static void main(String[] args) {
        UserInteraction userInteraction = new UserInputUtil(); 
        BlogManager blogManager = new BlogManager(userInteraction);
        blogManager.runBlogApp();
    }
}







