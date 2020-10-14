package DS;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    public static  void InOrder(Node root) {
        if(root==null)
            return;
        InOrder(root.left);
        System.out.println((root.data)+" ");
        InOrder(root.right);
    }
    public static  void PreOrder(Node root) {
        if(root==null)
            return;
        System.out.println((root.data)+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static  void PostOrder(Node root) {
        if(root==null)
            return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println((root.data)+" ");
    }
    public static void LevelOrder(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            while(n != 0)
            {
                Node k = q.remove();
                System.out.print((k.data)+" ");
                if(k.left != null)
                    q.add(k.left);
                //System.out.print(root.left+" ");
                if(k.right != null)
                    q.add(k.right);
                n--;
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
}
