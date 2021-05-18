package leecode;

/**
 * leetcode 28 实现strStr()
 * 
 * 朴素解法 时间复杂度 O(mxn)
 * 进阶解法 KMP 算法 时间复杂度为O(m+n)
 * @author renqi
 *
 */
public class Algorithms_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi","issip"));
	}

    public static int strStr(String haystack, String needle) {
    	if (needle == null || needle.length() < 1) {
			return 0;
		}
    	if (haystack == null || haystack.length() < 1) {
			return -1;
		}
    	if (haystack.length() < needle.length()) {
			return -1;
		}
    	for (int i = 0; i < haystack.length(); i++) {
    		// 找到第一个相同的char，并且后续的长度字符长度必须至少和目标字符长度相同
			if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()) {
				int j = i;
				for (; j < i + needle.length(); ) {
					if (haystack.charAt(j) == needle.charAt(j-i)) {
						j++;
					}else {
						break;
					}
				}
				if (j - i == needle.length()) {
					return i;
				}
			}
		}
    	return -1;
    }
}
