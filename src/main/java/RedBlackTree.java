
public interface RedBlackTree {
    void insertElement(char key);

    Pair<Character, Character> getChildrenNodesValues(char key);

    boolean isRedNode(char key);

    char getRootNode();

    String preOrderTraversal();

    String postOrderTraversal();

    String inOrderTraversal();
}
