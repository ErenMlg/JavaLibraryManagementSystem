/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.repository.createRepo;

import java.sql.ResultSet;
import java.sql.Statement;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.Member;

public class allCreates {
    
    private final static Statement statement = SingletonDataWorks.getStatement();
    private static Boolean result;
    
    public static Boolean createBorrowRequest(String bookID, Member member, String requestDate){
        try{
            String insertQuery = "INSERT INTO `library_management_system`.`book_request` (`bookID`, `memberID`, `requestDate`, `requestStatus`) VALUES ('" + bookID + "', '" + member.getUserID() + "', '" + requestDate + "', '0')";
            result = statement.execute(insertQuery);
            int avaibleRequest = member.getMemberCurrentRight()-1;
            int currentRequest = member.getMemberRight()-avaibleRequest;
            member.setAvaibleRequestLimit(avaibleRequest);
            statement.execute("UPDATE `library_management_system`.`member_request_limit` SET `currentRequestCount` = '"+currentRequest+"', `avaibleRequestCount` = '"+avaibleRequest+"' WHERE (`memberID` = '"+member.getUserID()+"');");
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }
    
    
}
