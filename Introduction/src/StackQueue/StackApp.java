package StackQueue;

class StackX{
    private int maxSize; // size of stack
    private long[] stack; //stack
    private int top; //top

    public StackX(int s){
        maxSize = s;
        stack = new long[s];
        top = -1; //initialize top
    }

    public void push(long value){
        if(!isFull()){
            top++;
            stack[top] = value;
            return;
        }
        System.out.println("Stack is Full!");

    }

    public void pop(){
        if(!isEmpty()){
            top--; // decrement top
            return;
        }
        System.out.println("Stack is empty!");
    }

    public long peek(){
        if(!isEmpty())
            return stack[top];
        else
            return -1;
    }

    public boolean isEmpty(){
        if(top == -1)
            return true;

        return false;

    }




    public boolean isFull(){
        if(top == maxSize-1)
            return true;
        return false;
    }
}
public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        theStack.pop();theStack.pop();theStack.pop();theStack.pop();//theStack.pop();
    }
}
