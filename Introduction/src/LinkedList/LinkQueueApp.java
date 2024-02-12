package LinkedList;

class LinkQueue{
    private FirstLastList queue;
    public LinkQueue(){
        queue = new FirstLastList();
    }

    public void insert(int value){
        queue.insertLast(value);
    }
    public Node remove(){
        Node temp =
        queue.deleteFirst();
        if(temp == null)
            System.out.println("queue is empty");
        return temp;
    }

    public void displayQueue(){
        System.out.println("Queue -->");
        queue.displayList();
    }
}

public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20); // insert items
        theQueue.insert(40);
        theQueue.displayQueue(); // display queue
        theQueue.insert(60); // insert items
        theQueue.insert(80);
        theQueue.displayQueue(); // display queue
        theQueue.remove(); // remove items
        theQueue.remove();
        theQueue.displayQueue(); // display queue

    }
}
