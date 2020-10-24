public class Queue {
    private final int[] data;
    int front = 0;
    int rear = 0;

    public Queue() {
        this.data = new int[10];
    }

    public Queue(int initialCapacity) {
        this.data = new int[initialCapacity];
    }

    public void enqueue(int a) {
        if (!isFull()) {
            data[rear] = a;
            rear = (rear + 1) % data.length;
        } else {
            throw new IllegalStateException();
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int result = data[front];
            data[front] = 0;
            front = (front + 1) % data.length;
            return result;
        } else {
            throw new IllegalStateException();
        }
    }

    public int peek() {
        return data[front];
    }

    public boolean isFull() {
        return front == rear && data[front] != 0;
    }

    public boolean isEmpty() {
        return front == rear && data[front] == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Queue holder = new Queue();

        while (!this.isEmpty()) {
            int dequeued = this.dequeue();
            holder.enqueue(dequeued);
            sb.append(dequeued)
                    .append(", ");
        }

        while (!holder.isEmpty()) {
            this.enqueue(holder.dequeue());
        }

        if (sb.length() > 1) {
            sb.replace(sb.length() - 2, sb.length(), "}");
        } else {
            sb.append("}");
        }
        return sb.toString();
    }
}
