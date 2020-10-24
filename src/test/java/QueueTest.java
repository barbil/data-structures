import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    public void enqueue() {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(i + 1, queue.dequeue());
        }

        System.out.println(queue);
    }

    @Test
    public void enqueueTest() {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i + 1);
        }

        System.out.println(queue);
    }

    @Test
    public void javaSyntaxTest() {
        try {
            System.out.println("Kitica");
            return;
        }
        catch (IllegalArgumentException e) {

        }
        finally {
            System.out.println("Kitica2");
        }
    }
}