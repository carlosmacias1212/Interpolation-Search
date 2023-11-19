// Name: Carlos Macias
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2

// ALGORITHM DESIGN BLOCK

/* Problem Statement:

   A key must be searched for, using the interpolation search algorithm, in a randomly generated array of 1024
   distinct values, between 1 and 9999. This process must be repeatable through user input, and a table should output
   each instance of the algorithm applied on individual arrays with the index of the target value (if found), along
   with the number of divisions executed.
*/

/* Algorithm Logical Steps:

   Given an ordered array of size n, and a key value to search for:
     1. Store the leftmost and rightmost index of the array
     2. Calculate the expected index of the key value, assuming the array values increase linearly
     3. If the element at the calculated index is equal to the key then store ture for found, the index of target value,
     and the number of divisions
     4. If the element at the calculated index is not equal to the key, then if the key is greater, set the leftmost
     index to one plus the calculated index
     5. If the element at the calculated index is not equal to the key, then if the key is less, set the rightmost
     index to the calculated index minus one
     5. When the leftmost index is greater than the rightmost index, stop searching the array
*/

/* Algorithm Pesudcod Syntax:

    Find given key element in a given array and return if found, found index, and divisions of array {
        found <-- false
        index <-- -1
        divisions <-- 0

        l <-- 0
        r <-- Array Size

        while l <= r AND key <= arr[r] AND key >= arr[l]:
            test <-- l + ((key - arr[l])(r-l)) / (arr[r] - arr[l])


            if arr[test] == key:
                index = test
                found = true
                break

            else if arr[test] < key:
                left = test + 1
                divisions = divisions + 1

            else:
                right = test - 1
                divisions = divisions + 1



    }

 */

class InterpolationSearch {
    private boolean found;
    private int index;
    private int divisions;

    InterpolationSearch(int[] arr, int key) {

        //Set low and high indices
        int left = 0;
        int right = arr.length - 1;


        index = -1;
        divisions = 0;
        found = false;

        //Initialize index to evaluate element at
        int test;
        while (left <= right && key >= arr[left] && key <= arr[right]) {
            test = left + (key - arr[left]) * (right - left) / (arr[right] - arr[left]);


            if (arr[test] == key) {
                index = test;
                found = true;
                break;

            } else if (key > arr[test]) {
                left = test + 1;
                divisions++;

            } else {
                right = test - 1;
                divisions++;

            }
        }
    }

    boolean getFound() {
        return found;
    }

    int getIndex() {
        return index;
    }

    int getDivisions() {
        return divisions;
    }
}
