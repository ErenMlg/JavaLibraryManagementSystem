package javalibrarymanagement.data.dao;

import java.util.ArrayList;
import javalibrarymanagement.data.model.Member;


public interface MemberDao {
    
    public ArrayList<Member> getAllMembers();
    
    public ArrayList<Member> searchMembersWithID(String searchKeyword);
    
    public ArrayList<Member> searchMembersWithName(String searchKeyword);
    
    public Member searchAcademician(String username, String password);
    
    public Member searchStudent(String username, String password);
    
}
