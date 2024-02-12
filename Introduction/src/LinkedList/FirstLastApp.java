package LinkedList;

class FirstLastList{
    private Node last; //reference to last Node in a list // set to null automatically
    private Node first;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(int d){

        Node newNode = new Node(d);
        if(isEmpty())
            last = newNode; //if list is empty then last --> newNode
            newNode.next = first;
            first = newNode;
        // first-->newNode
    }


    public Node deleteFirst(){

        if(isEmpty())
            return null;
        if(last == first)//there is only one node
            last = null;
        Node temp = first; //hold first in temp variable
        ;
        first = first.next;
        return temp;
    }

    public void insertLast(int d){

        Node newNode = new Node(d);
        if(isEmpty())//list is empty
            first=newNode;
        else
            last.next = newNode;
        last= newNode;

    }
    public Node deleteLast(){

        if(isEmpty())
            return null;
        if(first == last){
            first = null;
            last = null;
        }

        Node current = first;
        while(current.next != last){
            current = current.next;
        }
        Node temp = last;
        last = current;
        last.next = null;
        return temp;
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


}
public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();
        theList.displayList(); // display again
        theList.deleteLast();
        theList.insertLast(77);
        theList.displayList();
    }
}
