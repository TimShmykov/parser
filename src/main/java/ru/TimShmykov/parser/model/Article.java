package ru.TimShmykov.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data // генерирует геттеры сеттеры
@Table(name = "article")
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(generator = "article_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "article_gen", sequenceName = "article_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "publish_Date") // исправляем ошибку нет артикля с названием publish_Date
    private ZonedDateTime publish_Date;
    @ManyToMany
    @JoinTable(
            name = "articles_categories", //название таблички связи
            joinColumns = @JoinColumn(name = "article_id"), // колонка внутри таблички в какое поле воткнуть ИД статьи
            inverseJoinColumns = @JoinColumn(name = "category_id") // в какое поле засунуть ИД категорий
    )
    private List<Category> categories; // [name, url] - создать отдельный класс
    private String title;
    private String description;
    private String url;
    @ManyToOne
    @JoinColumn(name = "statistic_id")
    private Statistic statistic;

    public Article(User user, ZonedDateTime publish_Date, List<Category> categories, String title, String description, String url, Statistic statistic) {
        this.user = user;
        this.publish_Date = publish_Date;
        this.categories = categories;
        this.title = title;
        this.description = description;
        this.url = url;
        this.statistic = statistic;
    }
}
