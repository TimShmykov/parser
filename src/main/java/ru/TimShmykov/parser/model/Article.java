package ru.TimShmykov.parser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    // Private User user [username, url]
    private String username;
    // private LocalDate publishDate;
    // private List<Category> categories; [name, url] - создать отдельный класс
    private String title;
    private String description;
    private String url;
    // private Statistic statistic[int rep,view,bookmarks, comments]

}
