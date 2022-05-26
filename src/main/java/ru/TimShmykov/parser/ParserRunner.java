package ru.TimShmykov.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.TimShmykov.parser.Service.storage.ApplicationStorage;
import ru.TimShmykov.parser.loader.Loader;
import ru.TimShmykov.parser.loader.exception.LoadException;
import ru.TimShmykov.parser.model.Article;
import ru.TimShmykov.parser.parser.HtmlParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class ParserRunner implements CommandLineRunner {


    // @Autowired вставляет единственный экземпляр загрузчика, но это плохой тон
    private final Loader loader;
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



        //   try (FileOutputStream outputStream = new FileOutputStream("/var/www/data.txt")) { // потоки
            //       String s = "Sadsafdsvds";
            //       outputStream.write(s.getBytes()); // пишет в файл с замещением
            //   } catch (IOException e) {
            //       System.out.println(e.getMessage());
            //   }


    }
}
