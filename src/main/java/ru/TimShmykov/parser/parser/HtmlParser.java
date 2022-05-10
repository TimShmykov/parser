package ru.TimShmykov.parser.parser;

import ru.TimShmykov.parser.ParserRunner;
import ru.TimShmykov.parser.model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
    public List<Article> parse(String html) {
        Document document = Jsoup.parse(html);

        Elements articleEls = document.select(".tm-articles-list__item");


        List <Article> articles = new ArrayList<>();
        for (Element articleEl : articleEls) {
            System.out.println(articleEl.text());
            String username = articleEl.select(".tm-user-info__username").text();

            Elements titleEL = articleEl.select(".tm-article-snippet__title-link");
            String title = titleEL.select("span").text();
            String url = ParserRunner.HABAR_DOMAIN + titleEL.attr("href"); // вытащили атрибут хрев

            String description = articleEl.select(".article-formatted-body p").text();

            articles.add(new Article(username,title,description,url));

        }
        return articles;


    }
}
