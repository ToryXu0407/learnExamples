import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: toryxu
 * @Date: 2018/9/27 0027 9:08
 * @Version 1.0
 */
public class split {


    public static void main(String[] args) {
       //Long a = 1000000000L;
        //int b = a.intValue();
//        String tagId = ",1,2,3,4,";
//       // tagId = tagId.substring(1,tagId.length());
//        String[] a=tagId.split(",");
//        List<String> list = Arrays.asList(a);
//        System.out.println(list);
        Date date = new Date();
        String time  = System.currentTimeMillis()+"";
        System.out.println(time);
        System.out.println(time.substring(0,8));
    }           
}
