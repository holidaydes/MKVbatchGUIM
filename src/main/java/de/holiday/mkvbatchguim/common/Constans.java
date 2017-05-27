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
public class Constans {
    public static final String TITLE = "MKV batch GUI M";
    public static final String CONFIG_FILE_NAME = "cfg.xml";
    public static final String PS_SCRIPT = "psScript.ps1";
    public static final String MKV_TOOL_NIX = "MKVToolNix";
    public static final String MKV_MERGE = "mkvmerge.exe";
    public static final String SOURCE_VIDEO = "video";
    public static final String SOURCE_AUDIO = "audio";
    public static final String VERSION = "v0.0.1";
    
    public static final String[] DIMENSIONS = {"360p", "480p", "720p", "1080p"};
    public static final String[] VIDEO_TYPES = {"DVDRip", "BDRip", "WEB-DL", "WEBRip", "BluRay"};
    public static final String[] CODEC_TYPES = {"x264", "xvid", "h264", "h265", "x265"};
    
    public static final String[] SUPPORTED_VIDEO_EXTENSIONS = {"mp4", "mkv", "avi"};
    public static final String[] SUPPORTED_AUDIO_EXTENSIONS = {"ac3", "mp3", "waw", "flac", "ape", "aac"};
    public static final String[] SUPPORTED_SUBTITLE_EXTENSIONS = {"srt", "sub", "ass"};
}
