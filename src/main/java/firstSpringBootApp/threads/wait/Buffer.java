package firstSpringBootApp.threads.wait;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    public Queue<Integer> buffer = new LinkedList<>();
    public int capacity;
    private boolean finished = false;


    public Buffer(int capacity) {
        this.capacity = capacity;
    }


    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full("+buffer.size()+"), waiting ....");
            wait();
        }
        buffer.add(value);
        System.out.println("Producer produced : " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty() && !finished){
                wait();
        }

        // Si fini et vide -> rien à consommer
        if (buffer.isEmpty() && finished) {
            return -1;
        }

        int value = buffer.poll();
        notifyAll(); // réveille les producteurs
        return value;
    }

    public synchronized void setFinished() {
        finished = true;
        notifyAll(); // réveiller consommateurs bloqués
    }
}
