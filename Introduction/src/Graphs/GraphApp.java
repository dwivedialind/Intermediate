package Graphs;
class Vertex{
    public char label;
    public boolean wasVisisted;
    public Vertex(char lab){
        label = lab;
        wasVisisted = false;
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
    }
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
}
public class GraphApp {
}
