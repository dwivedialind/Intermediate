package Graphs;

import java.util.Arrays;

class GraphDApp { //Directed Graph
    private final int maxVertex = 20; // max number of vertices
    private Vertex[] vertexList; // array of vertices
    private int nVert; // number of vertices

    private int[][] adjMatrix; //adjacency matrix

    public GraphDApp(){
        vertexList = new Vertex[maxVertex];
        nVert = 0; // as there is no vertex

        for(int i = 0; i < maxVertex; i++){

            Arrays.fill(adjMatrix[i], 0); //initialize adjacency matrix with 0;
        }
    }

  public void addVertex(char lab){
        vertexList[nVert++].label = lab;
    }
    public void addEdge(int start, int end){ //start, end represents vertices at index in vertex List array
        adjMatrix[start][end] =1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label); //display a vertex label
    }

}
