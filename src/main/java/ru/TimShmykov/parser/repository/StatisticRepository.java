package ru.TimShmykov.parser.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.Statistic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {



}
