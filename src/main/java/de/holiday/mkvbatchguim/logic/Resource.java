/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.logic;

/**
 *
 * @author holiday
 */
public class Resource {
    private String inputVideo;
    private String inputAudio;
    private String inputEngSub;
    private String inputForcedSub;
    private String outputVideo;

    public String getInputVideo() {
        return inputVideo;
    }

    public void setInputVideo(String inputVideo) {
        this.inputVideo = inputVideo;
    }

    public String getInputAudio() {
        return inputAudio;
    }

    public void setInputAudio(String inputAudio) {
        this.inputAudio = inputAudio;
    }

    public String getInputEngSub() {
        return inputEngSub;
    }

    public void setInputEngSub(String inputEngSub) {
        this.inputEngSub = inputEngSub;
    }

    public String getInputForcedSub() {
        return inputForcedSub;
    }

    public void setInputForcedSub(String inputForcedSub) {
        this.inputForcedSub = inputForcedSub;
    }

    public String getOutputVideo() {
        return outputVideo;
    }

    public void setOutputVideo(String outputVideo) {
        this.outputVideo = outputVideo;
    }
    
}
