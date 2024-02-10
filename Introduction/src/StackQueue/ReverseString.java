package StackQueue;


import java.io.IOException;
import java.util.Objects;

class Stack{
    private int maxSize; // size of stack
    private char[] stack; //stack
    private int top; //top

    public Stack(int s){
        maxSize = s;
        stack = new char[s];
        top = -1; //initialize top
    }

    public void push(char c){
        if(!isFull()){
            top++;
            stack[top] = c;
            return;
        }
        System.out.println("Stack is Full!");

    }

    public char pop(){
        return stack[top--];
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

class Reverser{
    private String input, output;

    public Reverser(String in){
        input = in;
    }
    public String doRev(){
        Stack str = new Stack(input.length());
        for(int i = 0; i < input.length(); i++)
            str.push(input.charAt(i)); //push into stack
        output = "";
        for(int i = 0 ; i < input.length(); i++){
            output += str.pop();
        }
        return output;
    }


}
public class ReverseString{
    public static void main(String[] args) throws IOException {

        String input, output;

        while(true){
            System.out.println("Enter a String: ");
            System.out.flush();
            ReadString rs = new ReadString();
            input = rs.getString();
            if(Objects.equals(input, ""))
                break;
            Reverser rev = new Reverser(input);
            output = rev.doRev();
            System.out.println("Reversed: "+ output);

        }


    }
}