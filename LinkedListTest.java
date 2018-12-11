import java.util.*;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //将b的元素放入a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //从b移除每第二个词
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();  // 跳到下一个元素
                bIter.remove();  // 移除那个元素
            }
        }

        System.out.println(b);

        // 批量操作：从a移除所有b中的词
        a.removeAll(b);
        System.out.println(a);
    }
}


/* 
输出:

[Amy, Bob, Carl, Doug, Erica, Frances, Gloria]
[Bob, Frances]
[Amy, Carl, Doug, Erica, Gloria]

LinkedList底层是链表实现，对于随机访问并不支持，所以如果需要随机访问请使用ArrayList，但是LinkedList对
插入与删除数据的操作十分高效，对于大量的数据倾向于使用LinkedList。

*/


