import java.util.Random;
import java.util.TreeMap;

public class Lesson5 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer rnd=0;

        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, String> map = new MyTreeMap<>();
            System.out.println("-----map"+(i+1)+"-----");

            do {
                rnd=100-random.nextInt(200);
                map.put(rnd, rnd.toString());
            } while (map.getMaxDepth()!=6);

            System.out.println(map);
            System.out.println("-----map"+(i+1)+" size: "+map.size());
        }
    }
}
