package Array;

class Vector {
    private long[] a;
    private int nElems;
    private int arr_length;

    public Vector(int size) {
        a = new long[size];
        arr_length = size;
        nElems = 0;
    }
    //Implementing searching using binary search.

    public int find(long searchKey) {
        int lower_bound = 0;
        int upper_bound = nElems-1;
        while (lower_bound <= upper_bound) {
            int mid = lower_bound + (upper_bound - lower_bound) / 2;
            if (a[mid] == searchKey)
                return mid;
            else {
                if (a[mid] > searchKey)
                    upper_bound = mid - 1;
                else
                    lower_bound = mid + 1;
            }

        }
        return -1;
    }

    public boolean delete(long ele){
        int j = find(ele);
        if(j == -1)
            return false;
        for(int k = j; k != nElems; k++)
                a[k] = a[k+1];
        nElems--;
        return true;
    }

    public void insert(long ele){
        if(arr_length==nElems){

            a = create_copy(a);

        }
        int i= 0;
        for(i = 0 ; i< nElems ; i++)
            if(a[i]>ele)
                break;
        for(int j = nElems; j>i; j--)
                a[j] = a[j-1];
        a[i] = ele;
        nElems++;

    }

    public long[] create_copy(long[] a){
        Vector copy;
        copy = new Vector(arr_length+1);
        arr_length = arr_length+1;
        for(int i = 0 ; i < nElems; i++){
            copy.insert(a[i]);
        }
        return copy.a;
    }
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------


}
public class VectorArray {
    public static void main(String[] args) {
        int maxSize = 10;             // array size
        Vector arr;                  // reference to array
        arr = new Vector(maxSize);   // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(122);


//        int searchKey = 55;            // search for item
//        if( arr.find(searchKey) != -1 )
//            System.out.println("Found " + searchKey);
//        else
//            System.out.println("Can't find " + searchKey);

        arr.display();                 // display items

//        arr.delete(00);                // delete 3 items
//        arr.delete(55);
//        arr.delete(99);
//
//        arr.display();
    }
}
