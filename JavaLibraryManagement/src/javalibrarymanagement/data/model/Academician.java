package javalibrarymanagement.data.model;


public class Academician extends Member{

    private String title;
    
    public Academician(String memberID, String memberName, String memberSurname, String memberPhone, String memberAddress, String memberMail, String memberUsername, String departmantName, int bookLimit, String title) {
        super(memberID, memberName, memberSurname, memberPhone, memberAddress, memberMail, memberUsername, departmantName, bookLimit);
        this.title = title;
    }
    
}
