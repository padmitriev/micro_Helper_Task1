import lc.kra.system.mouse.event.GlobalMouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class ActionRecord {
    private static GlobalMouseEvent event;
    private static int x;
    private static int y;

    static void actionRecord() throws IOException {

        String longImageName = createUniqueName();
        x = event.getX();
        y = event.getY();
        String record = longImageName.concat(" ").concat(Integer.toString(x)).concat(" ").concat(Integer.toString(y));

        RectangleShot.doShot(x, y, longImageName);
        writeToFile(record);
    }
    private static void writeToFile(String record) {

        File file = new File(SystemInfo.getRecordFilePath());
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(record).append("\n");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String createUniqueName() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

//    getters & setters
    public static void setEvent(GlobalMouseEvent event) {
        ActionRecord.event = event;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        ActionRecord.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        ActionRecord.y = y;
    }
}
