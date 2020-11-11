//Class: OrderedArrayList extends
//Super class: ArrayListClass
public class OrderedArrayList extends ArrayListClass{
   
    public OrderedArrayList() {
        super();
    }

    public OrderedArrayList(int size) {
        super(size);
    }

    //implementation for abstract methods defined in ArrayListClass

    //merge method from assignment
    public OrderedArrayList merge(OrderedArrayList o) {
        OrderedArrayList result = new OrderedArrayList();
        result.length = length + o.length;
        
        //traverses both arrays concurrently, comparing the values at independently progressive indices.
        int list1_index = 0;
        int list2_index = 0;
        
        for (int i = 0; i <= result.length; i++) {
            if ((list[list1_index] < o.list[list2_index]) || (list1_index != list.length && list2_index == o.length)) {
                result.list[i] = list[list1_index];
                list1_index++;
            }
            else if ((list[list1_index] > o.list[list2_index]) || (list2_index != list.length && list1_index == o.length)) {
                result.list[i] = o.list[list2_index];
                list2_index++;
            }
        }        
        return result;
    }
    
    //split method from assignment
    public void split(int key) {
        OrderedArrayList list1 = new OrderedArrayList();
        OrderedArrayList list2 = new OrderedArrayList();
        int list1_index = 0;
        int list2_index = 0;
        
        for (int i = 0; i < length; i++) {
            if (list[list1_index] <= key) {
                list1.list[i]=list[i];
                list1.length++;
                list1_index++;
            }
            else {
                list2.list[list2_index]=list[i];
                list2.length++;
                list2_index++;
            }
        }
        
        System.out.println("List 1 after split: ");
        list1.print();
        System.out.println("List 2 after split: ");
        list2.print();
    }
    
    //ordered list --> binary search
    public int search(int item) {
        int first = 0;
        int last = length - 1;
        int middle = -1;

        while (first <= last)  {
            middle = (first + last) / 2;
            if (list[middle] == item)
                return middle;
            else
                if (list[middle] > item)
                    last = middle - 1;
                else
                    first = middle + 1;
        }
        return -1;
    }

    public void insert(int item) {
        int loc;
        boolean found = false;
        if (length == 0)            //list is empty
            list[length++] = item;  //insert item and increment length
        else if (length == maxSize) //list is full
            System.err.println("Cannot insert in a full list.");
        else {
            for (loc = 0; loc < length; loc++) {
                if (list[loc] >= item) {
                    found = true;
                    break;
                }
            }
            //starting at the end, shift right
            for (int i = length; i > loc; i--)
                list[i] = list[i - 1];
            list[loc] = item; //insert in place
            length++;
        }
    }

    public void insertAt(int location, int item)  {
        if (location < 0 || location >= maxSize)
            System.err.println("The position of the item to be inserted is out of range.");
        else if (length == maxSize)  //the list is full
            System.err.println("Cannot insert in a full list.");
        else {
            System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert).");
            insert(item);
        }
    }

    public void insertEnd(int item) {
        if (length == maxSize)  //the list is full
            System.err.println("Cannot insert in a full list.");
        else {
            System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert).");
            insert(item);
        }
    }

    public void replaceAt(int location, int item) {
        //the list is sorted!
        //is actually removing the element at location and inserting item in place
        if (location < 0 || location >= length)
             System.err.println("The position of the item to be replaced is out of range.");
        else {
            removeAt(location);//method in ArrayListClass
            insert(item);
        }
    }

     public void remove(int item) {
        int loc;
        if (length == 0)
            System.err.println("Cannot delete from an empty list.");
        else  {
            loc = search(item);
            if (loc != -1)
                removeAt(loc);//method in ArrayListClass
            else
                System.out.println("The item to be deleted is not in the list.");
        }
    }
}

