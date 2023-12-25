
package javalibrarymanagement.repository.getRepo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.Annoucement;
import javalibrarymanagement.data.model.Book;
import javalibrarymanagement.data.model.BookIssue;
import javalibrarymanagement.data.model.Categories;
import javalibrarymanagement.data.model.Event;
import javalibrarymanagement.data.model.Member;

public class allGets {
    
    private static Statement statement = SingletonDataWorks.getStatement();
    private static ResultSet results;

    public static ArrayList<Categories> getAllCategories(){
        ArrayList<Categories> categoryList = new ArrayList<Categories>();
        try{
            results = statement.executeQuery("SELECT * FROM library_management_system.category;");
            while(results.next()){
                categoryList.add(new Categories(
                results.getInt("categoryID"),
                results.getString("categoryName")
                ));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return categoryList;
    }
    
    
    public static ArrayList<Object[]> getMyRequests(String memberID){
        ArrayList<Object[]> resultList = new ArrayList<Object[]>();
        try{
            results = statement.executeQuery("SELECT b.bookISBN, b.bookName, CONCAT(a.authorName, ' ', a.authorLastName) AS authorName, DATE_FORMAT(br.requestDate, '%d %M %Y') AS requestDate, CASE WHEN br.requestStatus = 0 THEN 'Created' WHEN br.requestStatus = 1 THEN 'Approved' WHEN br.requestStatus = 2 THEN 'Rejected' WHEN br.requestStatus = 3 THEN 'Closed' ELSE 'Unknown Status' END AS requestStatusLabel FROM library_management_system.book_request br JOIN library_management_system.book b ON br.bookID = b.bookISBN JOIN library_management_system.book_author ba ON b.bookISBN = ba.bookISBN JOIN library_management_system.author a ON ba.authorID = a.authorID WHERE br.memberID = '"+memberID+"';");
            while(results.next()){
                Object[] row = {
                    results.getString("bookISBN"),
                    results.getString("bookName"),
                    results.getString("authorName"),
                    results.getString("requestDate"),
                    results.getString("requestStatusLabel")
                };
                resultList.add(row);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return resultList;
    }
   
    
    public static ArrayList<Book> getAllBooks(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        try{
            results = statement.executeQuery("SELECT book.bookISBN, book.bookName, CONCAT(author.authorName,' ',author.authorLastName) AS author, YEAR(book.publicationYear) AS 'publicationYear', category.categoryName, publisher.publisherName, publisher.publicationLanguage, CONCAT('Shelf:',location.shelfName, ' No:',location.shelfNo,' Floor:',location.floorNo) AS location, book.bookEdition, CASE WHEN book.avaibleCopies > 0 THEN 'Available' ELSE 'Not Available' END AS status FROM library_management_system.book AS book JOIN library_management_system.category AS category ON book.categoryID = category.categoryID JOIN library_management_system.book_author AS ba ON book.bookISBN = ba.bookISBN JOIN library_management_system.author AS author ON ba.authorID = author.authorID JOIN library_management_system.location AS location ON book.locationID = location.locationID JOIN library_management_system.publisher AS publisher ON book.publisherID = publisher.publisherID GROUP BY book.bookISBN, book.bookName, YEAR(book.publicationYear), book.bookEdition, book.totalCopies, book.avaibleCopies, location.shelfName, location.shelfNo, location.floorNo, category.categoryName, publisher.publisherName, publisher.publicationLanguage, author.authorName, author.authorLastName;");
            while(results.next()){
                bookList.add(new Book(
                        results.getString("bookISBN"),
                        results.getString("bookName"),
                        results.getString("author"),
                        results.getString("publicationYear"),
                        results.getString("categoryName"),
                        results.getString("publisherName"),
                        results.getString("publicationLanguage"),
                        results.getInt("bookEdition"),
                        results.getString("status"),
                        results.getString("location")
                    )
                );
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return bookList;
    }
    
    public static ArrayList<Event> getAllEvents(){
        ArrayList<Event> allEvents = new ArrayList<Event>();
        try{
            results = statement.executeQuery("SELECT * FROM library_management_system.events;");
            while(results.next()){
                allEvents.add(new Event(
                        results.getInt("eventID"),
                        results.getString("eventType"),
                        results.getString("eventName"),
                        results.getString("eventDesc"),
                        results.getString("eventDate"),
                        results.getInt("librarianID")
                ));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return allEvents;
    }
    
    public static ArrayList<Annoucement> getAllAnnoucements(){
        ArrayList<Annoucement> allAnnoucement = new ArrayList<Annoucement>();
        try{
            results = statement.executeQuery("SELECT * FROM library_management_system.annoucements;");
            while(results.next()){
                allAnnoucement.add(new Annoucement(
                        results.getInt("annoucementID"),
                        results.getString("annoucementsName"),
                        results.getString("annoucementsDesc"),
                        results.getString("annoucementsDate"),
                        results.getInt("librarianID")
                        
                ));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return allAnnoucement;
    }
    
    public static ArrayList<BookIssue> getMyIssues(Member member){
        ArrayList<BookIssue> allIssues = new ArrayList<BookIssue>();
        try{
            results = statement.executeQuery("SELECT bi.bookISBN, b.bookName, CASE WHEN bi.issueStatus = 0 THEN 'Borrowed' WHEN bi.issueStatus = 1 THEN 'Returned' ELSE 'Unknown Status' END AS issueStatus, bi.issueDate, bi.returnDate, CONCAT(l.librarianName, ' ', l.librarianSurname) AS librarianName, CONCAT(a.authorName, ' ', a.authorLastName) AS authorName FROM library_management_system.book_issue bi JOIN library_management_system.book b ON bi.bookISBN = b.bookISBN JOIN library_management_system.member m ON bi.memberID = m.memberID JOIN library_management_system.librarian l ON bi.librarianID = l.librarianID JOIN library_management_system.book_author ba ON ba.bookISBN = bi.bookISBN JOIN library_management_system.author a ON ba.authorID = a.authorID WHERE bi.memberID='"+member.getUserID()+"' ORDER BY bi.issueStatus");
            while(results.next()){
                allIssues.add(new BookIssue(
                    results.getString("bookISBN"),
                    results.getString("bookName"),
                    results.getString("authorName"),
                    results.getString("librarianName"),
                    results.getString("issueStatus"),
                    results.getString("issueDate"),
                    results.getString("returnDate")
                ));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return allIssues;
    }
    
    public static int getCountOfBorrowedBook(Member member, String bookID){
        int count=0;
        try{
            results = statement.executeQuery("SELECT COUNT(*) FROM `library_management_system`.`book_request` WHERE `memberID` = '" + member.getUserID() + "' AND `bookID` = '" + bookID + "'");
            results.next();
            count = results.getInt(1);
        }catch(Exception e){
            System.err.println(e);
        }
        return count;
    }
    
}
