import java.util.EmptyStackException;

public class Stack {
    private final int[] data;
    private int index = 0;

    public Stack() {
        this.data = new int[10];
    }

    public Stack(int initialCapacity) {
        this.data = new int[initialCapacity];
    }

    public void push(int a) {
        if (!isFull()) {
            data[index] = a;
            index++;
        } else {
            throw new StackOverflowError();
        }
    }

    public int pop() {
        if (index == 0) {
            throw new EmptyStackException();
        }
        index--;
        return data[index];
    }

    public int peek() {
        return data[index - 1];
    }

    public boolean isFull() {
        return index >= data.length;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Stack stack = new Stack();

        while (!isEmpty()) {
            int popped = this.pop();
            sb.append(popped)
                    .append(", ");

            stack.push(popped);
        }

        while (!stack.isEmpty()) {
            this.push(stack.pop());
        }

        sb.replace(sb.length() - 2, sb.length(), "}");
        return sb.toString();
    }
}
