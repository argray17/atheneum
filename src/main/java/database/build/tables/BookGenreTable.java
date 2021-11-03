package database.build.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookGenreTable {
  public static int add(int bookID, int genreID, int tagCount, Statement statement)
      throws SQLException {
    int matchResult = match(bookID, genreID, statement);
    if (matchResult > 0) return matchResult;

    String sql =
        "INSERT INTO genres_fk_books (book_fk, genre_fk, tag_count)"
            + " VALUES ("
            + bookID
            + ","
            + genreID
            + ","
            + tagCount
            + ")";
    statement.executeUpdate(sql);

    return match(bookID, genreID, statement);
  }

  public static int match(int bookID, int genreID, Statement statement) throws SQLException {
    String sql =
        "SELECT * FROM genres_fk_books WHERE book_fk=" + bookID + " AND genre_fk=" + genreID;
    ResultSet resultSet = statement.executeQuery(sql);

    if (resultSet.next()) return resultSet.getInt("book_fk");
    else return -1;
  }
}
