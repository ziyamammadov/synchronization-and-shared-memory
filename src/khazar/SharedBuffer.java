package khazar;

public class SharedBuffer {
    private String msg;
    private boolean locked = true;

    public synchronized String get() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        locked = true;
        notify();
        return msg;
    }

    public synchronized void put(String message) {
        while (!locked) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        msg = message;
        locked = false;
        notify();
    }
}