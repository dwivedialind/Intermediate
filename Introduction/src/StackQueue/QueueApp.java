package StackQueue;
class Queue{
    private long[] que;
    private int maxSize;
    private int front;
    private int rear;
    private int nElems;
    public Queue(int s){
        que = new long[s];
        maxSize = s;
        rear = -1;
        front = 0;
        nElems = 0;
    }

    public void insert(long j){
        if(isFull())
            return;
        if(rear == maxSize-1) //wrap around rear
            rear = -1;
        que[++rear] = j;
        nElems++;
    }
    public long remove(){
        if(isEmpty())
            return -1l;
        long temp = que[front++];
        if(front == maxSize) //wrap around front
            front=0;
        nElems--;
        return temp;
    }

    public long peekfront(){
        return que[front];
    }
    public boolean isFull(){
        if(nElems==maxSize)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(nElems == 0)
            return true;
        return false;
    }

}
public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5); // queue holds 5 items
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove(); // remove 3 items
        theQueue.remove(); // (10, 20, 30)
        theQueue.remove();
        theQueue.insert(50); // insert 4 more items
        theQueue.insert(60); // (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);
        while( !theQueue.isEmpty() ) // remove and display
        { // all items
            long n = theQueue.remove(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
