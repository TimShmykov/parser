package ru.TimShmykov.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.TimShmykov.parser.Service.Storage.ApplicationStorage;
import ru.TimShmykov.parser.loader.Loader;
import ru.TimShmykov.parser.loader.exception.LoadException;
import ru.TimShmykov.parser.model.Article;
import ru.TimShmykov.parser.model.Category;
import ru.TimShmykov.parser.model.Statistic;
import ru.TimShmykov.parser.model.User;
import ru.TimShmykov.parser.parser.HtmlParser;
import ru.TimShmykov.parser.repository.ArticleRepository;
import ru.TimShmykov.parser.repository.CategoryRepository;
import ru.TimShmykov.parser.repository.StatisticRepository;
import ru.TimShmykov.parser.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@SpringBootApplication
public class ParserRunner implements CommandLineRunner {


    // @Autowired // вставляет единственный экземпляр загрузчика, но это плохой тон
    private final Loader loader;
    // @Autowired
    private final HtmlParser htmlParser;
    private final ApplicationStorage applicationStorage;

    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";


    public static void main(String[] args) {
        SpringApplication.run(ParserRunner.class, args);

    }

    @Override
    public void run(String... args) throws Exception {


        try {
            String response = loader.load(HABR_URL);
            List<Article> articles = htmlParser.parse(response);
            applicationStorage.saveData(articles);

        } catch (LoadException e) {
            e.printStackTrace();
        }
    }
}
