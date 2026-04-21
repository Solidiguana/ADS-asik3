# Assignment 3: Sorting and Searching Algorithm Analysis

## A. Project Overview
In this project, I implemented three fundamental algorithms to analyze their performance and Big-O time complexity in practice.
The chosen algorithms are:
1. **Insertion Sort** (Category A: Basic)
2. **Merge Sort** (Category B: Advanced)
3. **Binary Search** (Category C: Searching)

The main purpose of the experiment is to see how different input sizes (small, medium, large) and input states (random vs sorted) affect the execution time using `System.nanoTime()`.

## B. Algorithm Descriptions
**1. Insertion Sort:**
Builds the final sorted array one item at a time. It takes an element and compares it with the previous elements, shifting them to the right until the correct position is found.
- *Time Complexity:* O(N^2) worst/average case, O(N) best case (if already sorted).

**2. Merge Sort:**
A Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.
- *Time Complexity:* O(N log N) in all cases.

**3. Binary Search:**
Searches a sorted array by repeatedly dividing the search interval in half. If the value is less than the item in the middle, it narrows the interval to the lower half.
- *Time Complexity:* O(log N).

## C. Experimental Results

| Array Size    | Algorithm | Data Type | Time (nanoseconds) |
|---------------|----------|----------|----------------|
| 10            | Insertion | Random   | 6800           |
| 10            | Merge    | Random   | 10600          |
| 100           | Insertion | Random   | 57200          |
| 100           | Merge    | Random   | 55100          |
| 1488          | Insertion | Random   | 2450500        |
| 1488          | Merge    | Random | 352100         |
*(Note: Refer to the screenshots folder for full output).*

**Analysis Answers:**
* **Which sorting algorithm performed faster? Why?** For small arrays (size 10), Insertion sort was sometimes faster or equal because it has less overhead. However, for the large array (1000+), Merge Sort absolutely destroyed Insertion Sort. This is because Merge Sort scales at O(N log N) while Insertion scales at O(N^2).
* **How does performance change with input size?** Time grows exponentially for basic sorts when size increases, but grows much slower for advanced sorts.
* **How does sorted vs unsorted data affect performance?** Insertion Sort becomes incredibly fast on already sorted data (O(N)), acting almost instantly. Merge Sort takes roughly the same time regardless of whether data is sorted or not.
* **Do the results match expected Big-O?** Yes. The massive time jump for Insertion sort at 1488+ elements perfectly demonstrates quadratic O(N^2) behavior.
* **Why does Binary Search require a sorted array?** Because its entire logic relies on knowing that everything to the left is smaller and everything to the right is bigger. Without sorting, dividing the array in half gives no useful information.

## E. Reflection
During this assignment, I clearly saw the difference between theoretical Big-O notation and practical application. I learned that "advanced" algorithms like Merge Sort have recursive overhead, which makes them slightly inefficient for tiny datasets, but they are absolutely necessary for large databases.

A challenge I faced was ensuring the experiment was fair. Initially, I sorted the array with one algorithm and passed the same array to the next one, which ruined the results. I solved this by using `Arrays.copyOf()` to guarantee each algorithm works on the exact same randomized data.