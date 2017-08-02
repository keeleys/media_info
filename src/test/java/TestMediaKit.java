import cc.sitec.MediaKit;
import org.junit.Test;

/**
 * Created by keeley on 2017/3/4.
 */
public class TestMediaKit {

    @Test
    public void teseInfo() throws Exception {
        String file = "/Users/keeley/Movies/test.mp4";
        MediaKit kit = new MediaKit();
        System.out.println(kit.getDuration(file)/1000);
    }
}
