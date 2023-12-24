/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.data.model;

public class BookIssue {
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
