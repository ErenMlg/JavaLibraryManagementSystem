/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.repository.searchRepo;

import java.sql.ResultSet;
import java.sql.Statement;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.Academician;
import javalibrarymanagement.data.model.Member;
import javalibrarymanagement.data.model.Student;


public class allSearch {
    
    private final static Statement statement = SingletonDataWorks.getStatement();
    private static ResultSet results;
    private static Member findedMember;
    
    public static Member searchAcademician(String username, String password){
        try{
            results = statement.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, m.memberPassword, d.departmantName, b.bookLimit, a.title, mrq.avaibleRequestCount FROM library_management_system.member m JOIN library_management_system.academician a ON m.memberID = a.memberID LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.book_limit b ON m.bookLimitID = b.bookLimitID LEFT JOIN library_management_system.member_request_limit mrq ON m.memberID = mrq.memberID WHERE m.memberUserName = '"+username+"'  AND m.memberPassword = '"+password+"';");
            if(results.next()){
                findedMember = new Academician(
                            results.getString("memberID"),
                            results.getString("memberName"),
                            results.getString("memberSurname"),
                            results.getString("memberPhone"),
                            results.getString("memberAdress"),
                            results.getString("memberMail"),
                            results.getString("memberUsername"),
                            results.getString("departmantName"),
                            results.getInt("bookLimit"),
                            results.getInt("avaibleRequestCount"),
                            results.getString("title")
                    );
            }else{
                return null;
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return findedMember;
    }   
    
    
    public static Member searchUser(String username, String password){
        try{
            results = statement.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, m.memberPassword, d.departmantName, b.bookLimit, s.grade, s.studentNumber, mrq.avaibleRequestCount FROM library_management_system.member m JOIN library_management_system.student s ON m.memberID = s.memberID LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.book_limit b ON m.bookLimitID = b.bookLimitID LEFT JOIN library_management_system.member_request_limit mrq ON m.memberID = mrq.memberID WHERE m.memberUserName = '"+username+"'  AND m.memberPassword = '"+password+"';");
            if(results.next()){
                findedMember = new Student(
                        results.getString("memberID"),
                        results.getString("memberName"),
                        results.getString("memberSurname"),
                        results.getString("memberPhone"),
                        results.getString("memberAdress"),
                        results.getString("memberMail"),
                        results.getString("memberUsername"),
                        results.getString("departmantName"),
                        results.getInt("bookLimit"),  
                        results.getInt("avaibleRequestCount"),
                        results.getInt("grade"),
                        results.getString("studentNumber")
                    );
            }else{
                return null;
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return findedMember;
    }   
}
