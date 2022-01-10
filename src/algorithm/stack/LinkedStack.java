package algorithm.stack;

public class LinkedStack<T> {
    private Node first;

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        try {
            System.out.println("Stack is empty: " + stack.isEmpty());
            stack.pop();
        } catch (IndexOutOfBoundsException ignore) {
            System.out.println("Stack is empty cause throwing an exception");
        }
        stack.push("Hello");
        System.out.println(stack.pop());

        try {
            System.out.println("Stack is empty: " + stack.isEmpty());
            stack.pop();
        } catch (IndexOutOfBoundsException ignore) {
            System.out.println("Stack is empty cause throwing an exception");
        }

        stack.push("Hello");
        stack.push("Hello");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for (int i = 0; i < 100; i++) {
            stack.push("#" + i + "Hello");
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(stack.pop());
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        T item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        T item;
        Node next;
    }
}
