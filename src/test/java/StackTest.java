import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class StackTest {

    @Test
    public void push() {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i >= 0; i--) {
            Assertions.assertEquals(i, stack.pop());
        }
    }

    @Test
    public void popException() {
        Stack stack = new Stack();
        Assertions.assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void pushException() {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Assertions.assertThrows(StackOverflowError.class, () -> stack.push(10));
    }

    @Test
    public void peek() {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i >= 0; i--) {
            Assertions.assertEquals(9, stack.peek());
        }
    }

}