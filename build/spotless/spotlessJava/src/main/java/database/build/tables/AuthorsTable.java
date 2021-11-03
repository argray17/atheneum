package database.build.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorsTable {

  public static int add(String author, Statement statement) throws SQLException {
    int matchResult = match(author, statement);
    if (matchResult > 0) return matchResult;

    String sql = "INSERT INTO authors (name)" + " VALUES ('" + author + "')";

    statement.executeUpdate(sql);

    return match(author, statement);
  }

  public static int match(String author, Statement statement) throws SQLException {
    String sql = "SELECT * FROM authors WHERE name='" + author + "'";
    ResultSet resultSet = statement.executeQuery(sql);

    if (resultSet.next()) return resultSet.getInt("author_id");
    else return -1;
  }
}
