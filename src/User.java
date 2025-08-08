

import java.util.ArrayList;


/**
 * User.java
 * 
 * Placeholder class for future enhancement.
 * 
 * Possible Features:
 * - User profiles for borrowing/returning books
 * - User authentication or account types
 * 
 * Currently not in use.
 */


//  Purpose of User.java:
// Represent a library user who can borrow and return books.

// Store user information like id, name, and a list of borrowed books.

// Support methods for interacting with LibrarySystem.



public class User {
    private int userId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println("Book \"" + book.getTitle() + "\" borrowed successfully.");
        } else {
            System.out.println("Sorry, this book is currently not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Book \"" + book.getTitle() + "\" returned successfully.");
        } else {
            System.out.println("This book was not borrowed by the user.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book book : borrowedBooks) {
                book.displayBookInfo();
            }
        }
    }
}
