class Book extends LibraryItem implements Borrowable {
    private String author;
    private String isbn;
    private boolean available;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    @Override
    public String getDetails() {
        return "Book - " + super.toString() + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("You have borrowed: " + getTitle());
        } else {
            System.out.println("This book is currently unavailable.");
        }
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("You have returned: " + title);
    }

    public String getTitle() {
        return super.toString();
    }
}