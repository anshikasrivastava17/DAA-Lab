/* Find the maximum subarray sum from an array entered by the user using Divide and Conquer method */

#include<stdio.h>
#include <limits.h>
#define max(a, b) ((a) > (b) ? (a) : (b))

int maxCrossSum(int arr[], int l, int m, int r) 
{
    int sum = 0;
    int left_sum = INT_MIN;
    for (int i = m; i >= l; i--)  //from middle towards left
     { 
        sum += arr[i];
        if (sum > left_sum)
        left_sum = sum;
    }

    sum = 0;
    int right_sum = INT_MIN;
    for (int i = m + 1; i <= r; i++) //from middle toward right
    {
        sum += arr[i];
        if (sum > right_sum)
        right_sum = sum;
    }

    return left_sum + right_sum;  //max sum across midpt. 
}


int maxSubarray(int arr[], int l, int r) {
    if (l == r) {
        return arr[l];   //single element left
    }

    int m = l + (r - l) / 2; 

    int maxLeftSum = maxSubarray(arr, l, m);
    int maxRightSum = maxSubarray(arr, m + 1, r);
    int maxCrossing = maxCrossSum(arr, l, m, r);

    return max(max(maxLeftSum, maxRightSum), maxCrossing);  //max of all three sums
}

int main()
{
    printf("Enter size of array\n");
    int size;
    scanf("%d",&size);
    int arr[size]; 
    printf("Enter elements of array\n");
    for(int i=0;i<size;i++)
    {
        scanf("%d",&arr[i]);
    }
    int maxSum = maxSubarray(arr, 0, size - 1); //passed the entire array
    printf("Maximum subarray sum is: %d\n", maxSum);
    return 0;
}
