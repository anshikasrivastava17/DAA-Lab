/**Find the value of  (1+i)^ n where i = sqrt (-1) in O(log2n) time and O(log2n) space.
Input: n
Output: (1+i)^n **/


import org.apache.commons.math3.complex.Complex;

public class ComplexPower {
    public static void main(String[] args) {
        // Complex is a datatype
        int n = 10; // exponent
        Complex base = new Complex(1, 1); // Define the base (1 + 1i)
        Complex result = complexPower(base, n);
        System.out.println("(1 + i)^" + n + " = " + result);
    }

    public static Complex complexPower(Complex base, int n) {
        if (n == 0)
            return Complex.ONE; // power zero = 1 + 0i
        else if (n % 2 == 0) {
            Complex halfPower = complexPower(base, n / 2);
            return halfPower.multiply(halfPower);
        } else {
            return base.multiply(complexPower(base, n - 1));
        }
    }
}
