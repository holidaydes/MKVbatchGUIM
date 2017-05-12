/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.config.logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author holiday
 */
@XmlRootElement(name = "config")
public class Config {
    private String language;
    private String mkvtoolnixPath;

    @XmlElement(name = "language")
    public String getLanguage() {
        return language;
    }

    @XmlElement(name = "mkvToolNixPath")
    public String getMkvtoolnixPath() {
        return mkvtoolnixPath;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setMkvtoolnixPath(String mkvtoolnixPath) {
        this.mkvtoolnixPath = mkvtoolnixPath;
    }
    
}
