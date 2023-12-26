/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.data.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javalibrarymanagement.patterns.SingletonDataWorks;
import javalibrarymanagement.data.dao.MemberDao;
import javalibrarymanagement.data.model.Academician;
import javalibrarymanagement.data.model.Member;
import javalibrarymanagement.data.model.Student;


public class MemberDaoImpl implements MemberDao{
    
    private final Statement statement = SingletonDataWorks.getStatement();
    private ResultSet results;
    private Member findedMember;    
    private static MemberDao instance;
    
    public static synchronized MemberDao getInstance(){
        if (instance == null) {
            instance = new MemberDaoImpl();
        }
        return instance;
    }
    
    @Override
    public Member searchAcademician(String username, String password) { 
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
        }catch(SQLException e){
            System.err.println(e);
        }
        return findedMember;            
    }

    @Override
    public Member searchStudent(String username, String password) {
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
        }catch(SQLException e){
            System.err.println(e);
        }
        return findedMember;
    }

    @Override
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> memberList = new ArrayList<>();
        try{
            results = statement.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, d.departmantName, mrq.avaibleRequestCount, CONCAT(mrq.avaibleRequestCount+mrq.currentRequestCount) AS bookLimit, CASE WHEN a.memberID IS NOT NULL THEN 'Academician' WHEN s.memberID IS NOT NULL THEN 'Student' ELSE 'Unkown' END AS memberType, a.title, s.grade, s.studentNumber FROM library_management_system.member m LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.member_request_limit mrq ON mrq.memberID = m.memberID LEFT JOIN library_management_system.academician a ON a.memberID = m.memberID LEFT JOIN library_management_system.student s ON s.memberID = m.memberID;");
            while(results.next()){
                if("Academician".equals(results.getString("memberType"))){
                    memberList.add(new Academician(
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
                    ));
                }else if("Student".equals(results.getString("memberType"))){
                    memberList.add(new Student(
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
                    ));
                }
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return memberList;
    }

    @Override
    public ArrayList<Member> searchMembersWithID(String searchKeyword) {
        ArrayList<Member> memberList = new ArrayList<>();
        try{
            results = statement.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, d.departmantName, mrq.avaibleRequestCount, CONCAT(mrq.avaibleRequestCount+mrq.currentRequestCount) AS bookLimit, CASE WHEN a.memberID IS NOT NULL THEN 'Academician' WHEN s.memberID IS NOT NULL THEN 'Student' ELSE 'Unkown' END AS memberType, a.title, s.grade, s.studentNumber FROM library_management_system.member m LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.member_request_limit mrq ON mrq.memberID = m.memberID LEFT JOIN library_management_system.academician a ON a.memberID = m.memberID LEFT JOIN library_management_system.student s ON s.memberID = m.memberID WHERE m.memberID LIKE '%"+searchKeyword+"%'");
            while(results.next()){
                if("Academician".equals(results.getString("memberType"))){
                    memberList.add(new Academician(
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
                    ));
                }else if("Student".equals(results.getString("memberType"))){
                    memberList.add(new Student(
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
                    ));
                }
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return memberList;
    }

    @Override
    public ArrayList<Member> searchMembersWithName(String searchKeyword) {
        ArrayList<Member> memberList = new ArrayList<>();
        try{
            results = statement.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, d.departmantName, mrq.avaibleRequestCount, CONCAT(mrq.avaibleRequestCount+mrq.currentRequestCount) AS bookLimit, CASE WHEN a.memberID IS NOT NULL THEN 'Academician' WHEN s.memberID IS NOT NULL THEN 'Student' ELSE 'Unkown' END AS memberType, a.title, s.grade, s.studentNumber FROM library_management_system.member m LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.member_request_limit mrq ON mrq.memberID = m.memberID LEFT JOIN library_management_system.academician a ON a.memberID = m.memberID LEFT JOIN library_management_system.student s ON s.memberID = m.memberID WHERE CONCAT(m.memberName, ' ', m.memberSurname) LIKE '%"+searchKeyword+"%'");
            while(results.next()){
                if("Academician".equals(results.getString("memberType"))){
                    memberList.add(new Academician(
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
                    ));
                }else if("Student".equals(results.getString("memberType"))){
                    memberList.add(new Student(
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
                    ));
                }
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return memberList;
    }

    
}
