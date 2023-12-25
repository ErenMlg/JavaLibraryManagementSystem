package javalibrarymanagement.data.model;

public abstract class Member {

    private String memberID;
    private String memberName;
    private String memberSurname;
    private String memberPhone;
    private String memberAddress;
    private String memberMail;
    private String memberUsername;
    private String departmantName;
    private int bookLimit;
    private int avaibleRequestLimit;
    
    public Member(String memberID, String memberName, String memberSurname, String memberPhone, String memberAddress, String memberMail, String memberUsername, String departmantName, int bookLimit, int avaibleRequestLimit) {        
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberMail = memberMail;
        this.memberUsername = memberUsername;
        this.departmantName = departmantName;
        this.bookLimit = bookLimit;
        this.avaibleRequestLimit = avaibleRequestLimit;
    }
    
    public void printPersonalInfo(){
        System.out.println(
                "\nMember Identify Number: "+ memberID 
                + "\nMember Name: "+ memberName+" "+memberSurname
                + "\nMember Phone: "+ memberPhone
                + "\nMember Adress" + memberAddress
                + "\nMember Mail:" + memberMail
                + "\nMember Username: " + memberUsername
                + "\nMember Departmant: " + departmantName
                + "\nMember Book Limit:" + bookLimit);
    }
    
    public String getUserName(){
        return memberName+" "+memberSurname;
    }
    
    public String getUserID(){
        return memberID;
    }
    
    public int getMemberCurrentRight(){
        return avaibleRequestLimit;
    }
    
    public int getMemberRight(){
        return bookLimit;
    }
    
    public void setAvaibleRequestLimit(int avaibleRequestLimit) {
        this.avaibleRequestLimit = avaibleRequestLimit;
    }
    
}
