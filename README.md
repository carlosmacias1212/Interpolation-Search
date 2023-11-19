# Interpolation-Search
A key must be searched for, using the interpolation search algorithm, in a randomly generated array of 1024 distinct values, between 1 and 9999. This process must be repeatable through user input, and a table should output each instance of the algorithm applied on individual arrays with the index of the target value (if found), along with the number of divisions executed.

# Logical Steps
   Given an ordered array of size n, and a key value to search for:
   
     1. Store the leftmost and rightmost index of the array
     
     2. Calculate the expected index of the key value, assuming the array values                
        increase linearly
     
     3. If the element at the calculated index is equal to the key then store ture for        
        found, the index of target value, and the number of divisions
     
     4. If the element at the calculated index is not equal to the key, then if the key   
        is greater, set the leftmost index to one plus the calculated index
        
     5. If the element at the calculated index is not equal to the key, then if the key         
        is less, set the rightmost index to the calculated index minus one
     
     6. When the leftmost index is greater than the rightmost index, stop searching the        
        array
