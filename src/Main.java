

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main.java
 * 
 * Entry point of the Library Management System.
 * 
 * Features:
 * - Provides a menu-driven interface (console)
 * - Accepts user input and interacts with LibrarySystem.java
 * 
 * Acts as a basic user interface.
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();
        ArrayList<User> users = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Available Books");
            System.out.println("3. Register New User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Borrowed Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.addBook();
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    users.add(new User(userId, userName));
                    System.out.println("User registered successfully!");
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int borrowerId = scanner.nextInt();
                    scanner.nextLine();
                    User borrower = findUser(users, borrowerId);
                    if (borrower != null) {
                        System.out.print("Enter Book ID to Borrow: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        Book bookToBorrow = findBookById(library, bookId);
                        if (bookToBorrow != null) {
                            borrower.borrowBook(bookToBorrow);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int returnerId = scanner.nextInt();
                    scanner.nextLine();
                    User returner = findUser(users, returnerId);
                    if (returner != null) {
                        System.out.print("Enter Book ID to Return: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        Book bookToReturn = findBookById(library, bookId);
                        if (bookToReturn != null) {
                            returner.returnBook(bookToReturn);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    int checkId = scanner.nextInt();
                    scanner.nextLine();
                    User user = findUser(users, checkId);
                    if (user != null) {
                        user.displayBorrowedBooks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Utility: Find a user by ID
    public static User findUser(ArrayList<User> users, int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    // Utility: Find a book by ID from the library
    public static Book findBookById(LibrarySystem library, int id) {
        for (Book book : library.getBooks()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
