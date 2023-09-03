/* Input: Permutation of {1, 2 …. n} with one element appearing twice, making it a sequence of n+1 integers.
Output: Identify the element that appears twice in O(n) complexity and O(1) space complexity. */


import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Enter array size");
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements");
		int sum = 0;
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		    sum = sum + arr[i];
		}
		n = n-1;  //integers are till n and 1 is repeated so total size is n+1
		sum = sum - (n* (n+1)) / 2;
		System.out.println("Duplicate element is "+sum);
	}
}
