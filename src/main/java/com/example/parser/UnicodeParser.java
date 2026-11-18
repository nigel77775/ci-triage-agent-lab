package com.example.parser;

public final class UnicodeParser {
  /** Decodes \uXXXX escapes, including surrogate pairs. */
  public static String decode(String in) {
    StringBuilder out = new StringBuilder();
    for (int i = 0; i < in.length(); i++) {
      char c = in.charAt(i);
      if (c == '\' && i + 5 < in.length() && in.charAt(i + 1) == 'u') {
        out.append((char) Integer.parseInt(in.substring(i + 2, i + 6), 16));
        i += 5;
      } else {
        out.append(c);
      }
    }
    return out.toString();
  }
}
