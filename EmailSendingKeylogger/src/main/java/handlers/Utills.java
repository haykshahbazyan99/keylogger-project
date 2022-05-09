package handlers;

import java.awt.event.KeyEvent;
import java.util.List;

public final class Utills {

    private Utills() {}

    public static String rawPrint(List<KeyStorage> storage) {
        if (storage.isEmpty())
            return "Nothing has been pressed";

        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Raw Stroke Data: <br/>");

        for(KeyStorage keyStorage : storage) {
            sb.append(keyStorage.toString() + System.lineSeparator());
        }
        return sb.toString();
    }


    public static String prettyPrint(List<KeyStorage> storage) {
        if (storage.isEmpty())
            return "Nothing has been pressed";

        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Pretty Stroke Data: <br/>");
        boolean[] caps = new boolean[256];

        for (KeyStorage keyStorage : storage) {
            caps[keyStorage.getKeyCode()] = keyStorage.isPressed();
            String key = processKey(keyStorage.getKeyCode(), caps[KeyEvent.VK_SHIFT]);

            if (keyStorage.isPressed()) {
                if (caps[KeyEvent.VK_SHIFT]) {
                    sb.append(key.toUpperCase());
                } else {
                    sb.append(key.toLowerCase());
                }
            }
        }
        return sb.toString();
    }




    /**
     * <h1>Helper method</h1>
     * <ul>
     *     <li>Translates keycode to a string with respect to the shift key being pressed.</li>
     * </ul>
     * @param keycode - A valid ASCII code
     * @param shifted - Is the keycode to be shifted?
     */
    private static String processKey(int keycode, boolean shifted) {
        String key = KeyEvent.getKeyText(keycode);
        if (key.length() != 1) {
            key = "{" + KeyEvent.getKeyText(keycode) + "}";
        }

        if (keycode == KeyEvent.VK_SHIFT) {
            key = "";
        }

        if (keycode == KeyEvent.VK_SPACE) {
            key = " ";
        }

        if (keycode == KeyEvent.VK_1 && shifted) {
            key = "!";
        }

        if (keycode == KeyEvent.VK_2 && shifted) {
            key = "@";
        }

        if (keycode == KeyEvent.VK_3 && shifted) {
            key = "#";
        }

        if (keycode == KeyEvent.VK_4 && shifted) {
            key = "$";
        }

        if (keycode == KeyEvent.VK_5 && shifted) {
            key = "%";
        }

        if (keycode == KeyEvent.VK_6 && shifted) {
            key = "^";
        }

        if (keycode == KeyEvent.VK_8 && shifted) {
            key = "*";
        }

        if (keycode == KeyEvent.VK_9 && shifted) {
            key = "(";
        }

        if (keycode == KeyEvent.VK_0 && shifted) {
            key = ")";
        }

        if (keycode == KeyEvent.VK_DEAD_ACUTE && shifted) {
            key = "?";
        }

        if (keycode == KeyEvent.VK_DEAD_ACUTE && !shifted) {
            key = "/";
        }

        if (keycode == KeyEvent.VK_PERIOD && shifted) {
            key = "<";
        }

        if (keycode == KeyEvent.VK_PERIOD && !shifted) {
            key = ".";
        }

        if (keycode == KeyEvent.VK_COMMA && shifted) {
            key = ">";
        }

        if (keycode == KeyEvent.VK_COMMA && !shifted) {
            key = ",";
        }

        if (keycode == KeyEvent.VK_QUOTE && !shifted) {
            key = "'";
        }

        if (keycode == KeyEvent.VK_QUOTE && shifted) {
            key = "\"";
        }

        if (keycode == KeyEvent.VK_SEMICOLON && shifted) {
            key = ":";
        }

        return key;
    }


}
