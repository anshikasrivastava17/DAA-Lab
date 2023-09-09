/*Input: Permutation of {1, 2 …. n} with one element appearing twice, making it a sequence of n+1 integers.
Output: Identify the element that appears twice in O(n) complexity and O(1) space complexity. */

//METHOD-1

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int l = scanner.nextInt();

        int arr[] = new int[l];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < l; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0, sqsum = 0;
        int n = l - 2;
        int x, y;

        for (int i = 0; i < l; i++) {
            sum = sum + arr[i];
            sqsum = sqsum + (arr[i] * arr[i]);
        }

        sum = sum - ((n * (n + 1)) / 2);
        sqsum = sqsum - (n * (n + 1) * (2 * n + 1)) / 6;

        for (x = 0; x <= sum; x++) {
            y = sum - x;
            if (x * x + y * y == sqsum) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                break; 
            }
        }
        scanner.close();
    }
}


//METHOD-2
import java.util.Scanner;
class Double_duplicate {
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;
        }

        System.out.println("The repeating elements are : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.print(i + " ");
            }
        }
    }
}
