package ru.TimShmykov.parser.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.Statistic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatisticRepository {
    private final JdbcTemplate template;

    public void saveStatistic (List<Statistic> statistics) {
        template.batchUpdate("insert into statistic (rep, views, bookmarks, comments) values (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, statistics.get(i).getRep());
                ps.setInt(2, statistics.get(i).getView());
                ps.setInt(3, statistics.get(i).getBookmarks());
                ps.setInt(4, statistics.get(i).getComments());
            }

            @Override
            public int getBatchSize() {
                return statistics.size();
            }
        });
    }
}
