package ru.TimShmykov.parser.parser;

import org.springframework.stereotype.Component;
import ru.TimShmykov.parser.ParserRunner;
import ru.TimShmykov.parser.model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.TimShmykov.parser.model.Category;
import ru.TimShmykov.parser.model.Statistic;
import ru.TimShmykov.parser.model.User;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlParser {
    public List<Article> parse(String html) {
        Document document = Jsoup.parse(html);

        Elements articleEls = document.select(".tm-articles-list__item");



        List<Article> articles = new ArrayList<>();
        for (Element articleEl : articleEls) {
//            System.out.println(articleEl.text());
            String username = articleEl.select(".tm-user-info__username").text();

            Elements titleEL = articleEl.select(".tm-article-snippet__title-link");
            String title = titleEL.select("span").text();
            String url = ParserRunner.HABR_DOMAIN + titleEL.attr("href"); // вытащили атрибут хрев
            String description = articleEl.select(".article-formatted-body").text(); // - убрал указатель p элемента, так как не во всех статьях в нем сидит описание
            Elements userInfo = articleEl.select(".tm-user-info__user");
            String userUrl = ParserRunner.HABR_DOMAIN + userInfo.attr("href");
            Integer rep = Integer.parseInt(articleEl.select(".tm-votes-meter__value_rating").text());
            String strView = articleEl.select(".tm-icon-counter__value").text();
             // ERROR если форат числа n.nK
            Integer view = (strView.contains("K")) // тернарный оператор
                    ? extractViewed(strView)
                    : Integer.parseInt(strView);
            Integer bookmarks = Integer.parseInt(articleEl.select(".bookmarks-button__counter").text());
            Integer comments = Integer.parseInt(articleEl.select(".tm-article-comments-counter-link__value").text());
            Elements articleDatetime = articleEl.select("time");
            String datetime = articleDatetime.attr("datetime");
            ZonedDateTime publishDate = ZonedDateTime.parse(datetime);

            List<Category> categories = new ArrayList<>();// куды тебя пихать?
            for (Element categoriesEl : articleEls) {
                String name = categoriesEl.select(".tm-article-snippet__hubs-item").text();
                Elements itemHub = categoriesEl.select(".tm-article-snippet__hubs-item-link");
                String categoryUrl =ParserRunner.HABR_DOMAIN + itemHub.attr("href");


                 Category category = new Category(name,categoryUrl);
                 categories.add(category);
            }



            Statistic statistic = new Statistic(rep,view,bookmarks,comments); // вопроооос с интами
            User user = new User(username, userUrl); // надо ли тут еще что-то прописывать как с articles.add(article)?

            Article article = new Article(user, publishDate, categories, title, description, url, statistic);
            articles.add(article);


        }



        return articles;

    }

    private Integer extractViewed(String strView) {
        String value = strView.replace(".", "").replace("K", "");
        return Integer.parseInt(value) * 100;
    }
}
