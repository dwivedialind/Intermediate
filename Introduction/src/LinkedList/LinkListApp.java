package LinkedList;
class Node{
    public int data; // int data

    public Node next; // reference to next node
    public Node(int d){
        data = d;
      // next is automatically set to null
    }
    public void displayNode(){ // display a node.
        System.out.print(data+" ");
    }
}

class LinkList{
    private Node first; // reference to first node
    public LinkList(){
        first = null; //this is to make it clear however automatically it set to null only.
    }

    public boolean isEmpty(){
        return (first == null);
    }
    public void insertFirst(int d){ // insert at start of list
        Node newNode = new Node(d); //create a new nod
        newNode.next = first; //next of new node points to old fist (newNode --> oldfirst)
        first = newNode;// first now point to new Node
    }

    public Node deleteFirst(){//deletes first node
        if(isEmpty())
            return null;
        Node temp = first; // hold first node in temp variable
        first = first.next; //first-->oldfirst.next
        return temp; // return deleted Node
    }

    public void displayList(){
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        while(current!=null){
            current.displayNode(); // display current node
            current = current .next; // moves to next node
        }
        System.out.println("");
    }

    public Node getFirst() {
        return first;
    }
}
public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList(); // make new list
        theList.insertFirst(22); // insert four items
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        theList.displayList(); // display list
        while( !theList.isEmpty() ) // until it’s empty,
        {
            Node aLink = theList.deleteFirst(); // delete link
            System.out.print("Deleted"); // display it
            aLink.displayNode();
            System.out.println("");
        }
        theList.displayList(); // display list
    }
}
