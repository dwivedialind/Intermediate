package StackQueue;

public class FlushExample {
    public static void main(String[] args) {
        System.out.println("Hello, ");
        System.out.print("world!");
/*
In the context of output streams, buffering refers to the temporary data storage before it’s written out.
Once this buffer reaches its capacity or is explicitly flushed, the accumulated data is written out in a single go.
However, this buffering mechanism can sometimes lead to unexpected behavior.
 Data might not appear immediately where expected, leading to potential confusion.
 */
        // Flush the output buffer to ensure "world!" is immediately written to the console
        //When invoked, the flush() method ensures that any buffered data in the stream is immediately written out:
        System.out.flush();

        // Rest of the program
    }
}
