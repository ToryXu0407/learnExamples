package leetcode;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/4/20 9:37 下午
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int nIndex = 0;
        int index = haystack.indexOf(needle.charAt(0));
        if (index < 0) {
            return -1;
        }
        for (int i = index; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(nIndex)) {
                nIndex++;
                if (nIndex == needle.length()) {
                    return index;
                }
            } else {
                nIndex = 0;
                index = haystack.indexOf(needle.charAt(0), index + 1);
                if (index < 0) {
                    return -1;
                }
                i = index - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.printf("" + new Solution().strStr("mississippi", "sippj"));
        double a = 563349.08;
        System.out.println((int)Math.round(a*100));
        System.out.println(a*100);
    }
}
