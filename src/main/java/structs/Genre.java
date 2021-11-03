package structs;

public class Genre {
  int genreID;
  String name;
  String subName;

  /*-----------------Constructors-----------------*/

  public Genre(int genreID, String name, String subName) {
    this.genreID = genreID;
    this.name = name;
    this.subName = subName;
  }

  public Genre(String name, String subName) {
    this.name = name;
    this.subName = subName;
  }

  public Genre(String name) {
    this.name = name;
  }

  /*-----------------Getters----------------------*/

  public int getGenreID() {
    return genreID;
  }

  public String getName() {
    return name;
  }

  public String getSubName() {
    return subName;
  }

  /*-----------------Setters----------------------*/

  public void setGenreID(int genreID) {
    this.genreID = genreID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }
}
