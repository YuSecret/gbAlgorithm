public class LinkedStack <T>{
    private TwoLinkedList<T> tll = new TwoLinkedList<>();
    public int size(){
        return tll.size();
    }

    public boolean isEmpty(){
        return tll.isEmpty();
    }

    public void push(T value){
        tll.insertFirst(value);
    }

    public T pop(T value){
        return tll.removeLast();
    }

    public T peek(){
        return tll.getLast();
    }
    @Override
    public String toString() {
        return tll.toString();
    }
}
