package LinkedList;

class LinkList2 extends LinkList{
    public Node find(int key){ //find node using a given key
        Node current = getFirst(); // current traverse from first-->key node
        while(current.data!=key){
            if(current.next==null)
                return null; // if we can't find a key till last
            else
                current = current.next; // move to next node

        }

        return current;
    }

    public Node delete(int key){//delete link with given key
        //we are assuming given key is in LL and non-empty list;
        Node current = getFirst();
        if(current.data == key)
            deleteFirst(); //if key is present at head node
        while(current.next.data!=key)
            current = current.next;

        Node temp = current.next; //hold node to be deleted in temp variable
        current.next = current.next.next; // set prev. of deleted node points to next of deleted node.
            //We do not need to explicitly delete node it will be taken care by garbage collector
        return temp;
    }
}
public class LinkListApp2 {
    public static void main(String[] args) {
        LinkList2 theList = new LinkList2(); // make list
        theList.insertFirst(22); // insert 4 items
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        theList.displayList(); // display list

        Node f = theList.find(44); // find item
        if( f != null)
            System.out.println("Found link with key " + f.data);
        else
            System.out.println("Can't find a Link");

        Node d = theList.delete(66); // delete item
        System.out.println("Deleted link with key " + d.data);

        theList.displayList(); // display list
    }
}
