package leecode;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Algorithms_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// babad
		System.err.println(longestPalindrome("babad"));
	}

	/**
	 * 中心扩散法
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length() -1; i++) {
			int case1 = expandAroundCenter(s, i, i);
			int case2 = expandAroundCenter(s, i, i + 1);
			int length = Math.max(case1, case2);
			if (length > end - start) {
				start = i -(length - 1) / 2;
				end = i + length / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandAroundCenter(String s, int left, int right) {
		while (left>=0 && right < s.length() &&  s.charAt(left) == s.charAt(right)) {
			-- left;
			++ right;
		}
		return right - left -1;
	}
}
