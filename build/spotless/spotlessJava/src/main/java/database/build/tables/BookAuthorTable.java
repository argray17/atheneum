package database.build.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookAuthorTable {

  public static int add(int bookID, int authorID, Statement statement) throws SQLException {
    int matchResult = match(bookID, authorID, statement);
    if (matchResult > 0) return matchResult;

    String sql =
        "INSERT INTO authors_fk_books (books_fk, authors_fk)"
            + " VALUES ("
            + bookID
            + ","
            + authorID
            + ")";
    statement.executeUpdate(sql);

    return match(bookID, authorID, statement);
  }

  public static int match(int bookID, int authorID, Statement statement) throws SQLException {
    String sql =
        "SELECT * FROM authors_fk_books WHERE books_fk=" + bookID + " AND authors_fk=" + authorID;
    ResultSet resultSet = statement.executeQuery(sql);

    if (resultSet.next()) return resultSet.getInt("books_fk");
    else return -1;
  }
}
