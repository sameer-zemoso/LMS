package DS;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    public static void insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.peek();
            q.remove();
            if (root.left == null) {
                root.left = new Node(data);
                break;
            }
            else {
                q.add(root.left);
            }
            if (root.right == null) {
                root.right = new Node(data);
                break;
            }
            else {
                q.add(root.right);
            }
        }
    }
    public static Node insertintoBST(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insertintoBST(root.left, data);
                root.left = cur;
            } else {
                cur = insertintoBST(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Traversals traverse = new Traversals();
        //4 5 15 0 1 7 17
        Node binaryTree = new Node(20);
        insert(binaryTree,25);
        insert(binaryTree,15);
        insert(binaryTree,30);
        traverse.LevelOrder(binaryTree);

        Node bst = new Node(4);
        insertintoBST(bst,5);
        insertintoBST(bst,15);
        insertintoBST(bst,0);
        insertintoBST(bst,1);
        insertintoBST(bst,7);
        insertintoBST(bst,17);
        traverse.LevelOrder(bst);
    }
}
