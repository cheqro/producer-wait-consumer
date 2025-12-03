package firstSpringBootApp.threads.wait;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                buffer.setFinished();
                System.out.println("Producer finished");
            }
        }

        }