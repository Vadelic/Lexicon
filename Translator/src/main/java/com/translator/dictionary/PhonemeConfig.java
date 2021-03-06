package com.translator.dictionary;


import com.translator.exception.DictionaryConfigException;
import org.springframework.lang.Nullable;

/**
 * Created by Komyshenets on 12/7/2017.
 */
public interface PhonemeConfig extends Config {
    @Nullable
    String getPhoneme() throws DictionaryConfigException;
}
