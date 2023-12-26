package javalibrarymanagement.data;

import java.util.ArrayList;
import javalibrarymanagement.data.dao.*;
import javalibrarymanagement.data.daoImpl.*;
import javalibrarymanagement.data.model.Annoucement;
import javalibrarymanagement.data.model.Book;
import javalibrarymanagement.data.model.BookIssue;
import javalibrarymanagement.data.model.BorrowRequest;
import javalibrarymanagement.data.model.Categories;
import javalibrarymanagement.data.model.Event;
import javalibrarymanagement.data.model.Librarian;
import javalibrarymanagement.data.model.Member;

public class LibraryService {
    private final BookDao bookDao;
    private final AnnoucementDao annoucementDao;
    private final BookIssueDao bookIssueDao;
    private final BorrowRequestDao borrowRequestDao;
    private final CategoryDao categoryDao;
    private final EventDao eventDao;
    private final MemberDao memberDao;
    private final LibrarianDao librarianDao;

    public LibraryService() {
        bookDao = BookDaoImpl.getInstance();
        annoucementDao = AnnoucementDaoImpl.getInstance();
        bookIssueDao = BookIssueDaoImpl.getInstance();
        borrowRequestDao = BorrowRequestDaoImpl.getInstance();
        categoryDao = CategoryDaoImpl.getInstance();
        eventDao = EventDaoImpl.getInstance();
        memberDao = MemberDaoImpl.getInstance();
        librarianDao = LibrarianDaoImpl.getInstance();
    }
    
    public ArrayList<Annoucement> getAllAnnoucements(){
        return annoucementDao.getAllAnnoucements();
    }
    
    public ArrayList<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
    
    public ArrayList<Book> searchWithName(String searchKey){
        return bookDao.searchWithName(searchKey);        
    }
    
    public ArrayList<Book> searchWithISBN(String searchKey){
        return bookDao.searchWithISBN(searchKey);       
    }
    
    public ArrayList<Book> searchWithAuthor(String searchKey){
        return bookDao.searchWithAuthor(searchKey);       
    }
    
    public ArrayList<Book> searchWithCategory(String searchKey){
        return bookDao.searchWithCategory(searchKey);       
    }
    
    public ArrayList<Book> searchWithPublisher(String searchKey){
        return bookDao.searchWithPublisher(searchKey);       
    }
    
     public ArrayList<BookIssue> getMyIssues(Member member){
         return bookIssueDao.getMyIssues(member);
     }
     
         
    public ArrayList<BorrowRequest> getMemberRequests(String memberID){
        return borrowRequestDao.getMemberRequests(memberID);
    }
    
    public Boolean isSelectedBookRequested(Member member, String bookID){
        return borrowRequestDao.isSelectedBookRequested(member, bookID);
    }
    
    public Boolean createBorrowRequest(String bookID, Member member, String requestDate){
        return borrowRequestDao.createBorrowRequest(bookID, member, requestDate);
    }
    
    public Boolean deleteBorrowRequestFromUser(String bookID, Member member){
        return borrowRequestDao.deleteBorrowRequestFromUser(bookID, member);
    }
    
    public ArrayList<Categories> getAllCategories(){
        return categoryDao.getAllCategories();
    }
    
    public ArrayList<Event> getAllEvents(){
        return eventDao.getAllEvents();
    }
    
    public ArrayList<Member> getAllMembers(){
        return memberDao.getAllMembers();
    }
    
    public Member searchAcademician(String username, String password){
        return memberDao.searchAcademician(username, password);
    }
    
    public Member searchStudent(String username, String password){
        return memberDao.searchStudent(username, password);
    }
    
    public ArrayList<Member> searchMembersWithName(String searchKeyword){
        return memberDao.searchMembersWithName(searchKeyword);
    }

    public ArrayList<Member> searchMembersWithID(String searchKeyword){
        return memberDao.searchMembersWithID(searchKeyword);
    }
    
     public Librarian searchLibrarian(String username, String password){
         return librarianDao.searchLibrarian(username, password);
     }
    
     
    
}
