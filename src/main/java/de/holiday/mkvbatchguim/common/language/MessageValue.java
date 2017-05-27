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
public enum MessageValue {
    ERROR_SAVE_CONFIG("A konfiguráció mentése sikertelen", "Unsuccessfull saving configuration"),
    SUCCESS_SAVE_CONFIG("A konfiguráció mentése sikeres", "Successfully saved configuration"),
    ERROR_EMPTY_FOLDER("Üres mappa", "Empty folder"),
    FILE_AMOUNT_ERROR("Kevesebb fájl található a mappában mint a videóból", "There is less file than videos amount"),
    SUCCESS_COMMAND_EXECUTION("Sikeres végrehajtás", "Succesfull execution");
    
    String hunText;
    String engText;
    
    MessageValue(String hunText, String engText) {
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
