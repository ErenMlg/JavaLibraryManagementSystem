package javalibrarymanagement.data.dao;

import java.util.ArrayList;
import javalibrarymanagement.data.model.Book;


public interface BookDao {
    
    public ArrayList<Book> getAllBooks();
    
    public ArrayList<Book> searchWithName(String searchKey);
    
    public ArrayList<Book> searchWithISBN(String searchKey);
    
    public ArrayList<Book> searchWithAuthor(String searchKey);
    
    public ArrayList<Book> searchWithCategory(String searchKey);
    
    public ArrayList<Book> searchWithPublisher(String searchKey);
    
}
