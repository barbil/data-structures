public class RedBlackTreeImpl implements RedBlackTree {

    public static class Node {
        public final char data;
        public Node parent;
        public Node left;
        public Node right;
        private boolean isRedNode;

        public Node(char data, Color color) {
            this.data = data;
            this.isRedNode = (color != Color.BLACK);
        }

        public Node(char data, Color color, Node parent) {
            this.data = data;
            this.isRedNode = (color != Color.BLACK);
            this.parent = parent;
        }

        public void setRedNode(boolean redNode) {
            isRedNode = redNode;
        }

        public Color getColor() {
            return (isRedNode ? Color.RED : Color.BLACK);
        }

        public void setColor(Color color) {
            this.isRedNode = color != Color.BLACK;
        }
    }

    private Node root;

    public RedBlackTreeImpl() {
    }

    @Override
    public void insertElement(char key) {
        balance(BSTInsertElement(key));
    }

    private void balance(Node node) {
        if (node == root) {
            node.setColor(Color.BLACK);
        }

        if (node != root && node.parent.getColor() == Color.RED) {
            if (isUncleRed(node)) {
                recolor(node);
            } else {
                rotate(node);
            }
        }
    }

    public void recolor(Node node) {
        Node uncle = getUncle(node);
        uncle.setColor(Color.BLACK);
        node.parent.setColor(Color.BLACK);
        node.parent.parent.setColor(Color.RED);
        balance(node.parent.parent);
    }

    public void rotate(Node node) {
        if (isLeftLeftCase(node)) {
            applyLeftLeftCase(node);
        } else if (isLeftRightCase(node)) {
            rotateLeft(node.parent);
            applyLeftLeftCase(node);
        } else if (isRightRightCase(node)) {
            applyRightRightCase(node);
        } else if (isRightLeftCase(node)) {
            rotateRight(node.parent);
            applyRightRightCase(node);
        }
    }

    public void applyRightRightCase(Node node) {
        if (node.parent != null) {
            node.parent.setRedNode(!node.parent.isRedNode);

            if (node.parent.parent != null) {
                node.parent.parent.setRedNode(!node.parent.parent.isRedNode);
                rotateLeft(node.parent.parent);
            }
        }
    }

    public void applyLeftLeftCase(Node node) {
        if (node.parent != null) {
            node.parent.setRedNode(!node.parent.isRedNode);

            if (node.parent.parent != null) {
                node.parent.parent.setRedNode(!node.parent.parent.isRedNode);
                rotateRight(node.parent.parent);
            }
        }
    }

    public void rotateLeft(Node node) {
        Node x = node;
        Node y = node.right;
        Node temp = y.left;

        if (x.parent != null) {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {
            root = y;
        }

        y.parent = x.parent;
        y.left = x;
        x.parent = y;
        x.right = temp;
    }

    public void rotateRight(Node node) {
        Node y = node;
        Node x = node.left;
        Node temp = x.right;

        if (y.parent.left == y) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        x.parent = y.parent;
        x.right = y;
        y.parent = x;
        y.left = temp;
    }

    private boolean isLeftLeftCase(Node node) {
        return node == node.parent.left &&
                node.parent == node.parent.parent.left;
    }

    private boolean isLeftRightCase(Node node) {
        return node == node.parent.right &&
                node.parent == node.parent.parent.left;
    }

    private boolean isRightRightCase(Node node) {
        return node == node.parent.right &&
                node.parent == node.parent.parent.right;
    }

    private boolean isRightLeftCase(Node node) {
        return node == node.parent.left &&
                node.parent == node.parent.parent.right;
    }

    private Node getUncle(Node node) {
        if (node.parent == null || node.parent.parent == null) {
            return null;
        }

        Node uncle;

        if (node.parent.parent.left == node.parent) {
            uncle = node.parent.parent.right;
        } else {
            uncle = node.parent.parent.left;
        }

        return uncle;
    }

    private boolean isUncleRed(Node node) {
        if (node.parent == null || node.parent.parent == null) {
            return false;
        }

        Node uncle;

        if (node.parent.parent.left == node.parent) {
            uncle = node.parent.parent.right;
        } else {
            uncle = node.parent.parent.left;
        }

        if (uncle == null) {
            return false;
        }

        return uncle.getColor() == Color.RED;
    }

    @Override
    public Pair<Character, Character> getChildrenNodesValues(char key) {
        Node node = findNode(key);

        return new Pair<>(node.left.data, node.right.data);
    }

    @Override
    public boolean isRedNode(char key) {
        return findNode(key).isRedNode;
    }

    @Override
    public char getRootNode() {
        return root.data;
    }

    @Override
    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    private void preOrderTraversal(Node currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }

        sb.append(currentNode.data);
        preOrderTraversal(currentNode.left, sb);
        preOrderTraversal(currentNode.right, sb);
    }

    @Override
    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversal(root, sb);
        return sb.toString();
    }

    private void postOrderTraversal(Node currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }

        postOrderTraversal(currentNode.left, sb);
        postOrderTraversal(currentNode.right, sb);
        sb.append(currentNode.data);
    }

    @Override
    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    private void inOrderTraversal(Node currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }

        inOrderTraversal(currentNode.left, sb);
        sb.append(currentNode.data);
        inOrderTraversal(currentNode.right, sb);
    }

    private Node BSTInsertElement(char key) {
        if (root == null) {
            root = new Node(key, Color.BLACK);
            return root;
        }

        Node cursor = root;

        while (true) {
            if (key > cursor.data) {
                if (cursor.right == null) {
                    cursor.right = new Node(key, Color.RED, cursor);
                    return cursor.right;
                }
                cursor = cursor.right;
            } else {
                if (cursor.left == null) {
                    cursor.left = new Node(key, Color.RED, cursor);
                    return cursor.left;
                }
                cursor = cursor.left;
            }
        }
    }

    public Node findNode(char ch) {
        Node cursor = this.root;

        while (cursor != null) {
            if (ch > cursor.data) {
                cursor = cursor.right;
            } else if (ch < cursor.data) {
                cursor = cursor.left;
            } else {
                return cursor;
            }
        }
        return null;
    }

}
