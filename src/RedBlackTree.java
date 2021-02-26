
public class RedBlackTree {

    private RBNode current;
    private RBNode parent;
    private RBNode grand;
    private RBNode great;
    RBNode root;
    private static RBNode nullNode;
    public static int comparisons = 0;

    static {
        nullNode = new RBNode(new Customer(0));
        nullNode.leftNode = nullNode;
        nullNode.rightNode = nullNode;

    }

    static final int BLACK = 1;
    static final int RED = 0;

    //Constructor With Sentinel
    public RedBlackTree() {
        root = new RBNode(new Customer(0));
        root.leftNode = nullNode;
        root.rightNode = nullNode;
    }

    public void insert(Customer item) {

        grand = root;
        parent = grand;
        current = parent;

        nullNode.value = item;

        while (current.value != item) {

            great = grand;
            grand = parent;
            parent = current;

            if (item.getC_number() < current.value.getC_number()) {

                current = current.leftNode;

            } else {

                current = current.rightNode;

            }

            // Check if two red children and fix if so            
            if (current.leftNode.color == RED && current.rightNode.color == RED) {

                handleReorient(item);

            }
        }

        // Insertion fails if already present
        if (current != nullNode) {
            return;
        }

        current = new RBNode(item, nullNode, nullNode);

        //Attach to parent
        if (item.getC_number() < parent.value.getC_number()) {

            parent.leftNode = current;
        } else {

            parent.rightNode = current;
        }

        handleReorient(item);
    }

    private void handleReorient(Customer item) {

        //Do the color flip
        current.color = RED;
        current.leftNode.color = BLACK;
        current.rightNode.color = BLACK;

        if (parent.color == RED) {

            //Have to rotate
            grand.color = RED;

            if (item.getC_number() < grand.value.getC_number() != item.getC_number() < parent.value.getC_number()) {

                parent = rotate(item, grand);

            }

            current = rotate(item, great);
            current.color = BLACK;

        }

        //Make root black
        root.rightNode.color = BLACK;

    }

    private RBNode rotate(Customer item, RBNode parent) {

        if (item.getC_number() < parent.value.getC_number()) {

            if (item.getC_number() < parent.leftNode.value.getC_number()) {
                return parent.leftNode = rotateWithLeftChild(parent.leftNode);

            } else {
                return parent.leftNode = rotateWithRightChild(parent.leftNode);

            }

        } else {
            if (item.getC_number() < parent.rightNode.value.getC_number()) {
                return parent.rightNode = rotateWithLeftChild(parent.rightNode);

            } else {
                return parent.rightNode = rotateWithRightChild(parent.rightNode);

            }

        }
    }

    //Rotate with left child
    private RBNode rotateWithLeftChild(RBNode n2) {
        RBNode n1 = n2.leftNode;
        n2.leftNode = n1.rightNode;
        n1.rightNode = n2;
        return n1;
    }

    //Rotate with right child
    private RBNode rotateWithRightChild(RBNode n1) {
        RBNode n2 = n1.rightNode;
        n1.rightNode = n2.leftNode;
        n2.leftNode = n1;
        return n2;
    }

    //Search
    public boolean search(int val) {
        comparisons = 0;
        comparisons++;
        if (search(root.rightNode, val)) {
            System.out.println("Amount of comparisons in the Tree: " + comparisons);
            System.out.println("The value was found");
            return true;
        } else {
            
            return false;
        }

    }

    private boolean search(RBNode node, int val) {
        boolean found = false;
        while ((node != nullNode) && !found) {
            int nval = node.value.getC_number();
            if (val < nval) {
                node = node.leftNode;
            } else if (val > nval) {
                node = node.rightNode;
            } else {
                found = true;
                break;
            }
            found = search(node, val);
            comparisons++;
        }
        
        if (found) {
            System.out.println(node.toString());
        }
        return found;
    }
}
