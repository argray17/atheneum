package database.build.tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import structs.Book;
import structs.Genre;
import structs.GenreTag;

public class ToTables {
  public static void exec(Connection connection, Book book) throws SQLException {
    Statement statement = connection.createStatement();
    String author = book.getAuthor();
    GenreTag[] genreTags = book.getGenreTags();
    Genre genre;

    int authorID = AuthorsTable.add(author, statement);
    int bookID = BooksTable.add(book, statement);
    int bookRelationAuthorID = BookAuthorTable.add(bookID, authorID, statement);
    int genreID;
    int bookRelationGenreID;

    for (GenreTag tag : genreTags) {
      genre = tag.getGenre();
      genreID = GenresTable.add(genre, statement);
      bookRelationGenreID = BookGenreTable.add(bookID, genreID, tag.getTagCount(), statement);
    }
  }
}
