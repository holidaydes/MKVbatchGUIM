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
public enum LabelValue {
    SEASON("Évad", "Season"),
    EPISODES("Epizódok", "Episodes"),
    RESOLUTION("Felbontás", "Resolution"),
    VIDEO_TYPE("Videó típus", "Video type"),
    CONFIG("Beállítások", "Settings"),
    LANGUAGE("Nyelv", "Language"),
    MKVTOOLNIX_PATH("MKVToolNix útvonala", "MKVToolNix path"),
    INPUT_CONFIG("Bemenet beállítások", "Input settings"),
    OUTPUT_CONFIG("Kimenet beállítások", "Output settings"),
    INPUT_VIDEO("Videó forrás", "Video source"),
    INPUT_AUDIO("Audió forrás", "Audio source"),
    INPUT_SUBTITLE_ENG("Angol felirat forrás", "English subtitle source"),
    INPUT_SUBTITLE_FORCED("Forced felirat forrás", "Forced felirat source"),
    OUTPUT_VIDEO("Videó cél", "Video destination"),
    OUTPUT_LIST("Kimenet lista", "Output list"),
    SERIES_TITLE("Sorozat cím", "Series title"),
    RELEASE_NAME("Release név", "Release name"),
    CODEC_TYPE("Kódek típus", "Codec type"),
    INPUT_VIDEO_NAME("Videó név", "Video name"),
    INPUT_AUDIO_NAME("Audió név", "Audio name"),
    INPUT_ENG_SUB_NAME("Angol felirat név", "English subtitle name"),
    INPUT_FORCED_SUB_NAME("Forced felirat név", "Forced subtitle name"),
    OUTPUT_VIDEO_NAME("Kimenet név", "Kimenet name");
    
    String hunText;
    String engText;
    
    LabelValue(String hunText, String engText) {
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
