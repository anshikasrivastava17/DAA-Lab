/* Input: A file containing following details for some n 
Roll number 1        Name 1
Roll number 2        Name 2
.				  
.
.
Roll number n        Name n

Output: Another file that is sorted as per the roll numbers given in the input file Use merge sort for sorting.  */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int rollNumber;
    char name[50];
} Student;

void merge(Student* students, int left, int mid, int right) {
    int i, j, k;
    int n1 = mid - left + 1;
    int n2 = right - mid;

    Student* L = (Student*) malloc(n1 * sizeof(Student));
    Student* R = (Student*) malloc(n2 * sizeof(Student));

    for (i = 0; i < n1; i++)
        L[i] = students[left + i];
    for (j = 0; j < n2; j++)
        R[j] = students[mid + 1 + j];

    i = 0;
    j = 0;
    k = left;

    while (i < n1 && j < n2) {
        if (L[i].rollNumber <= R[j].rollNumber) {
            students[k] = L[i];
            i++;
        } else {
            students[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        students[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        students[k] = R[j];
        j++;
        k++;
    }

    free(L);
    free(R);
}

void mergeSort(Student* students, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(students, left, mid);
        mergeSort(students, mid + 1, right);

        merge(students, left, mid, right);
    }
}

int main() {
    FILE* inputFile = fopen("Input.txt", "r");
    FILE* outputFile = fopen("Output.txt", "w");

    Student students[1000];
    int count = 0;

    while (!feof(inputFile)) {
        fscanf(inputFile, "Roll Number %d Name %[^\n]\n", &students[count].rollNumber, students[count].name);
        count++;
    }

    mergeSort(students, 0, count - 1);

    for (int i = 0; i < count; i++) {
        fprintf(outputFile, "Roll Number %d\tName %s\n", students[i].rollNumber, students[i].name);
    }

    fclose(inputFile);
    fclose(outputFile);

    return 0;
}
