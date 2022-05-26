package ru.TimShmykov.parser.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.Article;
import ru.TimShmykov.parser.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> { //переписать все под Jpa!

    Optional<Article> findByUserAndTitle(User user, String url);

    List<Article> getAllByUser(User user);

    List<Article> getAllByPublishDate(ZonedDateTime date);


}
