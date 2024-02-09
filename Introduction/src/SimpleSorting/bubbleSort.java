package SimpleSorting;

class ArrayBub{
    private long[] a;
    private int nElems;

    public ArrayBub(int size){
        a = new long[size];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for(int i = 0 ; i < nElems ; i++)
            System.out.print(a[i]+ " ");
        System.out.println("");
    }

    public void bubbleSort(){

        for(int out = 0 ; out < nElems-1; out ++ ){
            int in = out;
            for(in = out; in< nElems-1-out; in++){
                if(a[in]>a[in+1])
                    swap(in);
            }
            for(int j = in-1 ; j > out; j--){
                if(a[j]<a[j-1]){
                    swap(j-1);
                }
            }

        }
    }

    private void swap(int j){
        long temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
    }
}

public class bubbleSort {

    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        arr.bubbleSort();             // bubble sort them

        arr.display();                // display them again
    }  // end main(
}
