package algorithm.queue;

public class LinkedQueue<T> {

    private Node first, last;

    private class Node{
        T item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(T item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public T dequeue(){
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        T item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        System.out.println(queue.dequeue() == 10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(!queue.isEmpty());
        System.out.println(queue.dequeue()==20);
        System.out.println(queue.dequeue()==30);
        System.out.println(queue.isEmpty());
    }
}
