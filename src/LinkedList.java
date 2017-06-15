/**
 * Created by 5CB4125SDX0 on 08-05-2017.
 */
public class LinkedList {

    private Node start;
    private Node end;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public void insertAtStart(int val){
        Node n = new Node(null, val);
        size++;
        if(isEmpty()){
            start = n;
            end = n;
        }
        else {
            n.setLink(start);
            start = n;
        }
        display(start);
    }

    public void insertAtEnd(int val){
        Node n = new Node(null, val);
        size++;
        if(isEmpty()){
            start = n;
            end = n;
        }
        else {
            //n.setLink(null);
            end.setLink(n);
            end = n;
        }
        display(start);

    }

    public void insertAtPosition(int index, int val){
        if(index>size){
            System.out.println("Out of index");
            return;
        }
        if(index == 1)
            insertAtStart(val);
        Node n = new Node(null, val);
        Node s = start;
        index--;
        index--;
        for(int i = 0; i < size; i++){

            if(i==index){

                n.setLink(s.getLink());
                s.setLink(n);
                size++;
                break;

            }
            s = s.getLink();
        }
        display(start);


    }

    public void deleteAtPosition(int index){
        if(index>size){
            System.out.println("Out of index");

        }

        Node s = start;
        Node t = new Node();
        index--;

        if(index == 0){
            start = s.getLink();
            size--;
        }
        else if(index == size-1){
            for(int i = 0; i < size-2; i++){
                s = s.getLink();
            }
            s.setLink(null);
            end = s;
            size--;
        }
        else{
            for(int i = 1; i < size - 2; i++){
                if(i == index){
                    t = s.getLink();
                    s.setLink(t.getLink());
                    size--;
                    break;
                }
                s = s.getLink();
            }
        }
        display(start);
    }

    public void deleteFromEnd(int index){
        if(index >= size){
            System.out.println("Out of Index");
        }

        Node s = start;
        Node s1 = start;
        Node t = null;
        if(index == size-1){
            start = s.getLink();
            s.setLink(null);
            size--;
        }
        else if(index == 0){
            while(s != null){
                if(s.getLink().getLink() == null){
                    s.setLink(null);
                    end = s;
                    size--;
                }
                s = s.getLink();
            }
        }
        else{
            for(int i =0; i<=index-1; i++){
                s1 = s1.getLink();
            }
            while(s1.getLink() != null){
                t = s;
                s = s.getLink();
                s1 = s1.getLink();
            }
            t.setLink(s.getLink());
            size--;

        }
        display(start);
        System.out.println("Size "+size);
    }

    public void rotate(int index){
        if(index > size) {
            System.out.println("Out of index");
            return;
        }
        else if(index == 0){
            display(start);
            return;
        }
        else{
            Node s = start;
            Node s1 = start;
            Node s2 = start;
            Node s3 = start;


            for(int i = 0; i<=index-1; i++){
                s1 = s1.getLink();
            }
            System.out.println(s1.getVal());
            while(s1.getLink()!=null){
                s1 = s1.getLink();
                s2 = s2.getLink();
            }
            System.out.println(s2.getVal());

            while(s3.getLink() != null)
                s3 = s3.getLink();
            s3.setLink(s);
            System.out.println(s3.getVal());

            start = s2.getLink();
            s2.setLink(null);
            display(start);


        }
    }

    public void swapInPairs(){
        Node s= start;
        Node s1 = start.getLink();
        start = start.getLink();
        Node temp;

        while(true){
            temp = s1.getLink();
            if(temp != null && temp.getLink()!=null)
                s.setLink(temp.getLink());
            else
                s.setLink(temp);
            s1.setLink(s);
            s = temp;
            if(s == null||s.getLink()==null)
                break;
            s1 = s.getLink();
        }
        display(start);
    }

    public void reorder(){
        Node s = start;
        Node e;
        Node temp;

        while(true){
            e = start;
            while(e.getLink().getLink() != null)
                e = e.getLink();

            temp = s.getLink();
            s.setLink(e.getLink());
            e.setLink(null);
            s.getLink().setLink(temp);
            s = temp;
            if(s.getLink() == null || s.getLink().getLink() == null)
                break;
        }
        display(start);

    }

    public void removeDulicateFromSorted(){
        Node s = start;
        Node temp;
        while(true){
            temp = s;
            s = s.getLink();
            if(s == null)
                break;
            else
                while(temp.getVal() == s.getVal()){
                    temp.setLink(s.getLink());
                    if(s.getLink() == null)
                        break;
                    else
                        s = s.getLink();

                }
        }
        display(start);
    }

    public void display(Node node){
        if(size == 0){
            System.out.println("Empty list");
        }
        else{
            Node s = node;
            do{
                if(s.getLink()!=null)
                    System.out.print(s.getVal()+" -> ");
                else
                    System.out.print(s.getVal());
                s = s.getLink();
            }while(s!=null);
        }
        System.out.println();
    }

    public void reverseLinkedList(){
        if(size == 0){
            System.out.println("NULL");
            return;
        }
        Node t = new Node();
        Node t2 = null;
        Node s = start;
        t = s;
        while(s!= null){
            t = s.getLink();
            s.setLink(t2);
            t2 = s;
            s = t;
        }
        display(t2);

    }

    public boolean isPalindrome1(){
        LinkedList l = new LinkedList();
        Node start1 = null;
        Node n2 = null;
        Node n1;
        boolean p = true;
        start1 = start;


        n1 = start1;

        while(n1 != null){
            l.insertAtStart(n1.getVal());
            n1 = n1.getLink();
        }

        n1 = start1;
        n2 = l.start;
        while(n1 != null){
            //System.out.println(n1.getVal()+"    "+n2.getVal());
            if(n1.getVal() != n2.getVal()){
                p = false;
                break;
            }
            n1 = n1.getLink();
            n2 = n2.getLink();
        }

        return p;

    }

    public boolean isPalindrome2(){
        Node n1;
        Node n2;
        Node s = start ,s1 = start;
        if(s == null){
            System.out.println("Empty");
            return false;
        }
        int i = 0, j = 0;
        boolean p = true;
        while(s != null){
            i++;
            s = s.getLink();
        }
        //System.out.println(i);
        s = start;
        while(j != i/2 ){
            s = s.getLink();
            j++;
        }
        //System.out.println(s.getVal());

        n1 = s.getLink();
        while(n1 != null){
            n2 = n1.getLink();
            n1.setLink(s);
            s = n1;
            n1 = n2;
        }
/*        System.out.println(s.getVal());
        System.out.println(s.getLink().getVal());
        System.out.println(s.getLink().getLink().getVal());*/
        j = 0;
        while(j != i/2){
            if(s.getVal() != s1.getVal()){
                p = false;
                break;
            }
            j++;
            s = s.getLink();
            s1 = s1.getLink();
        }

        return p;
    }


}
