package ru.TimShmykov.parser;

import ru.TimShmykov.parser.loader.Loader;
import ru.TimShmykov.parser.parser.HtmlParser;

import java.io.IOException;

public class ParserRunner {


    public static final String HABAR_DOMAIN = "https://habr.com";
    private static final String HABAR_URL = HABAR_DOMAIN + "/ru/all/";


    public static void main(String[] args) throws IOException {

        Loader loader = new Loader();
        String response = loader.load(HABAR_URL);

        HtmlParser htmlParser = new HtmlParser();
        htmlParser.parse(response);


        // String irbisResponse = loader.load("https://irbis.plus");
       // Files.writeString(Paths.get("irbis.html"), irbisResponse, StandardOpenOption.CREATE);


    }
}
