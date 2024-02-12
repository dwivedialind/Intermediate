package LinkedList;

class LinkStack{

    private LinkList stack;
    public LinkStack(){
       stack = new LinkList();
    }
    public void push(int value){
        stack.insertFirst(value);
    }
    public Node pop(){
        Node del = stack.deleteFirst();
        if(del == null)
            System.out.println("Stack is empty");
        return del;

    }

    public Node peek(){
        return stack.getFirst();
    }
    public void displayStack(){
        stack.displayList();
    }
}
public class linkStackApp {
    public static void main(String[] args) {

        LinkStack theStack = new LinkStack(); // make stack

        theStack.push(20); // push items
        theStack.push(40);
        theStack.displayStack(); // display stack
        theStack.push(60); // push items
        theStack.push(80);
        theStack.displayStack(); // display stack
        theStack.pop(); // pop items
        theStack.pop();
        theStack.displayStack(); // display stack


    }
}
