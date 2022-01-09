package algorithm.stack;

public class LinkedStackOfString {

    private Node first = null;

    public static void main(String[] args) {
        LinkedStackOfString stack = new LinkedStackOfString();
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

    public void push(String item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
    }

    public String pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        String item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
