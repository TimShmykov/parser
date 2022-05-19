package ru.TimShmykov.parser.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.Category;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final JdbcTemplate template;


    public void saveCategory (List<Category> categories) {
        template.batchUpdate("insert into category (name, categoryUrl) values (?, ?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, categories.get(i).getName());
                        ps.setString(2, categories.get(i).getCategoryUrl());
                    }

                    @Override
                    public int getBatchSize() {
                        return categories.size();
                    }
                });

    }

}
