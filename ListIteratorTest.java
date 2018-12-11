import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        Integer i = 0;
        while (i < 10) {
            i++;
            a.add(i);
        }   
        ListIterator<Integer> aIter = a.listIterator(5);
        System.out.println(aIter.next());
        System.out.println(aIter.next());
    }
}

/*
输出：
6
7 
 */