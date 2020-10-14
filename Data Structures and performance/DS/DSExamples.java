package DS;

import java.util.*;

public class DSExamples {
    public static void testQueue(Queue<Integer> queue) {
        System.out.println(queue.getClass().getName());

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(4);
        queue.add(2);
        queue.add(50);
        queue.add(-1);

        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(" "+iterator.next());
        }

        while (queue.size() != 0) {
            System.out.println("Polled element: "+queue.poll());
        }
    }
    public static void main(String[] args) {
        testQueue(new PriorityQueue<Integer>());
        testQueue(new LinkedList<Integer>());
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(10);
        deque.add(20);
        deque.addFirst(-1);
        deque.addLast(-10);
        Iterator iterator = deque.iterator();

        while (iterator.hasNext()) {
            System.out.println(" "+iterator.next());
        }

        System.out.println("Poll First: "+deque.pollFirst());
        System.out.println("Poll Last: "+deque.pollLast());
        //Node binaryTree = null;
        //binaryTree = insert();

    }
}
