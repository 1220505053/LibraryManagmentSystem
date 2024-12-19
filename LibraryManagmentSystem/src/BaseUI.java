import java.awt.*;
import java.awt.event.*;

class BaseUI extends Frame {
    public BaseUI() {
        setLayout(new GridLayout(4, 1));

        Button libraryUIButton = new Button("Library Management");
        libraryUIButton.addActionListener(e -> new LibraryUI());

        Button studentUIButton = new Button("Student Panel");
        studentUIButton.addActionListener(e -> new StudentUI());

        Button exitButton = new Button("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        add(new Label("Select an Option:"));
        add(libraryUIButton);
        add(studentUIButton);
        add(exitButton);

        setTitle("Library Management System");
        setSize(300, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}