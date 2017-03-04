import cc.sitec.MediaKit;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by keeley on 2017/3/4.
 */
public class TestMediaKit {

    @Test
    public void teseInfo() throws IOException {
        String file = "/Users/keeley/Movies/test.mp4";
        MediaKit kit = new MediaKit();
        System.out.println(kit.getDuration(file));
    }
}
