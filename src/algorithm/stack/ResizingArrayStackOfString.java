package algorithm.stack;

public class ResizingArrayStackOfString {

    private int offset;
    private String[] s;

    public ResizingArrayStackOfString() {
        s = new String[1];
        offset = 0;
    }

    public static void main(String[] args) {
        ResizingArrayStackOfString stack = new ResizingArrayStackOfString();
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

    public void push(String item) {
        if (offset == s.length)
            resize(2 * s.length);
        s[offset++] = item;
    }

    public String pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        String item = s[--offset];
        s[offset] = null;
        if (offset > 0 && offset == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        System.arraycopy(s, 0, copy, 0, offset);
        s = copy;
    }

    private boolean isEmpty() {
        return offset == 0;
    }
}
