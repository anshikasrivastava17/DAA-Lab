import java.util.Scanner;
public class fibo 
{	
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of terms");
        long a=1L,b=2L,n,sum=0L;
        n = sc.nextLong();
	    System.out.println("The Fibonacci series till " + n + " is:");
		for(int i=1;i<=n;i++)
		{
        if (i == n) 
        System.out.println(a);
        sum = a+b;
		a = b;
        b = sum;
		}
	}
}
