import java.util.HashMap;
import java.util.Map;

/**
 * @Author: toryxu
 * @Date: 2018/11/12 0012 13:21
 * @Version 1.0
 */
public class fanxing {
    volatile int a = 1;
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1","fuck");
        map.put("2",1);
        System.out.println(map);
    }
}
