package ru.TimShmykov.parser.Service.storage.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.TimShmykov.parser.model.Article;
import ru.TimShmykov.parser.model.User;
import ru.TimShmykov.parser.repository.ArticleRepository;
import ru.TimShmykov.parser.repository.UserRepository;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public List<Article> getNew() {
        return articleRepository.findAll().stream()
                .filter(article -> article
                        .getPublishDate()
                        .isAfter(ChronoZonedDateTime.from(Instant.now().minus(1, ChronoUnit.DAYS)))
                )
                .collect(Collectors.toList());
    }

    public List<Article> getArticlesByUser(Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty())
            return Collections.emptyList();
        return articleRepository.getAllByUser(byId.get());

    }

    public List<Article> getArticlesByDate(ZonedDateTime date) {
        return articleRepository.getAllByPublishDate(date);
    }

}
