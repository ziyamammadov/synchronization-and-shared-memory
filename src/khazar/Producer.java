package khazar;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Producer extends Thread {
    private final SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text to put: ");
        String message = scanner.next();
        sharedBuffer.put(message);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Producer put: " + message + "   -->   " + formatter.format(date));
        try {
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
    }
}