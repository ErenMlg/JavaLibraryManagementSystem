/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.data.model;

public class BookIssue {

    public String getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public String getStatus() {
        return status;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
    private String ISBN;
    private String bookName;
    private String authorName;
    private String librarianName;
    private String status;
    private String borrowingDate;
    private String returnDate;
    
    public BookIssue(String ISBN, String bookName, String authorName, String librarianName, String status, String borrowingDate, String returnDate) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.authorName = authorName;
        this.librarianName = librarianName;
        this.status = status;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }
}