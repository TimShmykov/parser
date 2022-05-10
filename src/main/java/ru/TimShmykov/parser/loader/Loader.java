package ru.TimShmykov.parser.loader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Loader {

    private RestTemplate restTemplate = new RestTemplate(); // Загрузчик?

    public String load(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
       // if (response.getStatusCode().isError()){
       //     throw new LoadException("bad ststus code"); // extends Exception
       // }
        return response.getBody();

    }
}
