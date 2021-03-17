package daxi;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/2/23 8:18 下午
 */
public class DaXiTest {

    public static void main(String[] args) {
        int a = 10;
        long test = 012;
        System.out.println(012);
//        //第一题
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] interval2 = {{1, 4}, {1, 5}};
//        merge(intervals);
//        merge(interval2);
//
//        //第二题
//        System.out.println(valid("internationalization", "i12iz4n"));
//        System.out.println(valid("apple", "a2e"));
//
//        //第三题
//        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 2}};
//        int[][] edges2 = {{1, 2, 1}, {2, 3, 3}, {1, 4, 2}, {3, 5, 5}, {4, 5, 4}};
//        int[][] edges3 = {{1, 2, 1}, {2, 4, 3}, {1, 4, 2}};
//        System.out.println(minPath(3, edges, 1, 3));
//        System.out.println(minPath(5, edges2, 1, 5));
//        System.out.println(minPath(5, edges3, 1, 5));
    }

    /**
     * 第一题
     * 合并时间区间
     * 只有当后者的t[0]>前者的t[1]时，数组添加
     * 时间复杂度为O(n)
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int[][] result = new int[10][2];
        int left = 0, right = 0, index = -1;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                index++;
                left = interval[0];
                right = interval[1];
                result[index][0] = left;
                result[index][1] = right;
            } else {
                right = interval[1];
                result[index][1] = right;
            }
        }
        return result;
    }

    /**
     * 第二题
     * 缩写校验
     * 通过遍历abbr来驱动遍历word，
     * 若abbr遍历过程中匹配失败或者遍历完word.length()>0，则代表匹配失败
     * 时间复杂度为O(n)
     * 不考虑除字母和数字以外的情况
     *
     * @param word
     * @param abbr
     * @return
     */
    public static boolean valid(String word, String abbr) {
        int times = 0;
        while (abbr.length() > 0) {
            times++;
            StringBuilder temp = new StringBuilder();
            int i = 0;
            if (abbr.charAt(i) >= 'A' && abbr.charAt(i) <= 'z') {
                temp.append(abbr.charAt(i));
                i++;
                if (!word.substring(0, i).equals(temp.toString())) {
                    return false;
                }
                word = word.substring(i);

            } else {
                while (abbr.charAt(i) > '0' && abbr.charAt(i) < '9') {
                    temp.append(abbr.charAt(i));
                    i++;
                }
                int nLength = Integer.parseInt(temp.toString());
                if (word.length() < nLength) {
                    return false;
                }
                word = word.substring(nLength);
            }

            abbr = abbr.substring(i);
        }
        System.out.println("遍历次数:" + times);
        return word.length() <= 0;
    }

    /**
     * 第三题
     * 递归，
     * 若当前front=start，进入递归
     * 若当前tail=end，结束递归，并返回值
     *
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    public static int minPath(int n, int[][] edges, int start, int end) {
        int result = Integer.MAX_VALUE;
        int value = 0;
        for (int i = 0; i < n; i++) {
            value = edges[i][2];
            if (edges[i][0] == start) {
                value = value | minPath(n, edges, edges[i][1], end);
            }
            if (edges[i][1] == end) {
                if (value < result) {
                    result = value;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
