
import java.util.Scanner;

public class Driver {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        /*The 1st and 3rd part were done by hashing CustomerID while the 2nd 
        was done by hashing CustomerName*/
        
        String resp = "y";
        int op;
        Customer[] cArray = Connector.Connect();

        do {
            System.out.println("\n*****MENU*****");
            System.out.println("1.O(1) Search\n2.Linear Probing\n3.RedBlackTree");
            op = sc.nextInt();

            switch (op) {
                case 1: {
                    
                    HashFunction hash1 = new HashFunction(500);
                    hash1.noHashing(cArray);
                    
                    System.out.println("Enter the Customer ID of the Customer to find:");
                    int id = sc.nextInt();
                    
                    hash1.noHashingSearch(id);
                    
                    break;
                }
                case 2: {
                    
                    HashFunction hash2 = new HashFunction();
                    hash2.linearHash(cArray);
                    
                    System.out.println("Insert customer name to find:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    
                    hash2.linearHashSearch(name);
                    
                    
                    break;
                }

                case 3: {
                    
                    HashFunction hash3 = new HashFunction();
                    hash3.rbHashing(cArray);
                    
                    System.out.println("Enter the Customer ID of the Customer to find:");
                    int id = sc.nextInt();
                    
                    hash3.rbHashSearch(id);
                    
                    break;
                }
            }
            
            System.out.println("Do you want to do a new operation? (y/n)");
            resp = sc.next();

        } while (!resp.contains("n"));

    }

}
