package ru.TimShmykov.parser.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // генерирует геттеры сеттеры
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(generator = "category_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_gen", sequenceName = "category_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String Url; //url уже имеется!

    @ManyToMany(mappedBy = "categories")
    private List<Article> articles;

    public Category(String name, String Url) {
        this.name = name;
        this.Url = Url;
    }
}
