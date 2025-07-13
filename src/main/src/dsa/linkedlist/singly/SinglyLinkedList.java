package dsa.linkedlist.singly;

public class SinglyLinkedList {

    public static void main(String[] args) {
//        Node head = null;
//
//        int[] arr = {3, 4, 6, 2};

        //read the array and insert each element in the beginning
//        for(int i =0;i<arr.length;i++) {
//            if (head == null) {
//                head = new Node(arr[i]);
//            }else{
//                Node temp;
//                temp = new Node(arr[i]);
//                temp.next=head;
//                head = temp;
//            }
//        }
        //read the array and insert each element in the end
//        for (int i = 0; i < arr.length; i++) {
//            //if not exists linkedList
//            if (head == null) {
//                head = new Node(arr[i]);
//                //if linkedList exists
//            } else {
//                Node tail = head; // create another pointer and make it as Head
//                //iterate the linkedList to find the last element address that has Null
//                while (tail.next != null) {
//                    tail = tail.next;
//                }
//                //create new Node
//                Node temp;
//                temp = new Node(arr[i]);
//                //add the current node address to tail
//                tail.next = temp;
//            }
//        }


        /* Optimised the code in such a way each time while adding the element I need to find last element
        for that I need to traverse
        * to last element to add the next element.
        * So here I learnt that using a pointer to store the last element all time which helps
        * to quickly add the element instead of traversing from Head to tail. Declare initially the tail
        * along with the insertion
        *  */

        int[] arr = {3, 4, 6, 2};

        //Create a Node For Head
        Node head = null;
        //Another node as Tail
        Node tail = null;

        for (int j : arr) {
            //case 1 : if linkedList is null
            if (head == null) {
                head = new Node(j);
                tail = head; // make tail to point to head initially now we know that tail is the last element
            }
            //case 2 : if linkedList is not null
            else {
                tail.next = new Node(j); // It creates a link between two nodes
                tail = tail.next; // moving the tail to point to next element as that will be the last element
            }
        }


        // print the linkedList
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }
}

