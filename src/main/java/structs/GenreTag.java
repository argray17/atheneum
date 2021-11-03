package structs;

public class GenreTag {
  Genre genre;
  int tagCount;

  /*-----------------Constructors-----------------*/

  public GenreTag(Genre genre, int tagCount) {
    this.genre = genre;
    this.tagCount = tagCount;
  }

  /*-----------------Getters----------------------*/

  public Genre getGenre() {
    return genre;
  }

  public int getTagCount() {
    return tagCount;
  }

  /*-----------------Setters----------------------*/

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public void setTagCount(int tagCount) {
    this.tagCount = tagCount;
  }
}
