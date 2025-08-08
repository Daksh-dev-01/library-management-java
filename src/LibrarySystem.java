
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LibrarySystem.java
 * 
 * Handles the core functionality of the library such as:
 * - Adding books
 * - Displaying available books
 * - Searching for a book
 * - Issuing a book
 * - Returning a book
 */

 
/**
 * LibrarySystem.java
 * 
 * Manages the core library logic using an in-memory ArrayList.
 * 
 * Features:
 * - Stores and manages books (add, search, display, issue, return)
 * - Checks availability and updates book status
 * - Works as the backend logic used by Main.java
 * 
 * Limitations:
 * - Does not save data permanently (no database)
 */

 
public class LibrarySystem {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibrarySystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new book to the library
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author, true);
        books.add(book);
        System.out.println("Book added successfully!\n");
    }

    // Display all available books
    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayBookInfo();
            }
        }
        System.out.println();
    }

    // Search for a book by title
    public void searchBook() {
        System.out.println("Enter title to search: ");
        String searchTitle = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                book.displayBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.\n");
        }
    }

    // Issue a book by ID
    public void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book issued successfully!\n");
                } else {
                    System.out.println("Book is already issued.\n");
                }
                return;
            }
        }

        System.out.println("Book ID not found.\n");
    }

    // Getter for books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Return a book by ID
    public void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!\n");
                } else {
                    System.out.println("Book was not issued.\n");
                }
                return;
            }
        }

        System.out.println("Book ID not found.\n");
    }
}
