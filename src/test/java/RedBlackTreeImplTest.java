import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedBlackTreeImplTest {

    private RedBlackTreeImpl redBlackTree;

    @BeforeEach
    public void setup() {
        this.redBlackTree = new RedBlackTreeImpl();
    }

    @Test
    public void testInsert() {
        redBlackTree.insertElement('B');
        redBlackTree.insertElement('A');
        redBlackTree.insertElement('C');
        redBlackTree.insertElement('D');
        Assertions.assertEquals("ABCD", redBlackTree.inOrderTraversal());
    }

    @Test
    public void testRightRotation() {
        redBlackTree.insertElement('J');
        redBlackTree.insertElement('G');
        redBlackTree.insertElement('O');
        redBlackTree.insertElement('E');
        redBlackTree.insertElement('H');
        redBlackTree.insertElement('B');
        redBlackTree.insertElement('F');

        RedBlackTreeImpl.Node gNode = redBlackTree.findNode('G');
        RedBlackTreeImpl.Node eNode = redBlackTree.findNode('E');

        Assertions.assertEquals('E', gNode.left.data);
        Assertions.assertEquals('H', gNode.right.data);
        Assertions.assertEquals('J', gNode.parent.data);
        Assertions.assertEquals('G', gNode.parent.left.data);

        redBlackTree.rotateRight(gNode);
        Assertions.assertEquals('F', gNode.left.data);
        Assertions.assertEquals('H', gNode.right.data);
        Assertions.assertEquals('E', gNode.parent.data);
        Assertions.assertEquals('G', gNode.parent.right.data);
        Assertions.assertEquals('B', gNode.parent.left.data);

        redBlackTree.rotateLeft(eNode);
        Assertions.assertEquals('E', gNode.left.data);
        Assertions.assertEquals('H', gNode.right.data);
        Assertions.assertEquals('J', gNode.parent.data);
        Assertions.assertEquals('G', gNode.parent.left.data);
    }

    @Test
    public void colorTest() {
        redBlackTree.insertElement('J');
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('J').getColor());
        redBlackTree.insertElement('T');
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('J').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('T').getColor());

        redBlackTree.insertElement('Z');
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('J').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('T').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('Z').getColor());

        redBlackTree.insertElement('O');
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('T').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('Z').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('J').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('O').getColor());
    }

    @Test
    public void colorTest2() {
        redBlackTree.insertElement('G');
        redBlackTree.insertElement('C');
        redBlackTree.insertElement('R');
        redBlackTree.insertElement('J');
        redBlackTree.insertElement('V');
        redBlackTree.insertElement('H');
        redBlackTree.insertElement('K');
        redBlackTree.insertElement('Z');

        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('G').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('C').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('R').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('J').getColor());
        Assertions.assertEquals(Color.BLACK, redBlackTree.findNode('V').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('H').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('K').getColor());
        Assertions.assertEquals(Color.RED, redBlackTree.findNode('Z').getColor());
    }
}