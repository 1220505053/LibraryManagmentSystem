import java.util.List;

class LibraryFacade {
    private final LibraryCatalog catalog;

    public LibraryFacade() {
        this.catalog = LibraryCatalog.getInstance();
    }

    public void addBook(String book) {
        catalog.addBook(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(String book) {
        catalog.removeBook(book);
        System.out.println("Book removed: " + book);
    }

    public void showDetails() {
        List<String> books = catalog.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("Books in catalog:");
            books.forEach(book -> System.out.println("- " + book));
        }
    }

    public void requestState(Book book) {
        System.out.print("Book: " + book.getTitle() + " - ");
        book.requestState();
    }

    public List<String> searchBooks(String title) {
        return catalog.searchBooks(title);
    }
}