package ru.TimShmykov.parser.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.TimShmykov.parser.loader.exception.LoadException;

@Component // вспомогательная логика
//@Service // бизнесс логика - выполняет основную работы

@RequiredArgsConstructor
public class Loader {

    private final RestTemplate restTemplate; // Загрузчик?

    public String load(String url) throws LoadException {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
       if (response.getStatusCode().isError()){
           throw new LoadException(); // extends Exception
       }
        return response.getBody();

    }
}
