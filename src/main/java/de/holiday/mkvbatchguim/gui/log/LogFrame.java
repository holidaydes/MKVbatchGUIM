/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.gui.log;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author holiday
 */
public class LogFrame extends JFrame {

    JTextArea area;
    
    public LogFrame() {
        this.setTitle("log");
        this.setAlwaysOnTop(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 500);
        area = new JTextArea();
        area.setVisible(true); 
        JScrollPane sp = new JScrollPane(area);
        sp.setVisible(true);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(sp);
        this.setVisible(true);
    }
    
    public void append(String line) {
        area.append(line);
        area.setCaretPosition(area.getDocument().getLength());
    }
    
}
