/*Input: Permutation of {1, 2 …. n} with one element appearing twice, making it a sequence of n+1 integers.
Output: Identify the element that appears twice in O(n) complexity and O(1) space complexity. */


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
