package ru.TimShmykov.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String username;
    private String url;

  public User(String username, String url) {
    this.username = username;
    this.url = url;
  }
}
