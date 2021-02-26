
public class RBNode {

    RBNode leftNode;
    RBNode rightNode;
    Customer value;
    int color;

    public RBNode(Customer val) {

        this(val, null, null);

    }

    public RBNode(Customer val, RBNode left, RBNode right) {

        value = val;
        leftNode = left;
        rightNode = right;
        color = 1;

    }

    @Override
    public String toString() {

        if (value.getC_number() != Integer.MIN_VALUE) {

            return String.valueOf(value);

        }

        return "Sentinel";

    }

}
