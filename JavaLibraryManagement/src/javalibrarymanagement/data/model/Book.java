package javalibrarymanagement.data.model;

public class Book {
    private String bookISBN;
    private String bookName;
    private String author;
    private String publicationYear;
    private String categoryName;
    private String publisherName;
    private String publicationLanguage;
    private int bookEdition;
    private String status;
    private String location;

    public Book(String bookISBN, String bookName, String author, String publicationYear, String categoryName, String publisherName, String publicationLanguage, int bookEdition, String status, String location) {
        this.bookISBN = bookISBN;
        this.bookName = bookName;
        this.author = author;
        this.publicationYear = publicationYear;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
        this.publicationLanguage = publicationLanguage;
        this.bookEdition = bookEdition;
        this.status = status;
        this.location = location;
    }
    
        public String getBookISBN() {
        return bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublicationLanguage() {
        return publicationLanguage;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }
}
