package algorithm.stack;

public class ResizingArrayStack<T> {

    private T[] array;
    private int offset;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        array = (T[]) new Object[1];
        offset = 0;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
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
        return offset == 0;
    }

    public void push(T item) {
        if (offset == array.length)
            resize(2 * array.length);

        array[offset++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(array, 0, copy, 0, offset);
        array = copy;
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        T item = array[--offset];
        array[offset] = null;
        if (offset > 0 && offset == array.length / 4)
            resize(array.length / 2);
        return item;
    }
}
