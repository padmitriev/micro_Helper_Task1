import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

import java.io.IOException;
//import java.util.Map;

public class MouseHook {

    private static boolean run = true;

    void mouseHook() {
    // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalMouseHook mouseHook = new GlobalMouseHook(); // Add true to the constructor, to switch to raw input mode
//		System.out.println("Global mouse hook successfully started, press [middle] mouse button to shutdown. Connected mice:");
//		for (Map.Entry<Long,String> mouse:GlobalMouseHook.listMice().entrySet()) {
//        System.out.format("%d: %s\n", mouse.getKey(), mouse.getValue());
//    }

		mouseHook.addMouseListener(new GlobalMouseAdapter() {

        @Override
        public void mousePressed(GlobalMouseEvent event)  {
            if (event.getButton() == GlobalMouseEvent.BUTTON_LEFT) {
                ActionRecord.setEvent(event);
                try {
                    ActionRecord.actionRecord();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
//            if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO
//                    && (event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
//                System.out.println("Both mouse buttons are currently pressed!");
//            }
            if (event.getButton()==GlobalMouseEvent.BUTTON_MIDDLE) {
                run = false;
            }
        }

        @Override
        public void mouseReleased(GlobalMouseEvent event)  {
//            System.out.println(event);
        }

        @Override
        public void mouseMoved(GlobalMouseEvent event) {
//            System.out.println(event);
        }

        @Override
        public void mouseWheel(GlobalMouseEvent event) {
//            System.out.println(event);
        }
    });

		try {
        while(run) {
            Thread.sleep(128);
        }
    } catch(InterruptedException e) {
        //Do nothing
    } finally {
        mouseHook.shutdownHook();
    }

    }
}
