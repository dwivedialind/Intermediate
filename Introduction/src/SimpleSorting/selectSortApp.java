package SimpleSorting;

class ArraySel{

    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArraySel(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    public void selectSort1(){ // this selectsort will have more swaps
        int swaps = 0;
        int comparisions = 0;
        for(int i = 0 ; i < nElems -1; i++){
            for(int j = i+1; j < nElems; j++) {
                comparisions++;
                if (a[i] > a[j]) {
                    swaps++;
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("swap: "+ swaps + " comparisions: "+ comparisions);

    }

    public void selectSort2(){ //this selectsort will have less swaps
        int swaps = 0;
        int comparisions = 0;

        for(int out = 0; out < nElems -1 ; out++){
            int min = out;
            for(int inner = out+1; inner < nElems;  inner++) {
                comparisions++;
                if(a[min]>a[inner])
                    min = inner;

            }
            swaps++;
            long temp = a[min];
            a[min] = a[out];
            a[out]= temp;
        }

        System.out.println("swap: "+ swaps + " comparisions: "+ comparisions);
    }
}

public class selectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

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

        arr.selectSort2();          // selection-sort them

        arr.display();
    }
}
