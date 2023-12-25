
package javalibrarymanagement.repository.deleteRepo;

import java.sql.Statement;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.Member;

public class allDeletes {
        
    private final static Statement statement = SingletonDataWorks.getStatement();
    private static Boolean result;
    
    public static Boolean deleteRequestFromUser(String bookID, Member member){
        try{
            int avaibleRequest = member.getMemberCurrentRight()+1;
            int currentRequest = member.getMemberRight()-avaibleRequest;
            member.setAvaibleRequestLimit(avaibleRequest);
            statement.execute("UPDATE `library_management_system`.`member_request_limit` SET `currentRequestCount` = '"+currentRequest+"', `avaibleRequestCount` = '"+avaibleRequest+"' WHERE (`memberID` = '"+member.getUserID()+"');");
            result = statement.execute("DELETE FROM `library_management_system`.`book_request` WHERE `bookID` = '"+bookID+"' AND memberID='"+member.getUserID()+"';");
        }catch(Exception e){
            System.err.println(e);
        }     
        return result;
    }
    
    
}
