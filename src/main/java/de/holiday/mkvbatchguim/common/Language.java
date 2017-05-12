/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.common;

/**
 *
 * @author holiday
 */
public enum Language {
    HUN("Magyar", "Hungarian"), ENG("Angol", "English");

    String hunText;
    String engText;

    Language(String hunText, String engText) {
        this.hunText = hunText;
        this.engText = engText;
    }

    public String getHunText() {
        return hunText;
    }

    public String getEngString() {
        return engText;
    }

    public String getValue(Language lang) {
        if (lang.equals(Language.HUN)) {
            return hunText;
        } else {
            return engText;
        }
    }

    public static Language get(String value) {
        for (Language lang : values()) {
            if (lang.hunText.equals(value)) {
                return lang;
            }
            if (lang.engText.equals(value)) {
                return lang;
            }
        }
        return null;
    }

    public static Language getLanguage(String value) {
        for (Language lang : values()) {
            if (lang.name().equals(value)) {
                return lang;
            }
        }
        return Language.HUN;
    }
    
    public static int getLanguageSize() {
        return values().length;
    }
}
