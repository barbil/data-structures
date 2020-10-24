import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArrayListTest {
    private static List data;

    @BeforeAll
    public static void setup() {
        data = new ArrayList();

        for (int i = 0; i < 10; i++) {
            data.add(i + 1);
        }
    }

    @Test
    public void add() {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(3);

        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void insert() {
        ArrayList list = new ArrayList();

        for (int i = 10; i > 0; i--) {
            list.add(i, 0);
        }

        System.out.println(list);
    }

    @Test
    public void insertInvalidPosition() {
        ArrayList list = new ArrayList();
        list.add(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.add(4, 2);
        });
    }

    @Test
    public void insertInvalidPosition2() {
        ArrayList list = new ArrayList();
        list.add(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.add(4, -1);
        });
    }

    @Test
    public void remove() {
        ArrayList list = new ArrayList();

        for (int i = 10; i > 0; i--) {
            list.add(i, 0);
        }
        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            System.out.println("Removing " + list.get(i) + " at position " + i);
            list.remove(i);
            System.out.println(list);
        }

        System.out.println(list);
    }

    @Test
    public void testSubList() {
        System.out.println(data);
        List list = data.subList(5, 10);
        System.out.println(list);
    }
}