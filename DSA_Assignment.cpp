#include <iostream>
using namespace std;

// Swap function
void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

// Bubble Sort - O(n^2) time, O(1) space
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}

// Selection Sort - O(n^2) time, O(1) space
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        swap(arr[i], arr[minIdx]);
    }
}

// Insertion Sort - O(n^2) worst, O(n) best, O(1) space
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Binary Search - O(log n) time, O(1) space
int binarySearch(int arr[], int n, int target) {
    int left = 0, right = n - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// Linear Search - O(n) time, O(1) space
int linearSearch(int arr[], int n, int target) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}

int main() {
    int n, choice, target;
    cout << "Enter the number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter " << n << " elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int temp[n];
    for (int i = 0; i < n; i++) temp[i] = arr[i];

    cout << "Choose sorting algorithm: 1. Bubble Sort 2. Selection Sort 3. Insertion Sort : ";
    cin >> choice;

    switch (choice) {
        case 1: bubbleSort(temp, n); break;
        case 2: selectionSort(temp, n); break;
        case 3: insertionSort(temp, n); break;
        default: cout << "Invalid choice!"; return 1;
    }

    cout << "Sorted elements: ";
    for (int i = 0; i < n; i++) cout << temp[i] << " ";
    cout << "\n";

    cout << "Enter target element for searching: ";
    cin >> target;

    cout << "Choose search method: 1. Linear Search 2. Binary Search\n";
    cin >> choice;

    int result = (choice == 1) ? linearSearch(temp, n, target) : binarySearch(temp, n, target);

    if (result != -1) cout << "Element found at index " << result << "\n";
    else cout << "Element not found!\n";

    // Determine the most efficient sorting algorithm based on complexity
    cout << "Efficiency Analysis:\n";
    cout << "Bubble Sort: O(n^2) time, O(1) space\n";
    cout << "Selection Sort: O(n^2) time, O(1) space\n";
    cout << "Insertion Sort: O(n^2) worst, O(n) best, O(1) space\n";
    cout << "Linear Search: O(n) time, O(1) space\n";
    cout << "Binary Search: O(log n) time, O(1) space (requires sorted array)\n";
    cout << "For large datasets, consider more efficient algorithms like QuickSort or MergeSort.\n";
    
    return 0;
}
