import java.util.ArrayList;
import java.util.List;

class Student extends User {
    private List<String> borrowedBooks;

    public Student(String name, String role) {
        super(name, role);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
    }

    public void returnBook(String bookTitle) {
        borrowedBooks.remove(bookTitle);
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public void showDetails() {
        System.out.println("Student: " + name + ", Role: " + role);
        System.out.println("Borrowed Books: " + borrowedBooks);
    }
}