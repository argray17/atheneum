package database.load;

import structs.*;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class LoadDatabase {
    public Library exec(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        HashMap<Integer, String> authorMap = LoadAuthors(statement);
        HashMap<Integer, Genre> genreMap = LoadGenres(statement);
        HashMap<Integer, Book> bookMap = LoadBooks(statement);

        return new Library(bookMap, authorMap, genreMap);
    }

    private HashMap<Integer, String> LoadAuthors(Statement statement) throws SQLException {
        HashMap<Integer, String> authorMap = new HashMap<>();

        String sql = "SELECT * FROM authors";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            int authorID = resultSet.getInt("author_id");
            String name = resultSet.getString("name");
            authorMap.put(authorID, name);
        }

        return authorMap;
    }

    private HashMap<Integer, Genre> LoadGenres(Statement statement) throws SQLException {
        HashMap<Integer, Genre> genreMap = new HashMap<>();

        String sql = "SELECT * FROM genres";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            int genreID = resultSet.getInt("genre_id");
            String name = resultSet.getString("name");
            String subName = resultSet.getString("subname");
            Genre genre = new Genre(genreID, name, subName);
            genreMap.put(genreID, genre);
        }

        return genreMap;
    }

    private HashMap<Integer, Book> LoadBooks(Statement statement) throws SQLException {
        HashMap<Integer, Book> bookMap = new HashMap<>();

        String sql = "SELECT * FROM books";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            int bookID = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String editionLanguage = resultSet.getString("edition_language");
            String bookDescription = resultSet.getString("book_description");
            float ratingScore = resultSet.getFloat("rating_score");
            int ratingVotes = resultSet.getInt("rating_votes");
            int reviewCount = resultSet.getInt("rating_count");

            Date date = resultSet.getDate("year_published");
            Calendar yearPublished = Calendar.getInstance();
            yearPublished.setTime(date);

            URL goodReadsLink = resultSet.getURL("goodreads_link");

            String bookTagStr = resultSet.getString("book_tag");
            BookTag bookTag = BookTag.valueOf(bookTagStr);

            String author = LoadBookAuthor(statement, bookID);
            GenreTag[] genreTags = LoadBookGenreTags(statement, bookID);


            Book book = new Book(bookID, title, author, editionLanguage, bookDescription, ratingScore, ratingVotes, reviewCount, yearPublished, genreTags, goodReadsLink, bookTag);
            bookMap.put(bookID, book);
        }

        return bookMap;
    }

    private String LoadBookAuthor(Statement statement, int bookID) throws SQLException {
        String sql = "SELECT authors_fk FROM authors_fk_books WHERE books_fk=" + bookID;
        ResultSet resultSet = statement.executeQuery(sql);
        int authorID = resultSet.getInt("author_fk");

        sql = "SELECT name FROM authors WHERE books_fk=" + authorID;
        resultSet = statement.executeQuery(sql);
        return resultSet.getString("name");
    }

    private GenreTag[] LoadBookGenreTags(Statement statement, int bookID) throws SQLException {
        ArrayList<GenreTag> genreTags = new ArrayList<>();

        String sql = "SELECT * FROM genres_fk_books WHERE book_fk=" + bookID;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int genreID = resultSet.getInt("genre_id");
            int tagCount = resultSet.getInt("tag_count");

            Genre genre = LoadBookGenre(statement, genreID);
            genreTags.add(new GenreTag(genre, tagCount));
        }

        GenreTag[] genreTagArr = new GenreTag[genreTags.size()];

        for (int i = 0; i < genreTags.size(); i++)
            genreTagArr[i] = genreTags.get(i);

        return genreTagArr;
    }

    private Genre LoadBookGenre(Statement statement, int genreID) throws SQLException {
        String sql = "SELECT * FROM genres WHERE genre_id=" + genreID;
        ResultSet resultSet = statement.executeQuery(sql);

        String name = resultSet.getString("name");
        String subName = resultSet.getString("subname");
        return new Genre(genreID, name, subName);
    }
}
