package dsa.linkedlist.singly;

//creation of Node
class Node {
    //stores data
    int data;
    //Pointer to next node
    Node next;

    //Constructor to dynamically initialize
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {

    public static void main(String[] args) {
        Node head = null;

        int[] arr = {3, 4, 6, 2};

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
        for (int i = 0; i < arr.length; i++) {
            //if not exists linkedList
            if (head == null) {
                head = new Node(arr[i]);
                //if linkedList exists
            } else {
                Node tail = head; // create another pointer and make it as Head
                //iterate the linkedList to find the last element address that has Null
                while (tail.next != null) {
                    tail = tail.next;
                }
                //create new Node
                Node temp;
                temp = new Node(arr[i]);
                //add the current node address to tail
                tail.next = temp;
            }
        }

        // print the linkedlist
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }


    }
}

