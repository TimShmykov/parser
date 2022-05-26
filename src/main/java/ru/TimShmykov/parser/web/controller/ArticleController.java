package ru.TimShmykov.parser.web.controller; // 24.05.2022

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.TimShmykov.parser.Service.storage.util.ArticleService;
import ru.TimShmykov.parser.model.Article;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

@RestController // не сохраняет состояния
@RequestMapping("/article") //localhost:8000
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ObjectMapper objectMapper;


    @GetMapping("/new")
    public List<Article> getNewArticles() { //localhost:8080/article/new
        return articleService.getNew();
    }

    @GetMapping("/by?userId={userId}") //localhost:8000/article/by?userId=2
    public List<Article> getArticlesByUser(@RequestParam long userId) { // параметр из запроса
        return articleService.getArticlesByUser(userId);
    }

    @PostMapping("/date") //localhost:8000/article/date {'date': '2022-05-24 00:00:00'}
    public List<Article> getArticlesByDate(@RequestBody ZonedDateTime date) {
        return articleService.getArticlesByDate(date);
    }


    @GetMapping(value = "/new/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getNewArticlesAsFile() {
        List<Article> articleList = articleService.getNew();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] bytes = objectMapper.writeValueAsBytes(articleList);
            outputStream.writeBytes(bytes);
            return outputStream.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }


    @PostMapping("/write/file")
    public void writeArticles(@RequestBody byte[] bytes) throws IOException {
        String s = new String(bytes, StandardCharsets.UTF_8);
        String decode = URLDecoder.decode(s, StandardCharsets.UTF_8);
        List<Article> articles = objectMapper.readValue(decode, new TypeReference<List<Article>>() {});
        for (Article article : articles) {
            System.out.println(article.getTitle());
        }
    }

    //получить статьи по категории?

}
