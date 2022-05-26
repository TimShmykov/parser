package ru.TimShmykov.parser.Service.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.TimShmykov.parser.model.Article;
import ru.TimShmykov.parser.model.Category;
import ru.TimShmykov.parser.model.Statistic;
import ru.TimShmykov.parser.model.User;
import ru.TimShmykov.parser.repository.ArticleRepository;
import ru.TimShmykov.parser.repository.CategoryRepository;
import ru.TimShmykov.parser.repository.StatisticRepository;
import ru.TimShmykov.parser.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ApplicationStorage {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StatisticRepository statisticRepository;

    @Transactional
    public void saveData(List<Article> articles) {
        for (Article article : articles) {
            User user = saveUser(article.getUser());

            List<Category> categories = article.getCategories().stream().map(this::saveCategory).collect(Collectors.toList());
            Statistic savedStatistic = statisticRepository.save(article.getStatistic());

            article.setUser(user);
            article.setCategories(categories);
            article.setStatistic(savedStatistic);
            saveArticle(article, user);

        }

        // List<User> users = articles.stream()
        //         .map(Article::getUser).
        //         collect(Collectors.toList());
        // userRepository.saveAll(users);
       // List<Category> categories = articles.stream().flatMap(article -> article.getCategories().stream()).collect(Collectors.toList());
       // categoryRepository.saveAll(categories);
       // List<Statistic> statistics = articles.stream().map(Article::getStatistic).collect(Collectors.toList());
       // statisticRepository.saveAll(statistics);
       // articleRepository.saveAll(articles);
    }

    public User saveUser(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        return userOptional.isEmpty()
                ? userRepository.save(user)
                : userOptional.get();
    }

    public Article saveArticle(Article article, User user) {
        Optional<Article> articleOptional = articleRepository.findByUserAndTitle(user,article.getTitle());
                return articleOptional.isEmpty()
                        ? articleRepository.save(article)
                        : articleOptional.get();
    }

    public Category saveCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
        return categoryOptional.isEmpty()
                ? categoryRepository.save(category)
                : categoryOptional.get();
    }


}