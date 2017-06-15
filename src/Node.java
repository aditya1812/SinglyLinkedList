/**
 * Created by 5CB4125SDX0 on 08-05-2017.
 */
public class Node {
    private Node link;
    private int val;


    public Node() {
        this.val = 0;
        this.link = null;
    }

    public Node(Node link, int val) {
        this.link = link;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
