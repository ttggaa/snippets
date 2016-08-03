package net.momoka.jetty;

public class ServletUtils {
  public static <T> T coalesce(T...ts) {
    for(T t: ts)
      if(t != null)
        return t;
    return null;
  }
}
