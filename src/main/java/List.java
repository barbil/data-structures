public interface List {
    int size();

    boolean isEmpty();

    boolean contains(int var1);

    int[] toArray();

    boolean add(int var1);

    void clear();

    int get(int var1);

    int set(int var1, int var2);

    void add(int var1, int var2);

    int remove(int var1);

    int indexOf(int var1);

    int lastIndexOf(int var1);

    List subList(int var1, int var2);
}
