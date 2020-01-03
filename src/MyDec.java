import java.util.EmptyStackException;

public class MyDec<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;


    public MyDec(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDec() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[end] = value;
        size++;
        end = nextIndex(end);

    }

    public void insertLeft(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        System.arraycopy(list,0,list,1,size-1);
        list[begin] = value;

        end = nextIndex(end);

    }
    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }
    public T removeRight() {
        T temp = peekRight();
        size--;
        list[end] = null;
        end = nextIndex(end);
        return temp;
    }
    public T peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }
    public T peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end];
    }
    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public String toString() {
        String result = "[";
        for (int i = 0 ; i <size; i++) {
            result += " "+list[i];
        }
        result += " ]";
        return result;
    }
}
