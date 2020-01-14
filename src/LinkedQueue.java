public class LinkedQueue<T> {
    private TwoLinkedList<T> queue = new TwoLinkedList<>();

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void enqueue(T value){
        queue.insertLast(value);
    }

    public T dequeue(){
        return queue.removeFirst();
    }

    public T peek(){
        return queue.getFirst();
    }
}