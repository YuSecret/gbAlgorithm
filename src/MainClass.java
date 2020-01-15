import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.List;

public class MainClass {
    private static int bestPrice;
    private static ArrayList<Box> bestBoxes;
    private static final int MAX_SIZE = 15;

    public static void main(String[] args) {
        //1. Написать программу по возведению числа в степень с помощью рекурсии.
        System.out.println(stepen(2,0));
        System.out.println(recStepen(2,10));
        //2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
        ArrayList<Box> arrayList= new ArrayList <Box>();

        arrayList.add(new Box(11,2));
        arrayList.add(new Box(21,3));
        arrayList.add(new Box(4,12));

        recSearch(arrayList);

        System.out.println(bestBoxes);
    }
    static void recSearch(ArrayList<Box> arrayList) {
        if (arrayList.size()==0) {return;}
        int sumW = calcWeight(arrayList);
        int sumP = calcPrice(arrayList);
        if (bestBoxes==null) {
            if (sumW<=MAX_SIZE) {
                bestPrice = calcPrice(arrayList);
                bestBoxes = arrayList;
            }
        }
        else {
            if(sumW <= MAX_SIZE && sumP>bestPrice) {
                bestBoxes = arrayList;
                bestPrice = calcPrice(arrayList);
            }
        }
        for(Box b:arrayList) {
            ArrayList<Box> arrayListCopy = new ArrayList<Box>(arrayList);
            arrayListCopy.remove(b);
            recSearch(arrayListCopy);
        }
    }
    static int calcPrice(ArrayList<Box> arl) {
        int res = 0;
        for(Box b: arl) {
            res+=b.p;
        }
        return res;
    }
    static int calcWeight(ArrayList<Box> arl) {
        int res = 0;
        for(Box b: arl) {
            res+=b.w;
        }
        return res;
    }
    static class Box {
        private int w;
        private int p;
        Box(int weight, int price) {
            this.w = weight;
            this.p = price;
        }
        public String toString() {
            return String.format("w:%d p:%d",w,p);
        }
    }
    public static int stepen(int n, int stepen) {
        int res=1;
        for (int i = 1; i<=stepen; i++) {
            res*=n;
        }
        return (res);
    }
    public static int recStepen(int n, int stepen) {
        if (stepen==0) {return 1;}
        if (stepen==1) {return n;}
        return n*recStepen(n,stepen-1);
    }
}