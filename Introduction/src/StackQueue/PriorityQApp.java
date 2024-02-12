package StackQueue;

class PriorityQ{
    // array in sorted order, from max at 0 to min at size-1
    int maxSize;
    private long[] queArray;
    private int front, rear;
    public PriorityQ(int s){
        maxSize = s;
        queArray = new long[s];
        rear = 0;
        front = -1;
    }
    public void insert(long item){
        if(isFull()){
            System.out.println("Can't insert queue is full");
            return ;
        }
        int i;
        for(i = front; i>=rear; i--){
            if(queArray[i]>=item)
                break;
        }
        //shift smaller elements above
        for(int j = front; j > i; j--){
            queArray[j+1] = queArray[j];
        }
        queArray[i+1]=item;
        front++;
    }

    public long remove(){
        if(isEmpty())
            return -1;
        return queArray[front--];
    }

    public long peekMin(){
        if(isEmpty())
            return -1;
        return queArray[front];
    }
    public boolean isEmpty(){
        return (front == -1);
    }
    public boolean isFull(){
        return (front == maxSize-1);
    }

}

public class PriorityQApp {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " "); // 10, 20, 30, 40, 50
        } // end while
        System.out.println("");
    }
}
