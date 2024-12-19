class BorrowBookCommand implements Command {
    private Book book;

    public BorrowBookCommand(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        // Ödünç kitap mantığının uygulanması
        System.out.println("Borrowing book: " + book.getTitle());
    }
}