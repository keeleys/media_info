package cc.sitec;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by keeley on 2017/2/23.
 */
public class MediaKit {
    private static final String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
    private static final String regexVideo = "Video: (.*?), (.*?), (.*?)[,\\s]";
    private static final String regexAudio = "Audio: (\\w*), (\\d*) Hz";

    public String getDuration(String file) throws IOException {
        String info = getInfo(file);
        Pattern p= Pattern.compile(regexDuration);
        Matcher m=p.matcher(info);
        if( m.find()) return m.group(1);
        return null;
    }

    private String getInfo(String file) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/ffmpeg" , "-i", file);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        return IOUtils.toString(process.getInputStream(), "utf-8");
    }
}
