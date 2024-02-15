package Graphs;
class StackX{
    private final int size = 20;
    private int[] stack;
    private int top;
    public StackX(){
        stack = new int[size];
        top = -1;
    }
    public void push(int value){
        stack[++top] = value;
    }
    public int pop(){
        return stack[top--];
    }
    public int peek(){
        return stack[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
}
public class DFSApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        System.out.print("Visits: ");
        theGraph.dfs(); // depth-first search
        System.out.println();
    }
}
