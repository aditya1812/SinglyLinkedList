import java.util.Scanner;

/**
 * Created by 5CB4125SDX0 on 08-05-2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        String q;
        LinkedList ll = new LinkedList();
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        int l;
        while (!quit) {
            System.out.println("Enter choice");
            System.out.println("1: Add at start");
            System.out.println("2: Add at end");
            System.out.println("3: Add at position");
            System.out.println("4: Delete at position");
            System.out.println("5: Get size");
            System.out.println("6: Reverse link list");
            System.out.println("7: Delete nth node from end");
            System.out.println("8: Rotate by index");
            System.out.println("9: Swap pairwise");
            System.out.println("10: Reorder");
            System.out.println("11: Remove duplicates from sorted array ");
            //System.out.println("12: Add numbers as Linked Lists");
            System.out.println("12: Check if linkedList is palindrome or not");
            int c = s.nextInt();
            int val, index;

            System.out.println("You entered " + c);
            switch (c) {
                case 1:
                    System.out.println("Enter int value to add at start ");
                    val = s.nextInt();
                    ll.insertAtStart(val);
                    System.out.println("Size = " + ll.getSize());
                    //ll.display();
                    break;

                case 2:
                    System.out.println("Enter int value to add at end ");
                    val = s.nextInt();
                    ll.insertAtEnd(val);
                    System.out.println("Size = " + ll.getSize());
                    //ll.display();
                    break;

                case 3:
                    System.out.println("Enter the position and value ");
                    index = s.nextInt();
                    val = s.nextInt();
                    ll.insertAtPosition(index,val);
                    System.out.println("Size = " + ll.getSize());
                    //ll.display();
                    break;

                case 4:
                    System.out.println("Enter the position for deletion");
                    index = s.nextInt();
                    ll.deleteAtPosition(index);
                    System.out.println("Size = " + ll.getSize());
                    //ll.display();
                    break;

                case 5:
                    System.out.println("Size = " + ll.getSize());
                    break;


                case 6:
                    System.out.print("Reverse ");
                    ll.reverseLinkedList();
                    System.out.println("Size = " + ll.getSize());
                    //ll.display();
                    break;

                case 7:
                    System.out.println("Enter the index from end");
                    index = s.nextInt();
                    ll.deleteFromEnd(index);
                    break;

                case 8:
                    System.out.println("Enter index for rotation");
                    index = s.nextInt();
                    ll.rotate(index);
                    break;

                case 9:
                    ll.swapInPairs();
                    break;

                case 10:
                    ll.reorder();
                    break;

                case 11:
                    ll.removeDulicateFromSorted();
                    break;

                case 12:
                    if(ll.isPalindrome2())
                        System.out.println("Linked List is Palindrome");
                    else
                        System.out.println("Linked List is Not Palindrome");
                    break;


            }
            System.out.println("Do you want quit (y/n)");
            s.nextLine();
            q = s.nextLine();
            if(q.toLowerCase().equals("y"))
                quit = true;
        }
    }
}
