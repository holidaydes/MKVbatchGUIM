/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.holiday.mkvbatchguim.ps;

import de.holiday.mkvbatchguim.common.Constans;
import de.holiday.mkvbatchguim.gui.log.LogFrame;
import de.holiday.mkvbatchguim.logic.Resource;
import de.holiday.mkvbatchguim.ps.logic.PsCommandResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author holiday
 */
public class PsCommand {

    private List<Resource> resources;
    private String mkvToolNixPath;
    private String inputVideoFolder;
    private String inputAudioFolder;
    private String inputEngSubFolder;
    private String inputForcedSubFolder;
    private String outputVideoFolder;
    private String resolution;

    public PsCommand(List<Resource> resources, String mkvToolNixPath, String inputVideoFolder, String inputAudioFolder, String inputEngSubFolder, String inputForcedSubFolder, String outputVideoFolder, String resolution) {
        this.resources = resources;
        this.mkvToolNixPath = mkvToolNixPath;
        this.inputVideoFolder = inputVideoFolder;
        this.inputAudioFolder = inputAudioFolder;
        this.inputEngSubFolder = inputEngSubFolder;
        this.inputForcedSubFolder = inputForcedSubFolder;
        this.outputVideoFolder = outputVideoFolder;
        this.resolution = resolution;
    }

    public PsCommandResponse execute() {
        StringBuilder inputVideos = new StringBuilder("");
        StringBuilder inputAudios = new StringBuilder("");
        StringBuilder inputEngSub = new StringBuilder("");
        StringBuilder inputForcedSub = new StringBuilder("");
        StringBuilder outputVideos = new StringBuilder("");

        for (int i = 0; i < resources.size(); i++) {
            inputVideos.append("\"").append(inputVideoFolder).append(File.separator).append(resources.get(i).getInputVideo()).append("\"");
            inputVideos.append((i < resources.size() - 1) ? "," : "");

            inputAudios.append("\"").append(inputAudioFolder).append(File.separator).append(resources.get(i).getInputAudio()).append("\"");
            inputAudios.append((i < resources.size() - 1) ? "," : "");

            inputEngSub.append("\"").append(inputEngSubFolder).append(File.separator).append(resources.get(i).getInputEngSub()).append("\"");
            inputEngSub.append((i < resources.size() - 1) ? "," : "");

            if (resources.get(i).getInputForcedSub() != null) {
                inputForcedSub.append("\"").append(inputForcedSubFolder).append(File.separator).append(resources.get(i).getInputForcedSub()).append("\"");
            } else {
                inputForcedSub.append("\"").append(resources.get(i).getInputForcedSub()).append("\"");
            }
            inputForcedSub.append((i < resources.size() - 1) ? "," : "");

            outputVideos.append("\"").append(outputVideoFolder).append(File.separator).append(resources.get(i).getOutputVideo()).append("\"");
            outputVideos.append((i < resources.size() - 1) ? "," : "");
        }

        PsCommandResponse response = new PsCommandResponse();

        try {
            String command = "powershell.exe -noprofile -executionpolicy bypass -file " + (Paths.get("").toAbsolutePath().toString() + File.separator + Constans.PS_SCRIPT) + " -MkvToolNixPath " + ("\"" + mkvToolNixPath + File.separator + Constans.MKV_MERGE + "\"") + " -Resolution " + resolution + " -InputVideo " + inputVideos.toString() + " -InputAudio " + inputAudios.toString() + " -InputEngSub " + inputEngSub.toString() + " -InputForcedSub " + inputForcedSub.toString() + " -OutputVideo " + outputVideos.toString();
            System.out.println("command: " + command);
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            powerShellProcess.getOutputStream().close();

            LogFrame logThread = new LogFrame();
            String line;
            System.out.println("Standard Output:");
            logThread.append("Standard Output:" + "\n");

            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
                logThread.append(line + "\n");
            }
            stdout.close();
            System.out.println("Standard Error:");
            logThread.append("Standard Error:" + "\n");
            
            StringBuilder errorMessage = new StringBuilder();
            BufferedReader stderr = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getErrorStream()));
            while ((line = stderr.readLine()) != null) {
                System.out.println(line);
                errorMessage.append(line);
                errorMessage.append("\n");
                logThread.append(line + "\n");
            }
            stderr.close();
            System.out.println("Done");
            logThread.append("Done");
            if (errorMessage.toString().length() > 0) {
                response.setSuccess(false);
                response.setErrorMessage(errorMessage.toString());
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
            return response;
        }
        response.setSuccess(true);
        return response;
    }

}
