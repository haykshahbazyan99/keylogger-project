package handlers;

public class KeyStorage {

    private int keyCode;
    private boolean pressed;
    private long systemsTimePressedMills;

    public KeyStorage(int keyCode, boolean pressed, long systemsTimePressedMills) {
        this.keyCode = keyCode;
        this.pressed = pressed;
        this.systemsTimePressedMills = systemsTimePressedMills;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public long getSystemsTimePressedMills() {
        return systemsTimePressedMills;
    }

    public void setSystemsTimePressedMills(long systemsTimePressedMills) {
        this.systemsTimePressedMills = systemsTimePressedMills;
    }


    @Override
    public String toString() {
        return "KeyStorage{" +
                "keyCode=" + keyCode +
                ", pressed=" + pressed +
                ", systemsTimePressedMills=" + systemsTimePressedMills +
                '}';
    }
}


