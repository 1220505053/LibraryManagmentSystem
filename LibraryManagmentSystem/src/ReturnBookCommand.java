class ReturnBookCommand implements Command {
    private Book book;

    public ReturnBookCommand(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        // İade defteri mantığının uygulanması
        System.out.println("Returning book: " + book.getTitle());
    }
}