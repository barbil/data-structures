import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SinglyLinkedListTest {

    @Test
    public void testAdd() {
        List linkedList = new SinglyLinkedList();
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(21);
        System.out.println(linkedList);
    }

    @Test
    public void sizeTest() {
        List linkedList = new SinglyLinkedList();
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(21);

        Assertions.assertEquals(5, linkedList.size());
    }

    @Test
    public void toArrayTest() {
        List linkedList = new SinglyLinkedList();
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(21);

        System.out.println(linkedList);

        System.out.println(Arrays.toString(linkedList.toArray()));
    }

    @Test
    public void testGet() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(2);

        Assertions.assertEquals(2, linkedList.get(0));
    }

}