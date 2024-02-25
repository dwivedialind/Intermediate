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
The node at top of tree is called root. There is only one root in a tree.  
For a collection of nodes and edges to be defined as a tree, there must be one(`one and only one!`) path from the root to any other node.  
### Leaf
A node that has no children.  
### Subtree
A node's subtree contains all its descendants  
### Visiting
A node is visited when program control arrives at the node, usually for the purpose of carrying out some operation on the node.  
Merely passing over a node on the path from one node to another is not considered to be visiting the node.  
### Traversing
To `Traverse` a tree means to visit all the nodes in some specified order.  
### Levels
root is levle 0, then its children level 1, its grandchildren will be level 2, and so on.  
### Keys
This value is used to search for the item or perform other operations on it.  




