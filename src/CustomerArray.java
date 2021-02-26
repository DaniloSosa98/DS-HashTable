
public class CustomerArray {

    public static int many;

    public CustomerArray() {
    }

    public Customer[] insert(Customer arr[], int nElements, Customer c, int max) {

        if (nElements >= max) {
            System.out.println("The array is already full");
            return arr;
        }

        arr[nElements] = c;
        many++;
        return arr;
    }

    public boolean isFull(Customer[] a) {

        int Nelements = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                Nelements++;
            }
        }

        return Nelements == 0;

    }

    public void print(int n, Customer[] a) {
        for (int i = 0; i < n; i++) {
            System.out.println(a[i].toString());
        }
        System.out.println("---------------------------------------------------");
    }

}
