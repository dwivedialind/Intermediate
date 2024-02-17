package WeightedGraphs;
class Vertex{
    public char label; //label for a class
    public Vertex(char lab){
        label = lab;
    } //end constructor
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

    public void remove(int d){

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
        System.out.println(" ");
    }


}
class Graph{

}
public class MSWTApp {
    public static void main(String[] args) {
        PriorityQueue que = new PriorityQueue();
        Edge e1 = new Edge(0,1,5);
        Edge e2 = new Edge(1,3,7);
        Edge e3 = new Edge(2,1,3);
        Edge e4 = new Edge(0,2,4);
        que.insert(e1);
        que.insert(e2);
        que.insert(e3);
        que.insert(e4);
        que.displayQueue();
    }
}
