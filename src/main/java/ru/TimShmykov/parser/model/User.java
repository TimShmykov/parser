package ru.TimShmykov.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(generator = "users_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private long id;
    private String username;
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "user") // mappedBy название ПОЛЯ В КЛАССЕ!
    private List<Article> articles;

    public User(String username, String url) {
        this.username = username;
        this.url = url;
    }
}
