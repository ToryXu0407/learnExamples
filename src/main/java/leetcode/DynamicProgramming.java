package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/5/12 7:40 下午
 * 动态规划
 * 穷举分析（从长度为1开始判断）
 * 确定边界
 * 找规律，确定最优子结构
 * 状态转移方程
 */
public class DynamicProgramming {

    //爬楼梯
    //
    public static int fStair(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //第一步：穷举：
    //假如nums[0]后面的数都比nums[0]小，长度为1
    //{0}->1
    //{0,-1)->1
    //{0,5}->2
    //{0,5,0}->2
    //{0,5-6}->3
    //定义dp[i]为i位nums的最长严格递增子序列的长度
    //dp[i]就是在i之前，比nums[i]的dp[j]的最长严格递增子序列+1的值中最大的那个
    //如果一个j都没有，那么dp[i]=1
    //如果i=1，那么dp[i]=1
    //dp[i] = max(dp[j])+1 (j-<[0,i-1),nums[j]<nums[i]
    public int lengthOfLIS(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    /**
     * 解：
     * 第一步：穷举
     * {1}->1
     * {1,1}->2
     * {1,-1}->0
     * 第二步：确定边界
     * dp[0] = 0
     * 第三步：最优子结构
     * dp[i] = Math.max(dp[j]+nums[i],nums[i]) (j-<[0,i)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }

    /**
     * 你一个整数数组 arr 。
     * <p>
     * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
     * <p>
     * a 和 b 定义如下：
     * <p>
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * 注意：^ 表示 按位异或 操作。
     * <p>
     * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return a==b即a^b=0即
     * arr[i]^....arr[k]=0
     * 即只要是个连续数组的异或值为0就可以，并且k>i
     * 如果数组长度为4，则有012\3，0\123，1\234这三种组合
     * 如果长度为3，则有01\2,0\12两种组合
     * 即n-1种组合
     */
    public static int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum ^= arr[j];
                if (sum == 0) {
                    ans += (j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
     * <p>
     * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
     * <p>
     * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param k
     * @return 0 0 0 0
     * 0 1 2 3
     * 0 2 3 4
     * 0 3 4 5
     * 最外层为dp添加的，用于做边界
     * dp[1][0] = 0,dp[0][1]=0,dp[0][0]=0
     * dp[i][j]=dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i-1][matrix[j-1]
     * 注意异或的话相同的值重复异或结果是一样的
     * 存到数组，排序.
     */
    public static int kthLargestValue(int[][] matrix, int k) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] dp = new int[m + 1][n + 1];
        List<Integer> list = new ArrayList<>();
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(dp[i][j]);
            }
        }
        list.sort(Comparator.comparingInt(Integer::intValue).reversed());
        return list.get(k - 1);
    }


    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * f(n) = max(f(n-1),prices[i]-min)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, -4, 1, 2, 3, -5};
//        int[] nums = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(nums));
//        System.out.println(fStair(4));
//        int k = 3;
//        int[][] matrix = {{5, 2}, {1, 6}};
//        System.out.println(kthLargestValue(matrix, k));
//        System.out.println(countBits(16));
        System.out.println(isSubsequence("asd", "addssdd"));
    }

    /**
     * a==b即a^b = 0
     * 即a[i]^...a[k]=0
     * 且 k>i
     *
     * @param arr
     * @return
     */
    public static int countTriplets2(int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                value ^= arr[j];
                if (value == sum) {
                    count += (j - i);
                }
            }
        }
        return count;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数
     * 穷举分析
     * 如果是1阶，则只有1
     * 如果是2阶，则有11，2 两种
     * 如果是3阶，则有111，12，21三种
     * 如果是4阶，则有1111，112，121，211，22 5种
     * 如果是5阶，则有11111,1112,1121,1211,122,2111,212,221 共8种
     * 确定边界
     * 1阶时，方法数为1
     * 2阶时，为2
     * 最优子结构
     * r(3)= r(2)+r(1)
     * r(4)=r(3)+r(2)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * 1.奇数一定比前面那个偶数多一个
     * 00,01
     * 10,11
     * 2.偶数中1的个数和除以2以后的一样多
     * 10，100，1000
     * 11，110，1110
     * <p>
     * <p>
     * <p>
     * 01100
     * 01011
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 进阶：
     * <p>
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence1(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }

    /**
     * 使用动态规划
     * 设置一个二维数组
     * i为t的下标,j为字母1-26，
     * 如果t[i] = j ,则 f[i][j] = i;
     * 如果不等于，则 f[i][j] = f[i+1][j]，
     * 比如说
     * abc
     * 如果j是b，f[0][b] = f[1][b] = 1。
     * 获得这个二维数组以后
     * 遍历s，
     * f[0][s[0]] ->获得t的下标，即t从0开始第一个碰到s[0]的位置，再从这个下标开始，
     * f[index][s]1]] -> index2
     * 如果index>s.length,直接返回false
     * 如果遍历完了s，返回true。
     * 由于是反向遍历
     * 边界值设置t的最后一位的f[t.length][j] 都= t.length;
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int tLength = t.length();
        int sLength = s.length();
        int[][] f = new int[tLength + 1][26];

        for (int i = 0; i < 26; i++) {
            f[tLength][i] = tLength;
        }

        for (int i = tLength - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (j == t.charAt(i) - 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int index = 0;
        for (int i = 0; i < sLength; i++) {
            index = f[index][s.charAt(i) - 'a'] + 1;
            if (index > tLength) {
                return false;
            }
        }
        return true;

    }
}
