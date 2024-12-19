import java.util.ArrayList;
import java.util.List;

class LibraryCatalog {
    private static class Holder {
        private static final LibraryCatalog INSTANCE = new LibraryCatalog();
    }

    private List<String> books = new ArrayList<>();

    private LibraryCatalog() {
        // Adding some books to the catalog
        addBook("Sefiller");
        addBook("Atsiz Atsiz");
        addBook("Karamazov Kardesler");
        addBook("Kucuk Prens");
        addBook("Aci");
        addBook("Kurtlar Vadisi");
    }

    public static LibraryCatalog getInstance() {
        return Holder.INSTANCE;
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> searchBooks(String title) {
        List<String> result = new ArrayList<>();
        for (String book : books) {
            if (book.toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}