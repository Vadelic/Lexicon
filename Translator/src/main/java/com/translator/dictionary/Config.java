package com.translator.dictionary;


import com.translator.exception.DictionaryConfigException;

/**
 * Created by Komyshenets on 12/7/2017.
 */
public interface Config {

    String getAddress();

    void setWord(String word);

    void setLangFrom(String langFrom) throws DictionaryConfigException;

    void setLangTo(String langTo) throws DictionaryConfigException;
}
