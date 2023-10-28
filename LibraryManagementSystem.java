// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Available: " + (available ? "Yes" : "No");
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added to the library: " + book);
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrow();
                System.out.println("You have successfully borrowed the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnBook();
                System.out.println("You have successfully returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already available in the library.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("List of available books in the library:");
            for (Book book : books) {
                if (book.isAvailable()) {
                    System.out.println(book);
                }
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. List available books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    System.out.println("Thank you for using the Library Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
