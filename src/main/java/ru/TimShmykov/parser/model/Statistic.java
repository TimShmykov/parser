package ru.TimShmykov.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistic {
    private long id;
    private Integer rep; // - если это инт как мне стринг html'a превратить в число?
    private Integer view;
    private Integer bookmarks;
    private Integer comments;

  public Statistic(Integer rep, Integer view, Integer bookmarks, Integer comments) {
    this.rep = rep;
    this.view = view;
    this.bookmarks = bookmarks;
    this.comments = comments;
  }
}
