package Graphs;
class Queue{
    private final int size = 20; // max size of queue
    private int[] queue;
    private int nElems; // to get no. of elements in queue

    private int front, rear;
    public Queue(){
        queue = new int[size];
        front = 0;
        rear = -1;
        nElems =0;
    }
    public boolean isEmpty(){
        return nElems==0;
    }
    public boolean isFull(){
        return nElems==size;
    }
    public void insert(int value){
        queue[++rear] = value;
        nElems++;
    }
    public int remove(){
        nElems--;
        return queue[front++];
    }
}
public class BFSApp {
    public static void main(String[] args) {

    }
}
