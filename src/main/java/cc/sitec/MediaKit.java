package cc.sitec;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by keeley on 2017/2/23.
 */
public class MediaKit {
//    private static final String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
//    private static final String regexVideo = "Video: (.*?), (.*?), (.*?)[,\\s]";
//    private static final String regexAudio = "Audio: (\\w*), (\\d*) Hz";

    public long getDuration(String file) throws Exception {
        String info = getInfo(file);
        Pattern p2 = Pattern.compile("Duration: (\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d)", 2);

        Matcher m=p2.matcher(info);
        if( m.find()) {
            long hours = (long)Integer.parseInt(m.group(1));
            long minutes = (long)Integer.parseInt(m.group(2));
            long seconds = (long)Integer.parseInt(m.group(3));
            long dec = (long)Integer.parseInt(m.group(4));
            long duration = dec * 100L + seconds * 1000L + minutes * 60L * 1000L + hours * 60L * 60L * 1000L;
            return duration;
        }
        return -1;
    }

    private String getInfo(String file) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ffmpeg" , "-i", file);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        return IOUtils.toString(process.getInputStream(), "utf-8");
    }
}
