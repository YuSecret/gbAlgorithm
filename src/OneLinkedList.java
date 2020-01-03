public class OneLinkedList<T> {
    private Node first;
    private int size = 0;

    private class Node<T> {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }
    public void append(T value) {
        Node  nd = new Node(value, first);;
        first = nd;
        size++;
    }
    public void appendToIndex(T value, int ind) {
        if (ind < 0 || ind >size) {
            new IndexOutOfBoundsException();
        }
        if (ind == 0) {
            append(value);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < ind - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    public boolean delete(T value){
        if(isEmpty()){
            return false;
        }
        if(first.value.equals(value)){
            Node oldFirst = first;
            first = first.next;
            size--;
            return true;
        }
        Node current = first;
        while(current.next != null && !current.next.value.equals(value)){
            current = current.next;
        }
        if(current.next == null){
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }
    private int index(T value) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append( (current.next!=null) ? current.value.toString() + ", " : current.value.toString());
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
