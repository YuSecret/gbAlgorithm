import java.util.ArrayList;
import java.util.Comparator;

public class FirstArrayList <T extends Comparable> {
    private T[] list;
    private int size = 0;
    private int capacity = 0;
    private final int DEF_CAPACITY = 5;

    public FirstArrayList(int capa) {
        if (capa<0) {
            throw new ExceptionInInitializerError("Capacity error");
        }
        list = (T[]) new Comparable[capa];
        capacity=capa;
    }
    public FirstArrayList() {
        list = (T[]) new Comparable[DEF_CAPACITY];
        capacity=DEF_CAPACITY;
    }
    public void add (T el) {
        if (size==capacity) {
            capacity+=DEF_CAPACITY;
            T [] newlist = (T[]) new Comparable[capacity];
            System.arraycopy(list,0, newlist , 0, size);
            list=newlist;
        }
        list[size] = el;
        size++;
    }
    public void delete(int index) {
        if (index>=size) {
            throw new ExceptionInInitializerError("Cannot delete element. index not correct");
        }
        for (int i=index; i<size; i++) {
            list[i]=list[i+1];
        }
        list[size]=null;
        size--;
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }
    public T get(int index) {
        return list[index];
    }
    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < size; j++) {
                if( list[j].compareTo(list[imin])<0){
                    imin = j;
                }
            }
            swap(i, imin);
        }
    }
    public void insertionSort(){
        T key;
        for (int i = 1; i <size ; i++) {
            int j = i;
            key  = list[i];
            while(j>0 && key.compareTo(list[j-1])<0){
                list[j] = list[j-1];
                j--;
            }
            list[j] = key;
        }
    }
    public void bubbleSort(Comparator<T> comparator){
        boolean isSwap;
        for (int i = size-1; i > 0 ; i--) {
            isSwap = false;
            for (int j = 0; j < i ; j++) {
                if( comparator.compare(list[j+1],list[j])<0 ){
                    swap(j+1, j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    public void bubbleSort() {
        bubbleSort(Comparator.naturalOrder());
    }
}
