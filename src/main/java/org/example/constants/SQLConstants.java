package org.example.constants;

public class SQLConstants {
    public static final String SQL_AUTH_QUERY = "Select * From User Where UserId = (?)";
    public static final String SQL_FETCH_ALL_BOOKS_QUERY = "Select * From Book";
    public static final String SQL_FETCH_ALL_LIBRARIAN_QUERY = "Select * From Librarian";
    public static final String SQL_FETCH_ALL_Student_QUERY = "Select * From Student";
    public static final String SQL_FETCH_ALL_ISSUE_LOGS_QUERY = "Select * From IssuedBooks";
    public static final String SQL_ADD_LIBRARIAN_QUERY = "Insert into Librarian value (?,?,?,?,?)";
    public static final String SQL_ADD_LIBRARIAN_USER_QUERY= "INSERT INTO User value (?,?,?)";

    public static final String SQL_CHECK_BOOK_ISSUED_QUERY ="SELECT COUNT(*) FROM IssuedBooks WHERE BookId =(?) and Returned = 0 ";
    public static final String SQL_DELETE_LIBRARIAN_USER_QUERY = "DELETE FROM USER WHERE UserId = (?)";

    public static final String SQL_DELETE_LIBRARIAN_QUERY = "DELETE FROM Librarian WHERE LibrarianId = (?)";

    public static final String SQL_ADD_BOOK_QUERY = "INSERT INTO Book value (?,?,?)";
    public static final String SQL_REMOVE_BOOK_QUERY = "DELETE FROM Book WHERE BookId=(?)";
    public static final String SQL_RETURN_BOOK_QUERY = "UPDATE IssuedBooks SET Returned = 1 WHERE IssueId = (?)";
    public static final String SQL_ISSUE_BOOK_QUERY = "INSERT INTO IssuedBooks (BookId,LibrarianId,StudentId) value(?,?,?) ";
    public static final String SQL_FETCH_ALL_ISSUE_BOOKS_QUERY = "SELECT * FROM IssuedBooks WHERE Returned = 0 ";
    public static final String SQL_FETCH_ISSUE_BOOKS_QUERY = "SELECT * FROM Book where BookId in (SELECT BookId FROM IssuedBooks where StudentId = (?) and Returned = 0) ";
    public static final String SQL_ADD_STUDENT_QUERY = "INSERT INTO Student value (?,?,?,?,?)";
    public static final  String SQL_FETCH_Student_QUERY = " SELECT * FROM Student WHERE StudentId =(?)";
}
