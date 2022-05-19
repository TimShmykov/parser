package ru.TimShmykov.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data // генерирует геттеры сеттеры
@AllArgsConstructor
public class Article {
    private Long id;
    private User user;
    private ZonedDateTime publishDate;
    private List<Category> categories; // [name, url] - создать отдельный класс
    private String title;
    private String description;
    private String url;
    private Statistic statistic;

    public Article(User user, ZonedDateTime publishDate, List<Category> categories, String title, String description, String url, Statistic statistic) {
        this.user = user;
        this.publishDate = publishDate;
        this.categories = categories;
        this.title = title;
        this.description = description;
        this.url = url;
        this.statistic = statistic;
    }
}
