public class ArrayList implements List {
    private final static int INITIAL_CAPACITY = 1;
    private int[] data = new int[]{INITIAL_CAPACITY};
    private int size = 0;

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
        for (int i = 0; i < size; i++) {
            if (data[i] == var1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }

        return result;
    }

    @Override
    public boolean add(int var1) {
        ensureCapacity();

        data[size] = var1;
        size++;
        return true;
    }

    @Override
    public void clear() {
        data = new int[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[position];
    }

    @Override
    public int set(int position, int var2) {
        int removed = data[position];
        data[position] = var2;

        return removed;
    }

    @Override
    public void add(int object, int position) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }

        ensureCapacity();

        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }

        data[position] = object;
        size++;
    }


    public int remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }

        int result = data[position];

        for (int i = position + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        return result;
    }


    private void ensureCapacity() {
        if (size == data.length) {
            int[] doubleData = new int[2 * data.length];

            for (int i = 0; i < data.length; i++) {
                doubleData[i] = data[i];
            }

            this.data = doubleData;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(data[i])
                        .append("}");
            } else {
                sb.append(data[i])
                        .append(", ");
            }
        }

        return sb.toString();
    }

    @Override
    public int indexOf(int var1) {
        for (int i = 0; i < size; i++) {
            if (data[i] == var1) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(int var1) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == var1) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public List subList(int var1, int var2) {
        if (!(var1 <= var2) || var1 < 0 || var1 > size || var2 > size) {
            throw new IndexOutOfBoundsException();
        }
        List list = new ArrayList();

        for (int i = var1; i < var2; i++) {
            list.add(data[i]);
        }

        return list;
    }
}
