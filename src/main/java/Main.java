
public class Main {
    public static void main(String[] args) {

//  Задаёт путь к папке ресурсов и проверяет наличие файла для записи действий
        SystemInfo.setPathToResources();
        SystemInfo.checkFile();

//      Скриншот целого экрана
//        Screen screen = new Screen();
//        screen.capture().save(SystemInfo.getPathToResources());

//   MouseHook отслеживает левый клик и скриншотит квадрат 40х40
        MouseHook mouseHook = new MouseHook();
        mouseHook.mouseHook();
    }
}
