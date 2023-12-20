import model.Member;

import java.util.List;

public class MemberRepository {

    void changePersonalInformation(Member member, String editMemberID);
    void deletePerson(String deleteMemberID);
    void addPerson(Member newMember);
    List<Member> getAllPersons();
}
