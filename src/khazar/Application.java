package khazar;

class Application {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);
        producer.start();
        consumer.start();
    }
}