/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.holiday.mkvbatchguim.common.Constans;
import de.holiday.mkvbatchguim.config.logic.Config;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author holiday
 */
public class Configuration {

    public static boolean saveConfig(Config cfg) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(Constans.CONFIG_FILE_NAME), cfg);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static Config readConfig() {
        File file = new File(Constans.CONFIG_FILE_NAME);
        if (file.exists()) {
            XmlMapper mapper = new XmlMapper();
            try {
                return mapper.readValue(file, Config.class);
            } catch (IOException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }
}
