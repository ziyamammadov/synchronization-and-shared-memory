package khazar;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Consumer extends Thread {
    private final SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    public void run() {
        String message = sharedBuffer.get();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Consumer got: " + message + "   -->   " + formatter.format(date));
    }
}
