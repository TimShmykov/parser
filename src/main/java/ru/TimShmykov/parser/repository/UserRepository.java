package ru.TimShmykov.parser.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate template;

    public void saveUsers (List<User> users) {
        template.batchUpdate( "insert into users (username, url) values (?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(0, users.get(i).getUsername());
                ps.setString(1, users.get(i).getUrl());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }
}
