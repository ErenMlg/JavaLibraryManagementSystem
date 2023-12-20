import model.Book;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BookRepository {

    List<Book> getBooks() {
        List<Book> bookList = null;
        Statement statement = DBConnection.getStatement();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT book.bookISBN, book.bookName, author.authorName, author.authorLastName, YEAR(book.publicationYear) AS \"publicationYear\", category.categoryName, publisher.publisherName, publisher.publicationLanguage, location.shelfName, location.shelfNo, location.floorNo, book.bookEdition, book.totalCopies, book.avaibleCopies FROM library_management_system.book AS book JOIN library_management_system.category AS category ON book.categoryID = category.categoryID JOIN library_management_system.book_author AS ba ON book.bookISBN = ba.bookISBN JOIN library_management_system.author AS author ON ba.authorID = author.authorID JOIN library_management_system.location AS location ON book.locationID = location.locationID JOIN library_management_system.publisher AS publisher ON book.publisherID = publisher.publisherID GROUP BY book.bookISBN, book.bookName, YEAR(book.publicationYear), book.bookEdition, book.totalCopies, book.avaibleCopies, location.shelfName, location.shelfNo, location.floorNo, category.categoryName, publisher.publisherName, publisher.publicationLanguage, author.authorName, author.authorLastName");
            while ()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Book getBookWithISBN(String ISBN);

    List<Book> getBooksWithAuthor(int authorID);

    List<Book> getBooksWithName(String bookName);

    List<Book> getBooksWithCategory(int categoryID);

    List<Book> getBooksWithLocation(int locationID);

    List<Book> getBooksWithPublisher(int publisherID);

    void addBook(Book newBook);

    void editBook(int editISBN, Book editedBook);

    void deleteBook(int deleteISBN);


}
