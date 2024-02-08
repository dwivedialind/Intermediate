package Array;
class OrderArray{
    private int[] a;

    private int nElems;

    public OrderArray(int maxSize){
        a = new int[maxSize];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int find(int searchKey){
        int lower_bound = 0;
        int upper_bound = nElems;
        int mid;

        while(lower_bound<upper_bound){
            mid = lower_bound + (upper_bound - lower_bound)/2;
            if(a[mid] == searchKey)
                return mid;
            else{
                if(a[mid]<searchKey)
                    lower_bound = mid+1;
                else
                    upper_bound = mid-1;
            }

        }
        return -1;
    }

    public void insert( int value){
        int i;
        for( i = 0 ; i < nElems ; i++ )
            if(a[i]> value)
                break;
        //then we have to insert the value at i
        //now we have to shift elements to higher position
        for(int j = nElems; j > i ; j--)
            a[j] = a[j-1];

        a[i] = value; // now insert the value at position i

        nElems++; //increase size

    }

    public boolean delete(int value){
        int i = find(value);
        if(i == -1)
            return false; // can't find it
        else{
            for(int j = i; j<nElems; j++)
                a[j] = a[j+1]; //shifting back
        }
        nElems--; //decrease size
        return true;
    }

    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
}
public class OrderedArray {

    public static void main(String[] args) {
        int maxSize = 100;             // array size
        OrderArray arr;                  // reference to array
        arr = new OrderArray(maxSize);   // create the array

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

        arr.display();

        int searchKey = 55;            // search for item
        if( arr.find(searchKey) != -1 )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

    }
}
