package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number: ");
        System.out.flush();
        int n = getInt();
        System.out.println(triangle(n));
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

    public static int triangle(int n){
        if(n==1)
            return 1;
        return n + triangle(n-1);
    }
}
