package structs;

import java.net.URL;
import java.util.Calendar;

public class Book {
  private int bookID;
  private String title, author, editionLanguage, description;
  private float ratingScore;
  private int ratingVotes, reviewCount;
  private Calendar yearPublished;
  private GenreTag[] genreTags;
  private URL goodReadsLink;
  private BookTag bookTag;

  /*-----------------Constructors-----------------*/

  public Book(int bookID, String title, String author, String editionLanguage, String description, float ratingScore, int ratingVotes, int reviewCount, Calendar yearPublished, GenreTag[] genreTags, URL goodReadsLink, BookTag bookTag) {
    this.bookID = bookID;
    this.title = title;
    this.author = author;
    this.editionLanguage = editionLanguage;
    this.description = description;
    this.ratingScore = ratingScore;
    this.ratingVotes = ratingVotes;
    this.reviewCount = reviewCount;
    this.yearPublished = yearPublished;
    this.genreTags = genreTags;
    this.goodReadsLink = goodReadsLink;
    this.bookTag = bookTag;
  }

  public Book(
      String title,
      String author,
      String editionLanguage,
      String description,
      float ratingScore,
      int ratingVotes,
      int reviewCount,
      Calendar yearPublished,
      GenreTag[] genreTags,
      URL goodReadsLink,
      BookTag bookTag) {
    this.title = title;
    this.author = author;
    this.editionLanguage = editionLanguage;
    this.description = description;
    this.ratingScore = ratingScore;
    this.ratingVotes = ratingVotes;
    this.reviewCount = reviewCount;
    this.yearPublished = yearPublished;
    this.genreTags = genreTags;
    this.goodReadsLink = goodReadsLink;
    this.bookTag = bookTag;
  }

  /*-----------------Getters----------------------*/

  public int getBookID() {
    return bookID;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getEditionLanguage() {
    return editionLanguage;
  }

  public String getDescription() {
    return description;
  }

  public float getRatingScore() {
    return ratingScore;
  }

  public int getRatingVotes() {
    return ratingVotes;
  }

  public int getReviewCount() {
    return reviewCount;
  }

  public Calendar getYearPublished() {
    return yearPublished;
  }

  public GenreTag[] getGenreTags() {
    return genreTags;
  }

  public URL getGoodReadsLink() {
    return goodReadsLink;
  }

  public BookTag getBookTag() {
    return bookTag;
  }

  /*-----------------Setters----------------------*/

  public void setBookID(int bookID) {
    this.bookID = bookID;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setEditionLanguage(String editionLanguage) {
    this.editionLanguage = editionLanguage;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRatingScore(float ratingScore) {
    this.ratingScore = ratingScore;
  }

  public void setRatingVotes(int ratingVotes) {
    this.ratingVotes = ratingVotes;
  }

  public void setReviewCount(int reviewCount) {
    this.reviewCount = reviewCount;
  }

  public void setYearPublished(Calendar yearPublished) {
    this.yearPublished = yearPublished;
  }

  public void setGenreTags(GenreTag[] genreTags) {
    this.genreTags = genreTags;
  }

  public void setGoodReadsLink(URL goodReadsLink) {
    this.goodReadsLink = goodReadsLink;
  }

  public void setBookTag(BookTag bookTag) {
    this.bookTag = bookTag;
  }
}
