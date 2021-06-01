package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/4/6 9:43 下午
 */
public class Test {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || nums[i - 2] < n) {
                nums[i++] = n;
            }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
////        int[] nums = {0,0,1,1,1,1,2,3,3};
//        System.out.println(removeDuplicates(nums));
//        for (int num : nums) {
//            System.out.println(num);
//        }
        //(?<=<span class="read-count">阅读数：)\d+
//        String reg = "(?<=<span class=\"read-count\">阅读数：)\\d+";
//        String reg = "\\d+(?=</span>)";
//        String test = "<span class=\"read-count\">阅读数：641</span>";
        String reg = "祖国(?!的花朵)";
        String test = "我爱祖国，我是祖国的花朵";
//        String test = "@27='浙江省杭州市江干区九堡街道九昌路=39号'";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        while (mc.find()) {
            System.out.println(mc.group());
        }

    }
}
