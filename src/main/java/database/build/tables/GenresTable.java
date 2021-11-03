package database.build.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import structs.Genre;

public class GenresTable {
  public static int add(Genre genre, Statement statement) throws SQLException {
    String name = genre.getName();
    String subName = genre.getSubName();
    String sql;

    int matchResult = match(name, subName, statement);

    if (matchResult > 0) return matchResult;
    else if (matchResult < 0 && subName == null)
      sql = "INSERT INTO genres (name)" + " VALUES ('" + name + "')";
    else sql = "INSERT INTO genres (name,subname)" + " VALUES ('" + name + "','" + subName + "')";

    statement.executeUpdate(sql);
    return match(name, subName, statement);
  }

  public static int match(String name, String subName, Statement statement) throws SQLException {
    ResultSet resultSet;
    String sql;

    if (subName == null) sql = "SELECT * FROM genres WHERE name='" + name + "'";
    else sql = "SELECT * FROM genres WHERE name='" + name + "' AND subname='" + subName + "'";

    resultSet = statement.executeQuery(sql);

    if (resultSet.next()) return resultSet.getInt("genre_id");
    else return -1;
  }
}
