import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Book1 {
    String title;
    String author;
    String isbn;
    int price;
    String genre;
    public Book1(String title, String author, String isbn, int price, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.genre = genre;
    }
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price + ", Genre: "+ genre;
    }
}


public class LibraryHashSet {
    ArrayList<Book1> books = new ArrayList<>();
    HashSet<String> genres = new HashSet<>();
    public void addBook(Book1 book) {
        books.add(book);
        genres.add(book.genre);
        System.out.println("Book added: " + book);
    }

    public void removeBook(String isbn) throws ProductNotFoundException{
        Book1 bookToRemove = null;
        int bookCount = books.size();
        for (int i = 0; i < bookCount; i++) {
            Book1 book = books.get(i);
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

    public void displaygenre() {
        String[] genreList = genres.toArray(new String[0]);
        if (genres.isEmpty()){
            System.out.println("No Genres Present");
        } else {
            for (int i = 0; i < genreList.length ; i++) {
                String genre = genreList[i];
                System.out.println(genre);
            }
        }
    }

    public void displayBooks() {
        int bookCount = books.size();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < bookCount; i++) {
                Book1 book = books.get(i);
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryHashSet library = new LibraryHashSet();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Display all genre");
            System.out.println("5. Exit");
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
                    System.out.print("Enter book genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter book price: ");
                    int price = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    Book1 newBook = new Book1(title, author, isbn, price, genre);
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
                    library.displaygenre();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
