package algorithm.queue;

public class ArrayQueue<T> {
    private T[] array;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayQueue(final int n){
        array = (T[]) new Object[n];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public void enqueue(T item){
        array[tail++] = item;
        if (tail == array.length){

            tail = 0;
        }
    }

}
