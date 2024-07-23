import java.util.HashMap;
import java.util.Scanner;

class Store {
    String title;
    int isbn;

    public Store(int isbn, String title){
        this.isbn = isbn;
        this.title = title;

    }

    @Override
    public String toString() {
        return "Title: " + title + " ID: " + isbn;
    }
}


public class LibraryHashMap {

    public void addBook(Store store) {
        bookMap.put(store.isbn, store);
        System.out.println("Book Added: " + store);
    }

    public void updateBook(int isbn, String title){
        Store store = bookMap.get(isbn);
        if(store!=null){
            store.title = title;
            System.out.println("Book Updated: " + store);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found");
        }
    }

    public Store getBook(int isbn){
        return bookMap.get(isbn);
    }

    public void displayBook(){
        if(bookMap.isEmpty()){
            System.out.println("No Books in the library");
        } else {
            System.out.println("Books in the library are: \n");
            for(Store store : bookMap.values()){
                System.out.println(store);
            }
        }
    }
    HashMap<Integer, Store> bookMap= new HashMap<>();
    public static void main(String[] args) {
        LibraryHashMap library = new LibraryHashMap();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Update a book");
            System.out.println("3. Retrieve a book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the title");
                    String title = sc.nextLine();
                    System.out.println("Enter the ISBN");
                    int isbn = sc.nextInt();
                    Store newBook = new Store(isbn, title);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.println("Enter the ISBN of book you want to update");
                    int updateisbn = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new title");
                    String updateTitle = sc.nextLine();
                    library.updateBook(updateisbn, updateTitle);
                    break;
                case 3 :
                    System.out.println("Enter the ISBN of book you want to retrieve");
                    int retrieveisbn = sc.nextInt();
                    Store retrieveBook  = library.getBook(retrieveisbn);
                    if (retrieveBook!=null){
                        System.out.println("Book details: " + retrieveBook);
                    } else {
                        System.out.println("No Book found");
                    }
                    break;
                case 4:
                    library.displayBook();
                    break;
                case 5:
                    System.out.println("Exiting....");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
