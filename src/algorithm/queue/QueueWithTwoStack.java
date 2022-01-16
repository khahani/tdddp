package algorithm.queue;

import algorithm.stack.ResizingArrayStack;

public class QueueWithTwoStack<T> {
    private ResizingArrayStack<T> input;
    private ResizingArrayStack<T> output;

    public QueueWithTwoStack(){
        input = new ResizingArrayStack<>();
        output = new ResizingArrayStack<>();
    }

    public void enqueue(T item){
        input.push(item);
    }

    public T dequeue(){
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        return output.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStack<Integer> q = new QueueWithTwoStack<>();

        for (int i = 0; i < 20; i++) {
            q.enqueue(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(q.dequeue());
        }
    }
}
