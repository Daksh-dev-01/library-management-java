
/**
 * Book.java
 * 
 * This class represents a single book in the Library Management System.
 * It encapsulates key attributes and methods related to a book.
 * 
 * Key Features:
 * - Stores book ID, title, author, and availability status
 * - Provides getter and setter methods for each attribute
 * - Includes a method to display book information in a readable format
 * - Helps the system track which books are available or issued
 * 
 * Used by: LibrarySystem.java to manage books in the library database
 */


public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default when book is added
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Display method
    public void displayBookInfo() {
        System.out.println("[" + id + "] " + title + " by " + author +" | " + (isAvailable ? "Available" : "Issued"));
    }
}
