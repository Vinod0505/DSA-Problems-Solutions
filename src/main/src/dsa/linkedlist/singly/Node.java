package dsa.linkedlist.singly;

//creation of Node
public class Node {
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
