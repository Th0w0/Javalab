package aims.media;


import aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    
    private List<String> authors;
    public Book(String title, String category, List<String> authors, float cost) {
        super(title, category, cost);
        this.authors = authors;
    }

    // Getters and setters
    
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    
    public void addAuthor(String authorName) {
        if (!this.authors.contains(authorName)) {
            this.authors.add(authorName);
        }
    }
    
    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.remove(authorName);
        } else {
            System.out.println("Author " + authorName + " is not found in the list of authors for this book.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Thungu");
    }
}