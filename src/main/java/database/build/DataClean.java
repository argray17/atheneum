package database.build;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import structs.Genre;
import structs.GenreTag;

public class DataClean {
  public static Calendar cleanCalendar(String str) {
    str = str.replaceAll("[^0-9]", "");
    int yearAsInt = Integer.parseInt(str);

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, yearAsInt);
    cal.set(Calendar.MONTH, 0);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return cal;
  }

  public static float cleanFloat(String str) {
    str = str.replaceAll("[^0-9.]", "");
    return Float.parseFloat(str);
  }

  public static GenreTag[] cleanGenreTags(String str) {
    String[] genreTagStrs = str.split(",");
    String[] genreTagPair, genreNamePair;
    String nameAndSubName, tagCountStr, name, subName;
    GenreTag[] genreTags = new GenreTag[genreTagStrs.length];
    GenreTag genreTag;
    Genre genre;
    int tagCount;
    int i = 0;

    for (String tag : genreTagStrs) {
      genreTagPair = tag.split(":");
      nameAndSubName = genreTagPair[0];
      tagCountStr = genreTagPair[1];
      tagCountStr = tagCountStr.replaceAll("[^0-9]", "");
      tagCount = Integer.parseInt(tagCountStr);

      genreNamePair = nameAndSubName.split("\\(");
      name = genreNamePair[0];

      name = name.replaceAll("[^a-zA-Z0-9 ]", "").trim();

      if (genreNamePair.length > 1) {
        subName = genreNamePair[1];
        subName = subName.replaceAll("[^a-zA-Z0-9 ]", "").trim();
        genre = new Genre(name, subName);
      } else {
        genre = new Genre(name);
      }

      genreTag = new GenreTag(genre, tagCount);
      genreTags[i] = genreTag;
      i++;
    }

    return genreTags;
  }

  public static int cleanInt(String str) {
    str = str.replaceAll("[^0-9.]", "");
    return Integer.parseInt(str);
  }

  public static String cleanString(String str) {
    str = str.replaceAll("'", "''");
    str = str.replaceAll(" +", " ").trim();
    return str;
  }

  public static URL cleanURL(String str) {
    str = str.replaceAll(" ", "");
    try {
      return new URL(str);
    } catch (MalformedURLException mue) {
      return null;
    }
  }
}
