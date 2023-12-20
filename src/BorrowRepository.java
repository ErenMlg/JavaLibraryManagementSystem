import model.BookIssue;

import java.util.List;

public class BorrowRepository {

    List<BookIssue> getPersonAllBorrowings(String personID);
    void addBookIssue(BookIssue bookIssue);
    void editBookIssue(int editID ,BookIssue newBookIssue);
    void deleteBookIssue(int deleteID);

}
