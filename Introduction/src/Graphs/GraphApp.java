package Graphs;

import java.util.Stack;

class Vertex{
    public char label; //a label for a Vertex
    public boolean wasVisisted; // to tell if vertex is visited
    public Vertex(char lab){
        label = lab; // set to char that we give
        wasVisisted = false; // initially it is false
    }

}
class Graph{
    private final int maxVertex = 20; //max number of vertices in graph
    private Vertex[] vertexList; //array of vertices
    private int nVert; // no. of vertices
    private int[][] adjMatrix; //adjacency matrix;
    public Graph(){ //constructor
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];

        nVert = 0;
        for(int i = 0; i < maxVertex; i++)
            for(int j = 0; j < maxVertex; j++)
                adjMatrix[i][j] = 0; // initialize adj matrix with 0
    }
    public void addVertex(char lab){  //argument is label
        vertexList[nVert++] = new Vertex(lab);
    } // add new vertex
    public void addEdge(int start, int end){ // make two vertices adjacent
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void dfs(){
        //begin at vertex 0
        vertexList[0].wasVisisted = true; // mark it
        StackX stack = new StackX(); // create a stack
        displayVertex(0); //display a vertex
        stack.push(0); // push it

        while(!stack.isEmpty()){ // until stack empty
            int j = getAdjUnvisitedVertex(stack.peek()); // get adjacent unvisited vertex of vertex at top of stack
            if(j == -1)
                stack.pop();
            else{
                vertexList[j].wasVisisted = true; // mark it
                stack.push(j); // push it
                displayVertex(j); //display it

            }
        }
        for(int i = 0 ;i < nVert; i++)
            vertexList[i].wasVisisted = false; // as stack is empty


    }

    public void bfs(){
        Queue queue = new Queue();
        //starting vertex is at 0
        vertexList[0].wasVisisted = true; //mark it
        displayVertex(0); //display it
        queue.insert(0);// insert into queue
        while(!queue.isEmpty()){ //till queue is not empty
            int v = queue.remove();
            while(getAdjUnvisitedVertex(v)!=-1){
                int j = getAdjUnvisitedVertex(v);
                vertexList[j].wasVisisted = true; // mark it
                queue.insert(j); // push it
                displayVertex(j); // display it
            }
        }
        for(int i = 0 ;i < nVert; i++)
        vertexList[i].wasVisisted = false; // as queuw is empty
    }
    public void mst(){
        //start from vertex 0
        StackX stack = new StackX();
        vertexList[0].wasVisisted = true; //mark it
        stack.push(0); //push it
        while(!stack.isEmpty()){
            int currentVertex = stack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if(v==-1){ //no univisited adjactent vertex
                stack.pop();
            }else{
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
                vertexList[v].wasVisisted = true; // mark it
                stack.push(v); // push it
            }
        }
    }
    public int getAdjUnvisitedVertex(int v){
        for(int i =0 ; i< nVert; i++)
            if(adjMatrix[v][i]  == 1 && !vertexList[i].wasVisisted)
                return i;
        return -1; //no adjacent vertice remains unvisited.
    }
}
public class GraphApp {
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
        theGraph.bfs(); // breadth-first search
        System.out.println();
    }
}
