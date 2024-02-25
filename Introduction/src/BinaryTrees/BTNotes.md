# Binary Tree  

Why you want to use a tree? Advantages of two other structures: `an ordered array and linked list.`  
Search a tree quickly as in ordered array, and also insert and delete items quickly as in Linked List.  

## Slow Insertion in an Ordered Array

In ordered Array, Binary Search in `O(logN)`.  
While Inserting includes find right position to insert and move elements.  
Similary Deleting involves the same multimove operations and is thus equally slow.  

## Slow Searching in a Linked List

In LL, insertions and deletions are `O(1)`  
Searching process is slow `O(N)`  

## What Is a Tree?

Edges are likely to be represented in a program by reference, if the program is written in java (or by pointer if the program is written in C or C++).  
Trees in which nodes can have more than two children, are called multiway trees.  

### Path  
Think of someone walking from node to node along the edges that connect them. The resulting sequence of nodes is called a path.  
### Root


