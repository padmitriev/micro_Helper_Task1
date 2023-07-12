import java.io.File;
import java.io.IOException;

public class SystemInfo {
    private static String pathToResources;
    private static String recordFilePath;

    public static void setPathToResources() {
        File directory = new File("src/main/resources/");
        pathToResources = directory.getAbsolutePath() + "\\";
    }

    public static void checkFile() {
        recordFilePath = pathToResources.concat("records.txt");

        File file = new File(recordFilePath);
        if(!file.exists() && !file.isFile()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getPathToResources() {
        return pathToResources;
    }

    public static String getRecordFilePath() {
        return recordFilePath;
    }
}
