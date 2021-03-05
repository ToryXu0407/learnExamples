import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: toryxu
 * @Date: 2019/3/20 0020 10:00
 * @Version 1.0
 */
public class retur {
    public int getreturn() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.get(0));
        return list.get(0);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.remove("fuck");
        System.out.println("hello");

        int i =1;
        i=++i;
        System.out.println(i);
    }
}
