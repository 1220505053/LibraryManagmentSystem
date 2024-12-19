import java.awt.*;
import java.awt.event.*;

class StudentUI extends Frame {
    private LibraryFacade library;
    private UserManager<Student> userManager;
    private TextArea displayArea;
    private TextField inputField;
    private Student currentStudent;

    public StudentUI() {
        library = new LibraryFacade();
        userManager = new UserManager<>();
        currentStudent = new Student("John Doe", "Student");
        userManager.addUser(currentStudent);

        // UI Components
        setLayout(new BorderLayout());
        displayArea = new TextArea();
        displayArea.setEditable(false);
        add(displayArea, BorderLayout.CENTER);

        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());
        inputField = new TextField(20);
        Button borrowButton = new Button("Borrow Book");
        Button showButton = new Button("Show Catalog");
        Button showBorrowedButton = new Button("Show Borrowed Books");

        inputPanel.add(new Label("Book Title:"));
        inputPanel.add(inputField);
        inputPanel.add(borrowButton);
        inputPanel.add(showButton);
        inputPanel.add(showBorrowedButton);
        add(inputPanel, BorderLayout.SOUTH);

        // Event Handlers
        borrowButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            Book book = new Book(bookTitle);
            Command borrowCommand = new BorrowBookCommand(book);
            borrowCommand.execute();
            currentStudent.borrowBook(bookTitle);
            displayArea.append("Borrowed book: " + bookTitle + "\n");
            inputField.setText("");
        });

        showButton.addActionListener(e -> {
            displayArea.append("Catalog:\n");
            library.showDetails();
        });

        showBorrowedButton.addActionListener(e -> {
            displayArea.append("Borrowed Books:\n");
            for (String book : currentStudent.getBorrowedBooks()) {
                displayArea.append("- " + book + "\n");
            }
        });

        setTitle("Student Panel");
        setSize(600, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}