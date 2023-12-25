package javalibrarymanagement.data.dao;

import javalibrarymanagement.data.model.Member;


public interface MemberDao {
    
    public Member searchAcademician(String username, String password);
    
    public Member searchStudent(String username, String password);
    
}
