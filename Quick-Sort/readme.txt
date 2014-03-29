Quick sort:

- elements are sorted around a pivot (less to the left, equal in the middle, greater to the right) using the partition method
- the "less than" and "greater than" segments are then partitioned themselves, and then they're partitioned, etc., recursively, until the data reaches a short enough length that it can no longer be partitioned
- after every broken-down data set has reached the base case, the elements have been sorted