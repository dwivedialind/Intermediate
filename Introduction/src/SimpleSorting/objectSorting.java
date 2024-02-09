package SimpleSorting;
class Person
{
    private String lastName;
    private String firstName;
    private int age;
    //-----------------------------------------------------------
    public Person(String last, String first, int a)
    {                               // constructor
        lastName = last;
        firstName = first;
        age = a;
    }
    //-----------------------------------------------------------
    public void displayPerson()
    {
        System.out.print("   Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }
    //-----------------------------------------------------------
    public String getLast()           // get last name
    { return lastName; }
}

class ArrayInObj{
    private Person[] a;
    private int nElems;
    public ArrayInObj(int max){
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age){
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display(){
        for(int j = 0; j<nElems; j++)
            a[j].displayPerson();
    }

    public void insertionSort(){
        int in, out;

        for(out=1; out<nElems; out++)
        {
            Person temp = a[out];       // out is dividing line
            in = out;                   // start shifting at out

            while(in>0 &&               // until smaller one found,
                    a[in-1].getLast().compareTo(temp.getLast())>0)
            {
                a[in] = a[in-1];         // shift item to the right
                --in;                    // go left one position
            }
            a[in] = temp;               // insert marked item
        }  // end for
    }  // end in
}
public class objectSorting {
    public static void main(String[] args) {
        int maxSize = 100;             // array size
        ArrayInObj arr;                 // reference to array
        arr = new ArrayInObj(maxSize);  // create the array

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting:");
        arr.display();                 // display items

        arr.insertionSort();           // insertion-sort them

        System.out.println("After sorting:");
        arr.display();
    }
}
