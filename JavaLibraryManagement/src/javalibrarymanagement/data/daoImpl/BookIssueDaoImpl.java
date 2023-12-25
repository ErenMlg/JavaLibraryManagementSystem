package javalibrarymanagement.data.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javalibrarymanagement.patterns.SingletonDataWorks;
import javalibrarymanagement.data.dao.BookIssueDao;
import javalibrarymanagement.data.model.BookIssue;
import javalibrarymanagement.data.model.Member;


public class BookIssueDaoImpl implements BookIssueDao{
    
    private final Statement statement = SingletonDataWorks.getStatement();
    private ResultSet results;
    private static BookIssueDao instance;
    
    public static synchronized BookIssueDao getInstance(){
        if (instance == null) {
            instance = new BookIssueDaoImpl();
        }
        return instance;
    }
    
    @Override
    public ArrayList<BookIssue> getMyIssues(Member member) {
        ArrayList<BookIssue> allIssues = new ArrayList<>();
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
        }catch(SQLException e){
            System.err.println(e);
        }
        return allIssues;
    }
    
}
