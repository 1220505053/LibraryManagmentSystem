import java.awt.*;
import java.awt.event.*;
import java.util.List;

class LibraryUI extends Frame {
    private LibraryFacade library;
    private UserManager<User> userManager;
    private TextArea displayArea;
    private TextField inputField;

    public LibraryUI() {
        library = new LibraryFacade();
        userManager = new UserManager<>();

        // UI Components
        setLayout(new BorderLayout());
        displayArea = new TextArea();
        displayArea.setEditable(false);
        add(displayArea, BorderLayout.CENTER);

        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());
        inputField = new TextField(20);
        Button addButton = new Button("Add Book");
        Button removeButton = new Button("Remove Book");
        Button showButton = new Button("Show Catalog");
        Button searchButton = new Button("Search Book");
        Button addUserButton = new Button("Add User");
        Button showUsersButton = new Button("Show Users");
        Button borrowButton = new Button("Borrow Book");
        Button returnButton = new Button("Return Book");

        inputPanel.add(new Label("Book/User Name:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(showButton);
        inputPanel.add(searchButton);
        inputPanel.add(addUserButton);
        inputPanel.add(showUsersButton);
        inputPanel.add(borrowButton);
        inputPanel.add(returnButton);
        add(inputPanel, BorderLayout.SOUTH);

        // Event Handlers
        addButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            library.addBook(bookTitle);
            displayArea.append("Added book: " + bookTitle + "\n");
            inputField.setText("");
        });

        removeButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            library.removeBook(bookTitle);
            displayArea.append("Removed book: " + bookTitle + "\n");
            inputField.setText("");
        });

        showButton.addActionListener(e -> {
            displayArea.append("Catalog:\n");
            library.showDetails();
        });

        searchButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            List<String> results = library.searchBooks(bookTitle);
            displayArea.append("Search results:\n");
            for (String book : results) {
                displayArea.append("- " + book + "\n");
            }
        });

        addUserButton.addActionListener(e -> {
            String userName = inputField.getText();
            User user = new Student(userName, "Student"); // veya new Staff(userName, "Staff")
            userManager.addUser(user);
            displayArea.append("Added user: " + userName + "\n");
            inputField.setText("");
        });

        showUsersButton.addActionListener(e -> {
            displayArea.append("Users:\n");
            for (User user : userManager.getUsers()) {
                displayArea.append("- " + user.name + " (" + user.role + ")\n");
            }
        });

        borrowButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            Book book = new Book(bookTitle);
            Command borrowCommand = new BorrowBookCommand(book);
            borrowCommand.execute();
            displayArea.append("Borrowed book: " + bookTitle + "\n");
            inputField.setText("");
        });

        returnButton.addActionListener(e -> {
            String bookTitle = inputField.getText();
            Book book = new Book(bookTitle);
            Command returnCommand = new ReturnBookCommand(book);
            returnCommand.execute();
            displayArea.append("Returned book: " + bookTitle + "\n");
            inputField.setText("");
        });

        setTitle("Library Management System");
        setSize(600, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}