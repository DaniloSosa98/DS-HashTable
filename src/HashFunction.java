
import java.util.Arrays;

public class HashFunction {

    Customer[] theArray;
    Customer[] linearArray = new Customer[163];
    RedBlackTree[] rbArray = new RedBlackTree[163];
    int arraySize;
    int itemsInArray = 0;

    public HashFunction() {
    }

    public HashFunction(int size) {

        arraySize = size;
        theArray = new Customer[size];
        Arrays.fill(theArray, null);

    }

    public void noHashing(Customer[] customers) {

        for (int i = 0; i < customers.length; i++) {
            Customer newElement = customers[i];

            theArray[newElement.getC_number()] = newElement;
        }

    }

    public void noHashingSearch(int index) {

        if (theArray[index] != null) {
            System.out.println(theArray[index].toString());
        } else {
            System.out.println("Item not found");
        }

    }

    public void linearHash(Customer[] customers) {

        Arrays.fill(linearArray, null);
        boolean insert = false;
        int index;

        for (int i = 0; i < customers.length; i++) {

            Customer newElement = customers[i];
            index = hash(newElement.getC_name());

            while (insert == false) {

                if (linearArray[index] == null) {
                    linearArray[index] = newElement;
                    insert = true;
                }
                index++;

            }
            insert = false;

        }

    }

    public void linearHashSearch(String name) {
        int comparisons = 0;
        int index;
        boolean find = false;
        index = hash(name);
        int flag = index;

        if (linearArray[index] != null) {

            found:
            {

                while (find == false) {

                    if (linearArray[index] != null) {

                        if (linearArray[index].getC_name().contains(name)) {

                            System.out.println(linearArray[index].toString());
                            find = true;
                        }
                    }
                    comparisons++;
                    if (index == 162) {
                        index = 0;
                    } else {
                        index++;
                    }
                    if (index == flag) {
                        System.out.println("Item not found");
                        break found;
                    }
                }
            }

        } else {
            System.out.println("Item not found");
        }
        comparisons++;

        System.out.println("Amount of comparisons: " + comparisons);

    }

    public int hash(String c) {
        int index, hash;
        hash = c.hashCode();
        index = hash % linearArray.length;
        if (index < 0) {
            index = index * -1;
        }
        return index;
    }

    public void rbHashing(Customer[] customers) {

        Arrays.fill(rbArray, null);
        boolean insert = false;
        int index;

        for (int i = 0; i < customers.length; i++) {

            Customer newElement = customers[i];
            index = hashI(newElement.getC_number());

            while (insert == false) {

                if (rbArray[index] == null) {
                    rbArray[index] = new RedBlackTree();
                    rbArray[index].insert(newElement);
                    insert = true;
                } else {
                    rbArray[index].insert(newElement);
                    insert = true;
                }

            }
            insert = false;
        }

    }

    public void rbHashSearch(int id) {

        int index;
        boolean find = false;
        index = hashI(id);
        int flag = index;
        int comparisons = 0;

        if (rbArray[index] != null) {
            found:
            {
                while (find == false) {

                    if (rbArray[index] != null) {
                        if (rbArray[index].search(id)) {
                            find = true;
                        }

                    }
                    comparisons++;
                    if (index == 162) {
                        index = 0;
                    } else {
                        index++;
                    }
                    if (index == flag) {
                        System.out.println("Item not found");
                        break found;
                    }

                }
            }

        } else {
            System.out.println("Item not found");
        }
        comparisons++;

        System.out.println("Amount of comparisons: " + comparisons);
    }

    public int hashI(int id) {
        int index;
        index = id % linearArray.length;
        if (index < 0) {
            index = index * -1;
        }
        return index;
    }
}
