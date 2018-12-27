package com.translator.exception;

/**
 * Created by 14675742 on 09.06.2018.
 */
public class DictionaryConfigException extends Exception {
    public DictionaryConfigException(String message, Exception e) {
        super(message,e);
    }
}
