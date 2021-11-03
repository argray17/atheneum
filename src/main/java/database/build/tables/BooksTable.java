package database.build.tables;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import structs.Book;

public class BooksTable {
  public static int add(Book book, Statement statement) throws SQLException {
    String title = book.getTitle();
    String editionLanguage = book.getEditionLanguage();
    String description = book.getDescription();
    float ratingScore = book.getRatingScore();
    int ratingVotes = book.getRatingVotes();
    int reviewCount = book.getReviewCount();
    Date yearPublished = new Date(book.getYearPublished().getTime().getTime());
    URL goodReadsLink = book.getGoodReadsLink();
    String bookTag = book.getBookTag().toString();
    String goodReadsLinkStr;

    int matchResult = match(title, description, statement);

    if (matchResult > 0) return matchResult;
    else if (goodReadsLink == null) goodReadsLinkStr = "No Link";
    else goodReadsLinkStr = goodReadsLink.toString();

    String sql =
        "INSERT INTO books ("
            + "title, edition_language, book_description, "
            + "rating_score, rating_votes, review_count, "
            + "year_published, goodreads_link, book_tag)"
            + " VALUES ('"
            + title
            + "','"
            + editionLanguage
            + "','"
            + description
            + "',"
            + ratingScore
            + ","
            + ratingVotes
            + ","
            + reviewCount
            + ",'"
            + yearPublished
            + "','"
            + goodReadsLinkStr
            + "','"
            + bookTag
            + "')";

    statement.executeUpdate(sql);

    return match(title, description, statement);
  }

  public static int match(String title, String description, Statement statement)
      throws SQLException {
    ResultSet resultSet;

    String sql =
        "SELECT * FROM books WHERE title='"
            + title
            + "' AND book_description='"
            + description
            + "'";

    resultSet = statement.executeQuery(sql);

    if (resultSet.next()) return resultSet.getInt("book_id");
    else return -1;
  }
}
