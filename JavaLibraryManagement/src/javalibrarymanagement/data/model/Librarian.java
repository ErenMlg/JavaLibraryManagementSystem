package javalibrarymanagement.data.model;

public class Librarian {

    private int memberID;
    private String memberName;
    private String memberSurname;
    private String memberPhone;
    private String memberAddress;
    private String memberMail;
    private String memberUsername;

    public Librarian(int memberID, String memberName, String memberSurname, String memberPhone, String memberAddress, String memberMail, String memberUsername) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberMail = memberMail;
        this.memberUsername = memberUsername;
    }
}
