package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * hash表法
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author renqi
 *
 */
public class Algorithms_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "pwwkew";
		//String string = " ";//"abba";
		//String string = "abcabcbb";
		//String string = "cdd"; //"abba"
		Integer count = lengthOfLongestSubstring(string);
		System.out.println(count);
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	// [char, index]
    	int result = 0;
    	Map<Character, Integer> teMap = new HashMap<Character, Integer>();
    	for (int start = 0,end = 0; end < s.length(); end++) {
    		char c = s.charAt(end);
			if (teMap.containsKey(c)) {
				// start 的移动是核心逻辑
				// 为什么要和上一个start比较,start 不是一定是 此时比较的上一个相同元素的(index+1) 吗？
				System.out.println(start+ "," + teMap.get(c));
				start = Math.max(teMap.get(c) + 1, start);
			}
			result = Math.max(end - start + 1, result);
			teMap.put(c, end);
		}
    	return result;
    }

}
