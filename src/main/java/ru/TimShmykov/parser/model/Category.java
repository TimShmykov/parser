package ru.TimShmykov.parser.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data // генерирует геттеры сеттеры
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String categoryUrl; //url уже имеется!

    public Category(String name, String categoryUrl) {
        this.name = name;
        this.categoryUrl = categoryUrl;
    }
}
