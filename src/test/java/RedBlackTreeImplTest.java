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
        Assertions.assertFalse(redBlackTree.findNode('J').isRedNode());
        redBlackTree.insertElement('T');
        Assertions.assertFalse(redBlackTree.findNode('J').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('T').isRedNode());

        redBlackTree.insertElement('Z');
        Assertions.assertTrue(redBlackTree.findNode('J').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('T').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('Z').isRedNode());

        redBlackTree.insertElement('O');
        Assertions.assertFalse(redBlackTree.findNode('T').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('Z').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('J').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('O').isRedNode());
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

        Assertions.assertFalse(redBlackTree.findNode('G').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('C').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('J').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('V').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('H').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('K').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('Z').isRedNode());
    }
}