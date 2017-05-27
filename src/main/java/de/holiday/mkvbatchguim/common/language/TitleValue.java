/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.common.language;

import de.holiday.mkvbatchguim.common.Language;

/**
 *
 * @author holiday
 */
public enum TitleValue {
    FILE_CHOOSER_OPEN("Megnyítás", "Open"),
    FILE_CHOOSER_SAVE("Mentés", "Save"),
    DIALOG_SAVE_CONFIG("Konfiguráció mentése", "Save configuration"),
    DIALOG_INPUT_VIDEO("Videó forrás", "Input video"),
    DIALOG_INPUT_AUDIO("Audió forrás", "Input audio"),
    DIALOG_INPUT_ENGLISH_SUBTITLE("Angol felirat forrás", "Input english subtitle"),
    DIALOG_INPUT_FORCED_SUBTITLE("Forced felirat forrás", "Input forced subtitle"),
    DIALOG_EXECUTE_COMMAND("MkvToolNix parancs végrehajtás", "MkvToolNix command execution");
    
    String hunText;
    String engText;
    
    TitleValue(String hunText, String engText) {
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
}
