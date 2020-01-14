import java.util.Iterator;

public class MainClass {
    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        ls.push("1");
        ls.push("2");
        ls.push("3");
        ls.push("4");

        System.out.println(ls.toString());
        ls.pop("1");
        System.out.println(ls.toString());

        System.out.println(ls.peek());
    }
}