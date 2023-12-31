import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                JOptionPane.showMessageDialog(null, "You have borrowed: " + book.getTitle());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not available for borrowing.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                JOptionPane.showMessageDialog(null, "You have returned: " + book.getTitle());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found or already returned.");
    }
}

public class LibraryManagementSystemGUI {
    private Library library;
    private JFrame frame;
    private JTextArea textArea;

    public LibraryManagementSystemGUI() {
        library = new Library();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Library Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton displayBooksBtn = new JButton("Display Available Books");
        JButton borrowBookBtn = new JButton("Borrow a Book");
        JButton returnBookBtn = new JButton("Return a Book");

        displayBooksBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAvailableBooks();
            }
        });

        borrowBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String borrowTitle = JOptionPane.showInputDialog("Enter the title of the book you want to borrow:");
                library.borrowBook(borrowTitle);
            }
        });

        returnBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String returnTitle = JOptionPane.showInputDialog("Enter the title of the book you want to return:");
                library.returnBook(returnTitle);
            }
        });

        buttonPanel.add(displayBooksBtn);
        buttonPanel.add(borrowBookBtn);
        buttonPanel.add(returnBookBtn);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);

        // Adding some sample books to the library
        library.addBook(new Book("Java Programming", "John Doe"));
        library.addBook(new Book("Python Basics", "Jane Smith"));
        library.addBook(new Book("Data Structures and Algorithms", "Alice Johnson"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("Animal Farm", "George Orwell"));
        library.addBook(new Book("Brave New World", "Aldous Huxley"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("Lord of the Flies", "William Golding"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("The Little Prince", "Antoine de Saint-Exupéry"));
        library.addBook(new Book("The Da Vinci Code", "Dan Brown"));
        library.addBook(new Book("Gone with the Wind", "Margaret Mitchell"));
        library.addBook(new Book("Moby-Dick", "Herman Melville"));
        library.addBook(new Book("The Adventures of Tom Sawyer", "Mark Twain"));
        library.addBook(new Book("The Picture of Dorian Gray", "Oscar Wilde"));
        library.addBook(new Book("Frankenstein", "Mary Shelley"));
        library.addBook(new Book("Dracula", "Bram Stoker"));
        library.addBook(new Book("The War of the Worlds", "H.G. Wells"));
        library.addBook(new Book("Alice's Adventures in Wonderland", "Lewis Carroll"));
    }
    

    private void displayAvailableBooks() {
        StringBuilder bookList = new StringBuilder("Available Books:\n");
        for (Book book : library.getBooks()) {
            if (book.isAvailable()) {
                bookList.append(book.getTitle()).append(" by ").append(book.getAuthor()).append("\n");
            }
        }
        textArea.setText(bookList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementSystemGUI();
            }
        });
    }
}
