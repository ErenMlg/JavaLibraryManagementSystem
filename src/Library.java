import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Library {

    public void displayBooks() {
        int bookNumber = 1;
        try {
            Statement statement = DBConnection.getDBConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT book.bookISBN, book.bookName, author.authorName, author.authorLastName, YEAR(book.publicationYear) AS \"publicationYear\", category.categoryName, publisher.publisherName, publisher.publicationLanguage, location.shelfName, location.shelfNo, location.floorNo, book.bookEdition, book.totalCopies, book.avaibleCopies FROM library_management_system.book AS book JOIN library_management_system.category AS category ON book.categoryID = category.categoryID JOIN library_management_system.book_author AS ba ON book.bookISBN = ba.bookISBN JOIN library_management_system.author AS author ON ba.authorID = author.authorID JOIN library_management_system.location AS location ON book.locationID = location.locationID JOIN library_management_system.publisher AS publisher ON book.publisherID = publisher.publisherID GROUP BY book.bookISBN, book.bookName, YEAR(book.publicationYear), book.bookEdition, book.totalCopies, book.avaibleCopies, location.shelfName, location.shelfNo, location.floorNo, category.categoryName, publisher.publisherName, publisher.publicationLanguage, author.authorName, author.authorLastName");
            System.out.println("All Books in the library;\n" +
                    "----------------------------------------------------");
            while (resultSet.next()) {
                System.out.println("\n"+bookNumber+")");
                bookNumber++;
                System.out.println("ISBN: " + resultSet.getString("bookISBN")
                        + "\nName: " + resultSet.getString("bookName")
                        + "\nAuthor Name: " + resultSet.getString("authorName") + " " + resultSet.getString("authorLastName")
                        + "\nPublication Year: " + resultSet.getString("publicationYear")
                        + "\nCategory Name: "+ resultSet.getString("categoryName")
                        + "\nPublisher Name: "+ resultSet.getString("publisherName")
                        + "\nPublication Language: "+ resultSet.getString("publicationLanguage")
                        + "\nShelf Name: "+ resultSet.getString("shelfName")
                        + "\nShelf No: "+ resultSet.getString("shelfNo")
                        + "\nFloor No: "+ resultSet.getString("floorNo")
                        + "\nEdition: " + resultSet.getString("bookEdition")
                        + "\nTotal Copy In The Library: " + resultSet.getString("totalCopies")
                        + "\nAvailable Copy In The Library: " + resultSet.getString("avaibleCopies"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
