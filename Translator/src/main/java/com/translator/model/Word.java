package com.translator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Komyshenets on 08.10.2017.
 */
@Entity
@Table(name = "word")
public class Word extends JPA{
    private Language language;
    private String resource;
    private String image;

    private String word;
    private String subject;
    private String phoneme;

    private List<LanguagePack> translatePacks = new ArrayList<>();

    public Word() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Word{");
        sb.append("language=").append(language);
        sb.append(", word='").append(word).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Word(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lang_id")
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String original) {
        this.word = original;
    }

    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }


    public void setSubject(String description) {
        this.subject = description;
    }

    @Column(name = "phoneme")
    public String getPhoneme() {
        return phoneme;
    }

    public void setPhoneme(String phoneme) {
        this.phoneme = phoneme;
    }

    @JoinColumn(name = "resource")
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "WORD_TRANSLATE_PACKS_LINK",
            joinColumns = @JoinColumn(name = "WORD_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSLATE_PACKS_ID", referencedColumnName = "ID"))
    public List<LanguagePack> getTranslatePacks() {
        return translatePacks;
    }

    public void setTranslatePacks(List<LanguagePack> translatePacks) {
        this.translatePacks = translatePacks;
    }

    public LanguagePack getLanguagePack(Language languageTo) {
        for (LanguagePack translatePack : translatePacks) {
            if (Objects.equals(translatePack.getLanguage(), languageTo)) {
                return translatePack;
            }
        }
        return null;
    }

    public void addLanguagePack(LanguagePack languagePack) {
            translatePacks.add(languagePack);
    }
}
