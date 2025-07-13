package dsa.linkedlist.singly;

public class LinkedListUsingRecursion {

    public static Node createLinkedListAtEnd(int[] arr, int index, int size){
        if(index==size){
            return null;
        }
        Node temp;
        temp = new Node(arr[index]);
        temp.next = createLinkedListAtEnd(arr,index+1,size);
        return temp;
    }

    public static Node createLinkedListAtBeginning(int[] arr, int index, int size,Node prev){
        if(index==size){
            return prev;
        }
        Node temp;
        temp= new Node(arr[index]);
        temp.next=prev;
        return createLinkedListAtBeginning(arr,index+1,size,temp);
    }

    public static void main(String[] args) {

        Node head =null;

//        head = createLinkedListAtEnd(new int[]{3, 2, 1, 5}, 0, 4);

        head = createLinkedListAtBeginning(new int[]{3, 2, 1, 5}, 0, 4,head);

        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }

    }
}
