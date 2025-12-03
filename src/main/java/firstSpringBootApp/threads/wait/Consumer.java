package firstSpringBootApp.threads.wait;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
       try {
           while (true) {
               int value = buffer.consume();
               if (value == -1) {
                   break;
               }
               System.out.println("Consumer consumed : " + value);
               Thread.sleep(8000);
           }
       }catch (Exception e) {
           e.printStackTrace();
       }

    }}
