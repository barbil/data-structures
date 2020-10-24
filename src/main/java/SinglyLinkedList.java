public class SinglyLinkedList implements List {
    private Node head;
    private int size;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int var1) {
        Node cursor = head;
        while (cursor != null) {
            if (cursor.data == var1) {
                return true;
            }

            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Node cursor = head;

        int counter = 0;

        while (cursor != null) {
            result[counter] = cursor.data;
            cursor = cursor.next;
            counter++;
        }

        return result;
    }

    @Override
    public boolean add(int var1) {
        if (head == null) {
            head = new Node(var1);
        } else {
            Node cursor = head;

            while (cursor.next != null) {
                cursor = cursor.next;
            }

            cursor.next = new Node(var1);
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }

        int counter = 0;

        Node cursor = head;

        while (cursor != null) {
            if (counter == position) {
                break;
            }
            cursor = cursor.next;
            counter++;
        }

        return cursor.data;
    }

    @Override
    public int set(int var1, int var2) {
        return 0;
    }

    @Override
    public void add(int var1, int var2) {

    }

    @Override
    public int remove(int var1) {
        return 0;
    }

    @Override
    public int indexOf(int var1) {
        return 0;
    }

    @Override
    public int lastIndexOf(int var1) {
        return 0;
    }

    @Override
    public List subList(int var1, int var2) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node cursor = head;

        while (cursor != null) {
            if (cursor.next == null) {
                sb.append(cursor.data);
            } else {
                sb.append(cursor.data)
                        .append(", ");
            }
            cursor = cursor.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
