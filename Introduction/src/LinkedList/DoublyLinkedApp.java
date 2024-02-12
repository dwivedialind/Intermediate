package LinkedList;

class DNode{
    public int data;
    public DNode previous; //reference to previous node
    public DNode next; //reference to next node
    public DNode(int d){
        data = d;
        //previous and next are automatically set to Null
    }
    public void displayNode(){ //display the node
        System.out.print(data+ " ");
    }
}

class DoublyLinkedList{
    private DNode first; //reference to head node
    private DNode last; //double end list reference to last node

    public DoublyLinkedList(){
        first = null;  //no items on list yet
        last = null;
    }

    public boolean isEmpty(){
        return (first == null); // list is empty
    }

    public void insertFirst(int value){
        DNode newNode = new DNode(value);
        if(isEmpty()){
            last = newNode;
        }else
            first.previous = newNode;
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int value){
        DNode newNode = new DNode(value);
        if(isEmpty())
            first = newNode;
        else
            last.next= newNode;
        newNode.previous = last;
        last = newNode;
    }

    public DNode deleteFirst(){
        DNode temp = first;

        if(first.next == null) //list have only one element
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;

    }
    public DNode deleteLast(){
        DNode temp = last;
        if(last.previous == null) //only 1 element in list
            first = null;
        else
            last.previous.next = null;
        last = last.previous;

        return temp;
    }

    public boolean insertAfter(int key, int dd){ //insert dd just after key
        DNode newNode = new DNode(dd);
        DNode current = first;
        while(current.data != key){
            current = current.next;
            if(current == null)
                return false; //can't find a key
        }

        if(current==last)//if key is last
            insertLast(dd);
        else{
            newNode.next = current.next;
            newNode.previous= current;
            current.next = newNode;
            newNode.next.previous = newNode;
        }
        return true;
    }

    public DNode delete(int key){
        //assuming list is non-empty
        DNode current = first;
        while(current.data!=key){
            current = current.next;
            if(current==null)
                return null; //can't find a key to delete
        }
        if(current== last)//last
            deleteLast();
        else if(current == first)
            deleteFirst();
        else{
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        return current;
    }
    public void displayForward(){
        //assuming list in non-empty
        DNode current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }

        System.out.println("");
    }
    public void displayBackward(){
        //assuming list is non-empty
        DNode current = last;
        while(current!=null){
            current.displayNode();
            current = current.previous;
        }
        System.out.println("");
    }

}

public class DoublyLinkedApp {
    public static void main(String[] args) {
        // make a new list
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward
        theList.deleteFirst(); // delete first item
        theList.deleteLast(); // delete last item
        theList.delete(44); // delete item with key 11
        theList.displayForward(); // display list forward
        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33
        theList.displayForward(); // display list forward
    }
}
