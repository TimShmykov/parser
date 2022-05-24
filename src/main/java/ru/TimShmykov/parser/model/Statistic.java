package ru.TimShmykov.parser.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "statistic")
@NoArgsConstructor
public class Statistic {
  @Id
  @GeneratedValue(generator = "statistic_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "statistic_gen", sequenceName = "statistic_id_seq", allocationSize = 1)
    private long id;
    private Integer rep; // - если это инт как мне стринг html'a превратить в число?
    private Integer views;
    private Integer bookmarks;
    private Integer comments;

  public Statistic(Integer rep, Integer views, Integer bookmarks, Integer comments) {
    this.rep = rep;
    this.views = views;
    this.bookmarks = bookmarks;
    this.comments = comments;
  }
}
