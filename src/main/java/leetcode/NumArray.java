package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/5/25 8:36 下午
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 前缀和
 * sumRange(i,j) = sumRange(i,j)-sumRange(0,i-1)
 * 一次遍历把每个下标的前缀和维护起来就可以了
 */
class NumArray {

    List<Integer> sums = new ArrayList<>();

    public NumArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sums.add(sum);
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sums.get(right);
        }
        return sums.get(right) - sums.get(left - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
