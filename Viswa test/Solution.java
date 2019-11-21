import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
class Solution {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size n:");   
        int n = sc.nextInt();
        BST<String, Integer> bst = new BST<String, Integer>();

        System.out.println("enter pairs(k,v) :");   
    for (int i = 0; i<n;i++){
        // Integer k = new Integer(Integer.parseInt(sc.nextLine()));
        Integer v = new Integer(Integer.parseInt(sc.nextLine()));
        String k = sc.nextLine();
        // String v = sc.nextLine();
        bst.put(k,v);
    }
    System.out.println(" max" + bst.max());
    System.out.println(" max" + bst.min());
    System.out.println(" statement "+ bst.isOrdered());

     }
}
