package WeightedGraphs;
class Vertex{
    public char label; //label for a class
    public boolean wasVisited;
    public Vertex(char lab){
        label = lab;
        wasVisited = false;
    } //end constructor
    public void displayVertex(){
        System.out.print(label);
    }
}//end Vertex
class Edge{ // used as element in priority queue
    public int source; // edge from
    public int destination; //edge to
    public int weight; // weight of edge
    public Edge(int s, int d, int w){
        source = s;
        destination = d;
        weight = w;
    }
    public void displayEdge(){
        System.out.print(source+""+destination+""+weight+" ");
    }
}
class PriorityQueue{
    private final int maxSize = 100; // max no. of elements it can hold
    private int size; //no. of elements in queue
    private Edge[] queue; // queue of edges with minimum weight at front
    private int front;
    private int rear;
    /*
    methods priority queue should have:
    i. insert at correct position
    ii. remove then shift
    iii. remove duplicate
    iv. remove ones that are already in tree.

     */
    public PriorityQueue(){
        queue = new Edge[maxSize]; // initialize to 100
        size = 0;
        front = -1;
        rear = 0;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public boolean isFull(){
        return size == maxSize;
    }
    public void insert(Edge newEdge){

        if(isEmpty()){//if there exists no edge
            queue[++front] = newEdge;
            size++;
            return;
        }else{
            int dup = duplicate(newEdge); // find if exists duplicate
            if(dup == -1){ //that means no duplicate or duplicate with more weight
                removeDup(newEdge);
                int i;
                for(i = front; i >= rear; i--){ //find correct spot for newEdge
                    if(queue[i].weight>newEdge.weight)
                        break; // so correct position is i+1
                }
                for(int j = front; j>i; j-- ){ //shifting at higher position
                    queue[j+1] = queue[j];
                }
                front++; // increment front
                size++; // increment size
                queue[i+1] = newEdge;

            }
        }
    }
    public int duplicate(Edge edge){
        /*
            Three conditions can arise:
            i. having same destination with more weight. in that case we have to remove one with more weight and add new
            ii. having less weight with same destination. in that case we don't add new.
            iii. not having with same destination . in that case we have to add new.
            So in condition i and iii we have to add new. but in second condition we don't

         */
        int i;
        for(i = front; i >= rear ; i--){ // check from front to rear
            if(queue[i].destination == edge.destination && queue[i].weight < edge.weight ){
                return 1; //if there exists with less weight then we don't have to add new. fulfills second condition
            }
        }
        //now it comes out of loop if find with more weight or not any. in this case first we have to remove duplicate and then add new
        return -1;
    }

    public Edge removeTop(){
        size--; //decrement size
        return queue[front--];
    }
    public void removeDup(Edge edge){
        //this will remove if any with more weight and if there is none then it returns.
        //we can modify the duplicate method
        int i;
        for(i = front; i >= rear ; i--){ // check from front to rear
            if(queue[i].destination == edge.destination && queue[i].weight > edge.weight ){
                //if exists we have to shift at lower position
                for(int j = i ; j<front; j++){
                    queue[j] = queue[j+1];
                }
                front--; //decrement front
                size--; //decrement size
                return; // exit all done
            }

        }
        //if exist no duplicate it will come out
    }

    public void displayQueue(){
        for(int i = front ; i >=rear; i--)
            queue[i].displayEdge();
        System.out.print("");
    }


}
class Graph{
    private final int maxVertex = 20; // max no. of vertices
    private int nVerts; // no. of vertices
    private Vertex[] vertexList; //array of vertices
    private int[][] adjMatrix; //adjacency matrix
    public Graph(){
        vertexList = new Vertex[maxVertex];
        nVerts = 0;
        adjMatrix = new int[maxVertex][maxVertex];
        for(int i = 0 ; i< maxVertex ; i++)
            for(int j = 0; j < maxVertex; j++)
                adjMatrix[i][j] = -1; // initialise with -1
    }
    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int start, int end, int weight){ //undirected weighted graph
        adjMatrix[start][end] = weight;
        adjMatrix[end][start] = weight;
    }

    public void mstw(){
        //begins at 0
        PriorityQueue queue = new PriorityQueue();
        int[] Tree = new int[nVerts];
        int newest = 0; // no. of elements in a tree
        Tree[newest++] = 0;
        vertexList[0].wasVisited = true;
        while(newest!=nVerts){ //when all the vertices are visited
            int currentVertice = Tree[newest-1];
           for(int i = 0; i < nVerts; i++){
               if(adjMatrix[currentVertice][i]!=-1 && !vertexList[i].wasVisited){//edges that have weight
                   Edge newEdge = new Edge(currentVertice,i,adjMatrix[currentVertice][i]);
                   queue.insert(newEdge); //insert those edges in priority queue
               }
           }
           //now we have to remove minimum distance, i.e at top of priority queue
            //queue.displayQueue();
            Edge ed = queue.removeTop(); //removes at top
            vertexList[ed.source].displayVertex();
            vertexList[ed.destination].displayVertex();
            System.out.print(" ");
            Tree[newest++] = ed.destination;
            vertexList[ed.destination].wasVisited = true; //mark it that means it's in tree
        }
    }
    public void displayMatrix(){
        for(int i = 0 ; i < nVerts; i++) {
            for (int j = 0; j < nVerts; j++)
                System.out.print(adjMatrix[i][j] + " ");
            System.out.println("");
        }
    }

}
public class MSWTApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 (start for mst)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4


        theGraph.addEdge(0, 1, 2); // AB 2
        theGraph.addEdge(0, 3, 4); // AD 4
        theGraph.addEdge(0, 2, 10); // AC 4
        theGraph.addEdge(1, 3, 12); // BD 12
        theGraph.addEdge(1, 4, 4); // BE 4
        theGraph.addEdge(2, 3, 5); // CD 5
        theGraph.addEdge(2, 4, 7); // CE 7
        theGraph.addEdge(2, 1, 3); // CB 6


        //theGraph.displayMatrix();
        System.out.print("Minimum spanning tree: ");
        theGraph.mstw(); // minimum spanning tree
        System.out.println();
    }
}
