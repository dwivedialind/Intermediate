package StackQueue;

import java.io.IOException;

class BracketChecker{
    private String input;
    public BracketChecker(String in){
        input = in;
    }
    public void check(){
        Stack delimiter = new Stack(input.length());
        for(int i = 0 ;i < input.length() ; i++){
            char letter = input.charAt(i);
            switch(letter){
                case '[':
                    case '{':
                        case '(':
                    delimiter.push(letter); //push them
                    break;

                case '}':
                    case ']':
                        case ')':
                            if( !delimiter.isEmpty() ) // if stack not empty,
                            {
                                char chx = delimiter.pop(); // pop and check
                                if( (letter=='}' && chx!='{') ||
                            (letter==']' && chx!='[') ||
                            (letter==')' && chx!='(') )
                            System.out.println("Error: "+letter+" at "+i);
                        }
                            else // prematurely empty
                                System.out.println("Error: "+letter+" at "+i);

                default:
                    break;
            }
        }
        if( !delimiter.isEmpty() )
            System.out.println("Error: missing right delimiter");
    }
    }
public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while(true){
            System.out.println("Enter the String ");
            System.out.flush();
            ReadString rs = new ReadString();
            input = rs.getString();
            if(input.equals(""))
                break;
            BracketChecker br = new BracketChecker(input);
            br.check();
        }
    }
}
