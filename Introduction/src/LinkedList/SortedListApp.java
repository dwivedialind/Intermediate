package LinkedList;

class SortedList{
    private Node first; //head node
    public SortedList(){
        first = null; //set first to null
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(int value){ //insert data at it's correct position
        Node newNode = new Node(value);
        if(isEmpty()){//list is empty
            first = newNode; //first -->newNode
            return;
        }
        Node current = first;
        if(first.data>=value){ //to be added at beginning
            newNode.next = first;
            first = newNode;
            return;
        }
        while(current.next!=null){
            if(current.next.data < value)
                current = current.next; //move to next node
            else
                break;
        }
        newNode.next = current.next;
        current.next = newNode;

    }
    public Node remove(){
        //assume list is non-empty and delete at first
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List--->");
        Node current = first;
        if(isEmpty()){
            System.out.println("List is empty");return;
        }
        while(current!=null){
            current.displayNode();
            current = current.next;
        }
        System.out.println("");

    }
}
public class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();
        theSortedList.insert(20); // insert 2 items
        theSortedList.insert(40);
        theSortedList.displayList(); // display list
        theSortedList.insert(10); // insert 3 more items
        theSortedList.insert(30);
        theSortedList.insert(50);
        theSortedList.displayList(); // display list
        theSortedList.remove(); // remove an item
        theSortedList.displayList(); // display list
    }
}
