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

    @Test
    public void colorTest3() {
        redBlackTree.insertElement('H');
        Assertions.assertEquals('H', redBlackTree.getRootNode());
        Assertions.assertFalse(redBlackTree.findNode('H').isRedNode());

        redBlackTree.insertElement('R');
        Assertions.assertTrue(redBlackTree.findNode('R').isRedNode());
        Assertions.assertEquals('R', redBlackTree.findNode('H').right.data);

        redBlackTree.insertElement('E');
        Assertions.assertTrue(redBlackTree.findNode('E').isRedNode());
        Assertions.assertEquals('R', redBlackTree.findNode('H').right.data);
        Assertions.assertEquals('E', redBlackTree.findNode('H').left.data);

        redBlackTree.insertElement('O');
        Assertions.assertFalse(redBlackTree.findNode('H').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('O').isRedNode());
        Assertions.assertEquals('E', redBlackTree.findNode('H').left.data);
        Assertions.assertEquals('R', redBlackTree.findNode('H').right.data);
        Assertions.assertEquals('O', redBlackTree.findNode('R').left.data);


        redBlackTree.insertElement('Q');
        Assertions.assertFalse(redBlackTree.findNode('H').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('O').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('Q').isRedNode());

        redBlackTree.insertElement('W');
        Assertions.assertFalse(redBlackTree.findNode('H').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('O').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('Q').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('W').isRedNode());

        redBlackTree.insertElement('X');
        Assertions.assertFalse(redBlackTree.findNode('H').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('O').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('Q').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('W').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('X').isRedNode());

        redBlackTree.insertElement('Y');
        Assertions.assertEquals('Q', redBlackTree.getRootNode());
        Assertions.assertTrue(redBlackTree.findNode('H').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('R').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('O').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('Q').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('W').isRedNode());
        Assertions.assertFalse(redBlackTree.findNode('X').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('Y').isRedNode());
    }


    @Test
    public void testColor4() {
        redBlackTree.insertElement('E');
        Assertions.assertEquals('E', redBlackTree.getRootNode());

        redBlackTree.insertElement('G');
        Assertions.assertEquals('E', redBlackTree.getRootNode());
        Assertions.assertFalse(redBlackTree.findNode('E').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('G').isRedNode());

        redBlackTree.insertElement('F');
        Assertions.assertEquals('F', redBlackTree.getRootNode());
        Assertions.assertEquals('E', redBlackTree.findNode('F').left.data);
        Assertions.assertEquals('G', redBlackTree.findNode('F').right.data);
        Assertions.assertFalse(redBlackTree.findNode('F').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('G').isRedNode());
        Assertions.assertTrue(redBlackTree.findNode('E').isRedNode());

        Assertions.assertFalse(redBlackTree.isRedNode('F'));
        Assertions.assertTrue(redBlackTree.isRedNode('G'));
        Assertions.assertTrue(redBlackTree.isRedNode('E'));

        Assertions.assertEquals("FEG", redBlackTree.preOrderTraversal());
        Assertions.assertEquals("EGF", redBlackTree.postOrderTraversal());
    }

}