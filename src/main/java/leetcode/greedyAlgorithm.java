package leetcode;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/5/14 3:53 下午
 */
public class greedyAlgorithm {

    //整数转罗马数字
    //例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    //
    //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    //
    //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    //给你一个整数，将其转为罗马数字。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/integer-to-roman
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String intToRoam(int num) {
        StringBuilder sb = new StringBuilder();
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < romans.length; i++) {
            int count = num / numbers[i];
            if (count >= 1) {
                for (int i1 = 0; i1 < count; i1++) {
                    sb.append(romans[i]);
                }
                num = num % numbers[i];
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoam(3421));
    }
}
