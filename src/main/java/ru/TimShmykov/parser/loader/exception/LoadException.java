package ru.TimShmykov.parser.loader.exception;

public class LoadException extends Exception {
    @Override
    public String getMessage() {
        return "Bad status code";
    }
}
