package Graphs;
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
        System.out.println(vertexList[v].label);
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
    public int getAdjUnvisitedVertex(int v){
        for(int i =0 ; i< nVert; i++)
            if(adjMatrix[v][i]  == 1 && !vertexList[i].wasVisisted)
                return i;
        return -1; //no adjacent vertice remains unvisited.
    }
}
public class GraphApp {
}
