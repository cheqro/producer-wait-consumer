package firstSpringBootApp.threads.wait;

public class Main {
    public static void main(String[] args) throws InterruptedException {
         Buffer buffer = new Buffer(3);

        Thread consumer = new Thread(new Consumer(buffer));
        Thread producer = new Thread(new Producer(buffer));

        consumer.start();
        producer.start();

        producer.join(); // attendre la fin du producteur
        consumer.join(); // attendre la fin du consommateur

        System.out.println("Done !");


    }
}
