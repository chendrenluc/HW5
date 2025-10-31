/******************************************************************
 *
 *   Connor Hendren / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        //Store all elements of list1 in a hashset for the lookup
        //Must NOT be worse than O(n), so this will help keep it at that
        Set<Integer> set = new HashSet<>();
        for(int num : list1) {
            set.add(num);
        }
        //Now check if every element in list2 exists in the set
        //If an element is in list2 but not list1
        for(int num : list2) {
            if(!set.contains(num)) {
                return false;
            }
        }
        //Otherwise must have all elements in both
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        //Use a min heap to find and store the largest elements
        //Make sure to remove all the smallest elements to keep only the largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : array) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //Find the root of the min heap to find the kth largest
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        //Add all elements to a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : array1) {
            minHeap.offer(num);
        }
        for(int num: array2) {
            minHeap.offer(num);
        }
        //Now extract the elements in a sorted order
        int[] result = new int[array1.length + array2.length];
        //Gonna use a while loop so it knows when to stop
        int i = 0;
        while(!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }
        //Return the result
        return result;
    }

}
