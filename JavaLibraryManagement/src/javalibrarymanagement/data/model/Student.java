package javalibrarymanagement.data.model;


public class Student extends Member{
    
    private int grade;
    private String studentNumber;

    public Student(String memberID, String memberName, String memberSurname, String memberPhone, String memberAddress, String memberMail, String memberUsername, String departmantName, int bookLimit, int grade, String studentNumber) {
        super(memberID, memberName, memberSurname, memberPhone, memberAddress, memberMail, memberUsername, departmantName, bookLimit);
        this.grade = grade;
        this.studentNumber = studentNumber;
    }
    

    @Override
    public void printPersonalInfo() {
        super.printPersonalInfo();
        System.out.println("\nStudent Grade: "+grade+"\nStudent Number: "+studentNumber);
    }
    
}
