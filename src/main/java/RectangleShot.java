import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import java.io.IOException;

public class RectangleShot {
    static int x = 0;
    static int y = 0;

    static void checkCoordinates() {
        if (x < 20) {
            x = 20;
        }
        if (y < 20) {
            y = 20;
        }
        x = x - 20;
        y = y - 20;
    }
    public static void doShot(int x, int y, String imageName) throws IOException {

        checkCoordinates();

        Screen screen = new Screen();
        ScreenImage region = screen.capture(x, y, 40, 40);
        region.save(SystemInfo.getPathToResources(), imageName);
    }
}
