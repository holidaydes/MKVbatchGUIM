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
public enum ButtonValue {
    BROWSE("Tallózás", "Browse"),
    SAVE("Mentés", "Save"),
    START("Indítás", "Start");
    
    String hunText;
    String engText;
    
    ButtonValue(String hunText, String engText) {
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
