import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;
    int price;

    public Book(String title, String author, String isbn, int price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }



    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
    }
}

class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(String isbn) throws ProductNotFoundException{
        Book bookToRemove = null;
        int bookCount = books.size();
        for (int i = 0; i < bookCount; i++) {
            Book book = books.get(i);
            if (book.isbn.equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove);
        } else {
            throw new ProductNotFoundException("Book with ISBN "+ isbn+ " not found");
        }
    }

    public void displayBooks() {
        int bookCount = books.size();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < bookCount; i++) {
                Book book = books.get(i);
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter book price: ");
                    int price = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    Book newBook = new Book(title, author, isbn, price);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = sc.nextLine();
                    try {
                        library.removeBook(isbnToRemove);
                    } catch (ProductNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
