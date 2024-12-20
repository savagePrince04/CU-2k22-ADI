package Lec14;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//  input formate
// First input: The value of the root node.
//Subsequent inputs: For each node in level order, provide the values of its left and right children. Use -1 to indicate the absence of a child.

public class Create_Tree_Using_Level_Order {
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public Create_Tree_Using_Level_Order() {
        createTree();
    }

    private void createTree() {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt(); // root
        Node node = new Node(e);
        root = node;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node rv = q.poll();// remove first
            int c1 = sc.nextInt(); // left child
            int c2 = sc.nextInt(); // right child
            if (c1 != -1) {
                Node nn = new Node(c1);
                rv.left = nn;
                q.add(nn);

            }
            if (c2 != -1) {
                Node nn = new Node(c2);
                rv.right = nn;
                q.add(nn);
            }

        }
    }

    public void Display() {
        Display(root);
    }

    private void Display(Node nn) {
        if (nn == null) {
            return;
        }
        String s = "<--" + nn.val + "-->";
        if (nn.left != null) {
            s = nn.left.val + s;
        } else {
            s = null + s;
        }
        if (nn.right != null) {
            s = s + nn.right.val;
        } else {
            s = s + null;
        }
        System.out.println(s);
        Display(nn.left);
        Display(nn.right);

    }

    public static void main(String[] args) {
        Create_Tree_Using_Level_Order sc = new Create_Tree_Using_Level_Order();
        sc.Display();
    }
}